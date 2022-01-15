import React, { useState } from "react";
import { Card } from "../Components";

export default function PerformerContainer({ data, title }) {
  const [activeItem, setActiveItem] = useState("1h");
  const filterValues = ["1h", "1d", "7d", "1m"];

  function handleFilterClick(e) {
    const name = e.target.name;
    setActiveItem(name);
  }

  return (
    <Card>
      <Card.HeaderContainer flexDirection="row">
        <Card.HeaderTitle>{title}</Card.HeaderTitle>
        <Card.FiltersGroup>
          {filterValues.map(value => (
            <Card.Filter
              onClick={handleFilterClick}
              name={value}
              active={activeItem === value}
            >
              {value.toUpperCase()}
            </Card.Filter>
          ))}
        </Card.FiltersGroup>
      </Card.HeaderContainer>

      <Card.Content flexDirection={"column"}>
        {data.map((coin, index) => (
          <Card.CoinWrapper key={index}>
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
