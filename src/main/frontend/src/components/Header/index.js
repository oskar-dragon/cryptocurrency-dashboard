import { Container, Title, Span, SubTitle } from "./style/Header.styled";

export default function Header({ children, ...restProps }) {
  return <Container {...restProps}>{children}</Container>;
}

Header.Title = function HeaderTitle({ children, ...restProps }) {
  return <Title {...restProps}>{children}</Title>;
};

Header.Span = function HeaderSpan({ children, ...restProps }) {
  return <Span {...restProps}>{children}</Span>;
};


