import React from "react";
import { Home, CoinDetails, NotFound } from "./Pages";
import { Sidebar } from "./Containers";
import * as ROUTES from "./Constants/routes";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <>
      {/* <Sidebar /> */}
      <Routes>
        <Route path={ROUTES.HOME} element={<Home />} />
        <Route path={ROUTES.COIN_DETAILS} element={<CoinDetails />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </>
  );
}

export default App;
