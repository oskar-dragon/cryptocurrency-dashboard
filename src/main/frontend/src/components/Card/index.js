import React from "react";
import {
  Container,
  Header,
  Title,
  FiltersContainer,
  Filter,
  DataContainer,
  DataRow,
  DataColumn,
  CoinName,
  CoinPrice,
  CoinMarketCap,
  CoinPriceChange,
} from "./style/Card.styles";

export default function Card({ children, ...restProps }) {
  return <Container {...restProps}>{children}</Container>;
}

Card.Header = function CardHeader({ children, ...restProps }) {
  return <Header {...restProps}>{children}</Header>;
};

Card.Title = function CardTitle({ children, ...restProps }) {
  return <Title {...restProps}>{children}</Title>;
};

Card.FiltersContainer = function CardFiltersContainer({
  children,
  ...restProps
}) {
  return <FiltersContainer {...restProps}>{children}</FiltersContainer>;
};

Card.Filter = function CardFilter({ children, ...restProps }) {
  return <Filter {...restProps}>{children}</Filter>;
};

Card.DataContainer = function CardDataContainer({ children, ...restProps }) {
  return <DataContainer {...restProps}>{children}</DataContainer>;
};

Card.DataRow = function CardDataRow({ children, ...restProps }) {
  return <DataRow {...restProps}>{children}</DataRow>;
};

Card.DataColumn = function CardDataColumn({ children, ...restProps }) {
  return <DataColumn {...restProps}>{children}</DataColumn>;
};

Card.CoinName = function CardCoinName({ children, ...restProps }) {
  return <CoinName {...restProps}>{children}</CoinName>;
};

Card.CoinPrice = function CardCoinPrice({ children, ...restProps }) {
  return <CoinPrice {...restProps}>{children}</CoinPrice>;
};

Card.CoinMarketCap = function CardCoinMarketCap({ children, ...restProps }) {
  return <CoinMarketCap {...restProps}>{children}</CoinMarketCap>;
};

Card.CoinPriceChange = function CardCoinPriceChange({
  children,
  ...restProps
}) {
  return <CoinPriceChange {...restProps}>{children}</CoinPriceChange>;
};
