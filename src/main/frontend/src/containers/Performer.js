import React, { useState } from "react";
import { Card } from "../Components";

export default function PerformerContainer(props) {
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
        <Card.CoinWrapper>
          <Card.CoinTitle>Bitcoin</Card.CoinTitle>
          <Card.Price>$7.256.05</Card.Price>
          <Card.MarketCap>$12.5 Billions</Card.MarketCap>
          <Card.PriceChange>+$32.18(1.15%)</Card.PriceChange>
        </Card.CoinWrapper>
        <Card.CoinWrapper>
          <Card.CoinTitle>Bitcoin</Card.CoinTitle>
          <Card.Price>$7.256.05</Card.Price>
          <Card.MarketCap>$12.5 Billions</Card.MarketCap>
          <Card.PriceChange>+$32.18(1.15%)</Card.PriceChange>
        </Card.CoinWrapper>
        <Card.CoinWrapper>
          <Card.CoinTitle>Bitcoin</Card.CoinTitle>
          <Card.Price>$7.256.05</Card.Price>
          <Card.MarketCap>$12.5 Billions</Card.MarketCap>
          <Card.PriceChange>+$32.18(1.15%)</Card.PriceChange>
        </Card.CoinWrapper>
        <Card.CoinWrapper>
          <Card.CoinTitle>Bitcoin</Card.CoinTitle>
          <Card.Price>$7.256.05</Card.Price>
          <Card.MarketCap>$12.5 Billions</Card.MarketCap>
          <Card.PriceChange>+$32.18(1.15%)</Card.PriceChange>
        </Card.CoinWrapper>
      </Card.Content>
    </Card>
  );
}
