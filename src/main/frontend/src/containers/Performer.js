import React, { useState } from "react";
import { Card } from "../Components";

export default function PerformerContainer(data) {
  const [activeItem, setActiveItem] = useState("1h");

  function handleFilterClick(e) {
    const name = e.target.name;
    setActiveItem(name);
  }

  return (
    <Card>
      <Card.HeaderContainer flexDirection={"row"}>
        <Card.HeaderTitle>Top Performers</Card.HeaderTitle>
        <Card.FiltersGroup>
          <Card.Filter
            onClick={handleFilterClick}
            name="1h"
            active={activeItem === "1h"}
          >
            1H
          </Card.Filter>
          <Card.Filter
            onClick={handleFilterClick}
            name="1d"
            active={activeItem === "1d"}
          >
            1D
          </Card.Filter>
          <Card.Filter
            onClick={handleFilterClick}
            name="7d"
            active={activeItem === "7d"}
          >
            7D
          </Card.Filter>
          <Card.Filter
            onClick={handleFilterClick}
            name="1m"
            active={activeItem === "1m"}
          >
            1M
          </Card.Filter>
        </Card.FiltersGroup>
      </Card.HeaderContainer>

      <Card.Content flexDirection={"column"}>
        {data.data.map(coin => (
          <Card.CoinWrapper>
            <Card.CoinTitle>{coin.name}</Card.CoinTitle>
            <Card.Price>${coin.currentPrice}</Card.Price>
            <Card.MarketCap>{coin.symbol.toUpperCase()}</Card.MarketCap>
            <Card.PriceChange>
              {coin.priceChangePerc24h.toFixed(2)} %
            </Card.PriceChange>
          </Card.CoinWrapper>
        ))}
      </Card.Content>
    </Card>
  );
}
