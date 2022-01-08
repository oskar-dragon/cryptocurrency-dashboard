import React from "react";
import {
  Container,
  InnerContainer,
  Title,
  SubTitle,
  Span,
} from "./style/Segment.styles";

export default function Segment({ children, ...restProps }) {
  return <Container {...restProps}>{children}</Container>;
}

Segment.InnerContainer = function SegmentInnerContainer({
  children,
  ...restProps
}) {
  return <InnerContainer {...restProps}>{children}</InnerContainer>;
};

Segment.Title = function SegmentTitle({ children, ...restProps }) {
  return <Title {...restProps}>{children}</Title>;
};

Segment.SubTitle = function SegmentSubTitle({ children, ...restProps }) {
  return <SubTitle {...restProps}>{children}</SubTitle>;
};

Segment.Span = function SegmentSpan({ children, ...restProps }) {
  return <Span {...restProps}>{children}</Span>;
};
