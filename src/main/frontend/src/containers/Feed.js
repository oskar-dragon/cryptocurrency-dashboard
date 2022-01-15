import React from "react";
import { Segment } from "../Components";
import counters from "../Data/counters.json";
import { PerformerContainer, NewsContainer } from "../Containers";

export default function FeedContainer() {
  return (
    <Segment justifyContent="space-around" direction="column" maxWidth="1200">
      <PerformerContainer data={counters.topGainers} title="Top Gainers" />
      <PerformerContainer data={counters.topLosers} title="Top Losers" />
      {/* <NewsContainer data={counters.news.news} /> */}
    </Segment>
  );
}
