import React from "react";
import { NewsCard } from "../Components";
import { truncateString, convertDate } from "../Utils";

export default function NewsContainer({ data }) {
  return (
    <NewsCard>
      <NewsCard.HeaderTitle>News</NewsCard.HeaderTitle>
      <NewsCard.Content>
        {data.slice(0, 15).map(news => (
          <NewsCard.Container href={news.url} target="_blank">
            <NewsCard.Image url={news.title} />
            <NewsCard.Title>{truncateString(news.imageUrl, 40)}</NewsCard.Title>
            <NewsCard.LastUpdated>
              {convertDate(news.publishedOn)}
            </NewsCard.LastUpdated>
          </NewsCard.Container>
        ))}
      </NewsCard.Content>
    </NewsCard>
  );
}
