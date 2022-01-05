import React, { useState } from "react";
import { Menu } from "../Components";
import * as ROUTES from "../Constants/routes";

export default function Sidebar() {
  const [currentLink, setCurrentLink] = useState(ROUTES.HOME);

  function handleClick(route) {
    setCurrentLink(route);
  }

  return (
    <Menu>
      <Menu.Logo>Coin Meerkat</Menu.Logo>
      <Menu.Group>
        <Menu.Link
          onClick={() => handleClick(ROUTES.HOME)}
          active={currentLink === ROUTES.HOME}
          to={ROUTES.HOME}
        >
          Dashboard
        </Menu.Link>
        <Menu.Link
          onClick={() => handleClick(ROUTES.COIN_DETAILS)}
          active={currentLink === ROUTES.COIN_DETAILS}
          to={ROUTES.COIN_DETAILS}
        >
          Exchanges
        </Menu.Link>
        <Menu.Link to={"404"}>Portfolio</Menu.Link>
        <Menu.Link to={"404"}>Watchlist</Menu.Link>
        <Menu.Link to={"404"}>Settings</Menu.Link>
      </Menu.Group>
    </Menu>
  );
}
