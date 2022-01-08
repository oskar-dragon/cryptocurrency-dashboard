import React from "react";
import { Home, CoinDetails, NotFound } from "./Pages";
import { Sidebar } from "./Containers";
import { PageWrapper } from "./Components";
import * as ROUTES from "./Constants/routes";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <>
      <PageWrapper>
        <PageWrapper.Aside>
          <Sidebar />
        </PageWrapper.Aside>
        <PageWrapper.Main>
          <Routes>
            <Route path={ROUTES.HOME} element={<Home />} />
            <Route path={ROUTES.COIN_DETAILS} element={<CoinDetails />} />
            <Route path="*" element={<NotFound />} />
          </Routes>
        </PageWrapper.Main>
      </PageWrapper>
    </>
  );
}

export default App;
