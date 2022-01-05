import React, { useState, useEffect } from "react";
import axios from "axios";
import { Card } from "../Components";

export default function MainContent() {
  const [data, setData] = useState({});
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    axios.get("http://localhost:8080/api/v1/dashboard/gbp").then(res => {
      const data = res.data;
      setData(data.counters);
      console.log(data.counters);
    });
    setIsLoading(false);
  }, []);

  return isLoading ? (
    <h1>Loading...</h1>
  ) : (
    <Card>
      <Card.Header>
        <Card.Title>Top Performers</Card.Title>
        <Card.FiltersContainer>
          <Card.Filter>1H</Card.Filter>
          <Card.Filter>1D</Card.Filter>
          <Card.Filter>7D</Card.Filter>
          <Card.Filter>1M</Card.Filter>
        </Card.FiltersContainer>
      </Card.Header>

      <Card.DataContainer>
        {data.topGainers.map(coin => (
          <Card.DataRow>
            <Card.DataColumn>
              <Card.CoinName>{coin.name}</Card.CoinName>
              <Card.CoinMarketCap>{coin.totalVolume}</Card.CoinMarketCap>
            </Card.DataColumn>
            <Card.DataColumn>
              <Card.CoinPrice>{coin.currentPrice}</Card.CoinPrice>
              <Card.CoinPriceChange>
                % {coin.priceChangePerc24h}
              </Card.CoinPriceChange>
            </Card.DataColumn>
          </Card.DataRow>
        ))}
      </Card.DataContainer>
    </Card>
  );
}
