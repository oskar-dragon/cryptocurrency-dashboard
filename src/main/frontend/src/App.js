import React from "react";
import { CoinDetails } from "./pages";
import Home from "./pages/Home";
import * as ROUTES from "./constants/routes";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <Routes>
      <Route path={ROUTES.HOME} element={<Home />} />
      <Route path={ROUTES.COIN_DETAILS} element={<CoinDetails />} />
    </Routes>
  );
}

export default App;
