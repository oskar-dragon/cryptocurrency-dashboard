import React, { useState } from "react";
import { Segment, Search } from "../Components";
import coinData from "../Data/Search.json";
import * as ROUTES from "../Constants/routes";

export default function Header() {
  const [filteredData, setFilteredData] = useState([]);

  function handleFilter(e) {
    const searchQuery = e.target.value;
    const newFilter = coinData.filter(coin =>
      coin.name.toLowerCase().includes(searchQuery.toLowerCase())
    );

    if (searchQuery === "") {
      setFilteredData([]);
    } else {
      setFilteredData(newFilter);
    }
  }

  return (
    <Segment>
      <Segment.InnerContainer align="center" justify={"flex-start"}>
        <Segment.Title>
          <Segment.Span>Hello... </Segment.Span>
          Oskar
        </Segment.Title>
      </Segment.InnerContainer>

      <Segment.InnerContainer>
        <Search>
          <Search.InputsWrapper>
            <Search.Input placeholder="Search..." onChange={handleFilter} />
            <Search.Icon />
          </Search.InputsWrapper>
          {filteredData.length > 0 && (
            <Search.ResultsList>
              {filteredData.slice(0, 15).map(coin => (
                <Search.ResultItem key={coin.apiId}>
                  <Search.ResultLink to={ROUTES.COIN_DETAILS}>
                    {coin.name}
                  </Search.ResultLink>
                </Search.ResultItem>
              ))}
            </Search.ResultsList>
          )}
        </Search>
      </Segment.InnerContainer>
    </Segment>
  );
}

// ResultWrapper
// ResultIcon
// ResultTitle
// ResultSymbol
