import React from "react";
import ReactDOM from "react-dom";
import App from "./App";
import { BrowserRouter as Router } from "react-router-dom";
import GlobalStyle from "./global-styles";
import { configureStore } from "@reduxjs/toolkit";

ReactDOM.render(
  <Router>
    <GlobalStyle />
    <App />
  </Router>,
  document.getElementById("root")
);
