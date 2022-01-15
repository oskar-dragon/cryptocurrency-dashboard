import React from "react";
import { NewsCard } from "../Components";

export default function NewsContainer({ data }) {
  return (
    <NewsCard>
      <NewsCard.HeaderTitle>News</NewsCard.HeaderTitle>
      <NewsCard.Content>
        <NewsCard.Container>
          <NewsCard.Image url={data[0].title} />
          <NewsCard.Title>{data[0].imageUrl}</NewsCard.Title>
          <NewsCard.LastUpdated>{data[0].publishedOn}</NewsCard.LastUpdated>
        </NewsCard.Container>
        <NewsCard.Container>
          <NewsCard.Image />
          <NewsCard.Title>Title</NewsCard.Title>
          <NewsCard.LastUpdated>10:00PM 24-08-2022</NewsCard.LastUpdated>
        </NewsCard.Container>
        <NewsCard.Container>
          <NewsCard.Image />
          <NewsCard.Title>Title</NewsCard.Title>
          <NewsCard.LastUpdated>10:00PM 24-08-2022</NewsCard.LastUpdated>
        </NewsCard.Container>
      </NewsCard.Content>
    </NewsCard>
  );
}
