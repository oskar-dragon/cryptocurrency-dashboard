import React, { useState } from "react";
import { BiSearchAlt } from "react-icons/bi";

import {
  Container,
  InputsWrapper,
  Input,
  Icon,
  ResultsList,
  ResultItem,
  ResultLink,
} from "./style/Search.styles";

export default function Search({ data, children, ...restProps }) {
  return <Container {...restProps}>{children}</Container>;
}

Search.InputsWrapper = function SearchInputsWrapper({
  children,
  ...restProps
}) {
  return <InputsWrapper {...restProps}>{children}</InputsWrapper>;
};

Search.Input = function SearchInput({ placeholder, children, ...restProps }) {
  return (
    <Input type="text" placeholder={placeholder} {...restProps}>
      {children}
    </Input>
  );
};

Search.Icon = function SearchIcon({ ...restProps }) {
  return (
    <Icon {...restProps}>
      <BiSearchAlt />
    </Icon>
  );
};

Search.ResultsList = function SearchResultsList({ children, ...restProps }) {
  return <ResultsList {...restProps}>{children}</ResultsList>;
};

Search.ResultItem = function SearchResultItem({ children, ...restProps }) {
  return <ResultItem {...restProps}>{children}</ResultItem>;
};

Search.ResultLink = function SearchResultLink({ to, children, ...restProps }) {
  return (
    <ResultLink to={to} {...restProps}>
      {children}
    </ResultLink>
  );
};
