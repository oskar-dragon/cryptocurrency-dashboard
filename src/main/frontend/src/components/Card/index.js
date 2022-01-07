import React from "react";
import {
  Group,
  Container,
  Content,
  HeaderContainer,
  HeaderTitle,
  FiltersGroup,
  Filter,
  CoinTitle,
  MarketCap,
  Price,
  PriceChange,
  CoinWrapper,
} from "./style/Card.styles";

export default function Card({ children, ...restProps }) {
  return <Container {...restProps}>{children}</Container>;
}

Card.Group = function CardGroup({ children, ...restProps }) {
  return <Group {...restProps}>{children}</Group>;
};

Card.Content = function CardContent({ children, ...restProps }) {
  return <Content {...restProps}>{children}</Content>;
};

Card.HeaderContainer = function CardHeaderContainer({
  children,
  ...restProps
}) {
  return <HeaderContainer {...restProps}>{children}</HeaderContainer>;
};

Card.HeaderTitle = function CardTitle({ children, ...restProps }) {
  return <HeaderTitle {...restProps}>{children}</HeaderTitle>;
};

Card.FiltersGroup = function CardFiltersGroup({ children, ...restProps }) {
  return <FiltersGroup {...restProps}>{children}</FiltersGroup>;
};

Card.Filter = function CardFilter({ children, ...restProps }) {
  return <Filter {...restProps}>{children}</Filter>;
};

Card.CoinTitle = function CardCoinTitle({ children, ...restProps }) {
  return <CoinTitle {...restProps}>{children}</CoinTitle>;
};

Card.MarketCap = function CardMarketCap({ children, ...restProps }) {
  return <MarketCap {...restProps}>{children}</MarketCap>;
};

Card.Price = function CardPrice({ children, ...restProps }) {
  return <Price {...restProps}>{children}</Price>;
};

Card.PriceChange = function CardPriceChange({ children, ...restProps }) {
  return <PriceChange {...restProps}>{children}</PriceChange>;
};

Card.CoinWrapper = function CardCoinTitle({ children, ...restProps }) {
  return <CoinWrapper {...restProps}>{children}</CoinWrapper>;
};
