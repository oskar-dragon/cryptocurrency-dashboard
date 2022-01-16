import React from "react";
import {
  Container,
  HeaderTitle,
  Content,
  NewsContainer,
  Title,
  Image,
  LastUpdated,
} from "./style/NewsCard.styles";

export default function NewsCard({ children, ...restProps }) {
  return <Container {...restProps}>{children}</Container>;
}

NewsCard.HeaderTitle = function NewsCardHeaderTitle({
  children,
  ...restProps
}) {
  return <HeaderTitle {...restProps}>{children}</HeaderTitle>;
};

NewsCard.Content = function NewsCardContent({ children, ...restProps }) {
  return <Content {...restProps}>{children}</Content>;
};

NewsCard.Container = function NewsCardContainer({ children, ...restProps }) {
  return <NewsContainer {...restProps}>{children}</NewsContainer>;
};

NewsCard.Title = function NewsCardTitle({ children, ...restProps }) {
  return <Title {...restProps}>{children}</Title>;
};

NewsCard.Image = function NewsCardImage({ url, children, ...restProps }) {
  return (
    <Image src={url} {...restProps}>
      {children}
    </Image>
  );
};

NewsCard.LastUpdated = function NewsLastUpdated({ children, ...restProps }) {
  return <LastUpdated {...restProps}>{children}</LastUpdated>;
};
