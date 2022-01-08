import React from "react";
import { Wrapper, Aside, Main } from "./style/PageWrapper.styles";

export default function PageWrapper({ children, ...restProps }) {
  return <Wrapper {...restProps}>{children}</Wrapper>;
}

PageWrapper.Aside = function PageWrapperAside({ children, ...restProps }) {
  return <Aside {...restProps}>{children}</Aside>;
};

PageWrapper.Main = function PageWrapperMain({ children, ...restProps }) {
  return <Main {...restProps}>{children}</Main>;
};
