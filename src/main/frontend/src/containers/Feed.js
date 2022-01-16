import React, { useState, useEffect } from "react";
import { Segment } from "../Components";
import CoinsService from "../Services/coinsService";
import NewsServices from "../Services/newsService";
import { PerformerContainer, NewsContainer } from "../Containers";

export default function FeedContainer() {
  const [topGainers, setTopGainers] = useState([]);
  const [topLosers, setTopLosers] = useState([]);
  const [news, setNews] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    CoinsService.getTopGainers().then(res => setTopGainers(res.data));
    CoinsService.getTopLosers().then(res => setTopLosers(res.data));
    NewsServices.getAllNews().then(res => setNews(res.data.news));
    setIsLoading(false);
  }, []);

  return (
    <Segment justifyContent="space-around" direction="column" maxWidth="1200">
      {isLoading ? (
        <div>Loading...</div>
      ) : (
        <>
          <PerformerContainer data={topGainers} title="Top Gainers" />
          <PerformerContainer data={topLosers} title="Top Losers" />
        </>
      )}
      <NewsContainer data={news} />
    </Segment>
  );
}
