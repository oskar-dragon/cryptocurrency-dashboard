import React, { useState } from "react";
import { Menu } from "../components";
import * as ROUTES from "../constants/routes";

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
          to={ROUTES.HOME}
        >
          Exchanges
        </Menu.Link>
        <Menu.Link active={currentLink === ROUTES.HOME} to={ROUTES.HOME}>
          Portfolio
        </Menu.Link>
        <Menu.Link active={currentLink === ROUTES.HOME} to={ROUTES.HOME}>
          Watchlist
        </Menu.Link>
        <Menu.Link active={currentLink === ROUTES.HOME} to={ROUTES.HOME}>
          Settings
        </Menu.Link>
      </Menu.Group>
    </Menu>
  );
}
