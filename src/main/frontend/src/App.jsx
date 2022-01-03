import React from "react";
import { Home, CoinDetails } from "./pages";
import { Sidebar } from "./containers";
import * as ROUTES from "./constants/routes";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <>
      <Sidebar />
      <Routes>
        <Route path={ROUTES.HOME} element={<Home />} />
        <Route path={ROUTES.COIN_DETAILS} element={<CoinDetails />} />
      </Routes>
    </>
  );
}

export default App;
