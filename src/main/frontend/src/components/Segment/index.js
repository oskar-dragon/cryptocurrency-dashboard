import React from "react";
import { Container, InnerContainer } from "./style/Segment.styles";

export default function Segment({ children, ...restProps }) {
  return <Container {...restProps}>{children}</Container>;
}

Segment.InnerContainer = function SegmentInnerContainer({
  children,
  ...restProps
}) {
  return <InnerContainer {...restProps}>{children}</InnerContainer>;
};
