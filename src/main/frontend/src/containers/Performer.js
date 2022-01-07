import React, { useState } from "react";
import { Card } from "../Components";

export default function PerformerContainer(props) {
  const [activeItem, setActiveItem] = useState("1h");

  return (
    <Card>
      <Card.Content flexDirection={"row"}>
        <Card.Header>Top Performers</Card.Header>
        <Card.FiltersGroup>
          <Card.Filter active={activeItem === "1h"}>1H</Card.Filter>
          <Card.Filter active={activeItem === "1d"}>1D</Card.Filter>
          <Card.Filter active={activeItem === "7d"}>7D</Card.Filter>
          <Card.Filter active={activeItem === "1m"}>1M</Card.Filter>
        </Card.FiltersGroup>
      </Card.Content>

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
      </Card.Content>
    </Card>
  );
}
