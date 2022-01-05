import React, { useState } from "react";
import { Container, Logo, Group, Link } from "./style/menu.styled";

export default function Menu({ children, ...restProps }) {
  return <Container {...restProps}>{children}</Container>;
}

Menu.Logo = function MenuLogo({ children, ...restProps }) {
  return <Logo {...restProps}>{children}</Logo>;
};

Menu.Group = function MenuGroup({ children, ...restProps }) {
  return <Group {...restProps}>{children}</Group>;
};

Menu.Link = function MenuLink({ children, ...restProps }) {
  return <Link {...restProps}>{children}</Link>;
};
