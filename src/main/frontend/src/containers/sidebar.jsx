import React, { useState } from "react";
import { Menu } from "../components";
import * as ROUTES from "../constants/routes";

export default function Sidebar() {
  //TODO: Add state for checking which one is active and which one isn't.

  return (
    <Menu>
      <Menu.Logo>Coin Meerkat</Menu.Logo>
      <Menu.Group>
        <Menu.Link to={ROUTES.HOME}>Dashboard</Menu.Link>
        <Menu.Link to={ROUTES.HOME}>Exchanges</Menu.Link>
        <Menu.Link to={ROUTES.HOME}>Portfolio</Menu.Link>
        <Menu.Link to={ROUTES.HOME}>Watchlist</Menu.Link>
        <Menu.Link to={ROUTES.HOME}>Settings</Menu.Link>
      </Menu.Group>
    </Menu>
  );
}
