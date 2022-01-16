import React, { useState, useEffect } from "react";
import { Segment, Header, Search } from "../Components";
import CoinsService from "../Services/coinsService";
import * as ROUTES from "../Constants/routes";

export default function HeaderContainer() {
  const [filteredData, setFilteredData] = useState([]);
  const [coins, setCoins] = useState([]);

  function handleFilter(e) {
    const searchQuery = e.target.value;
    const newFilter = coins.filter(coin =>
      coin.name.toLowerCase().includes(searchQuery.toLowerCase())
    );

    if (searchQuery === "") {
      setFilteredData([]);
    } else {
      setFilteredData(newFilter);
    }
  }

  useEffect(() => {
    CoinsService.getAllCoins().then(res => setCoins(res.data));
  }, []);

  return (
    <Segment justifyContent="space-between">
      <Header>
        <Header.Title>
          <Header.Span>Hello... </Header.Span>
          Oskar
        </Header.Title>
      </Header>

      <Search>
        <Search.InputsWrapper>
          <Search.Input placeholder="Search..." onChange={handleFilter} />
          <Search.Icon />
        </Search.InputsWrapper>
        {filteredData.length > 0 && (
          <Search.ResultsList>
            {filteredData.slice(0, 15).map((coin, index) => (
              <Search.ResultItem key={index}>
                <Search.ResultLink to={ROUTES.COIN_DETAILS}>
                  {coin.name}
                </Search.ResultLink>
              </Search.ResultItem>
            ))}
          </Search.ResultsList>
        )}
      </Search>
    </Segment>
  );
}
