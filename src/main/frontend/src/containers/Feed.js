import React from "react";
import { Segment } from "../Components";
import counters from "../Data/counters.json";
import { PerformerContainer } from "../Containers";

export default function FeedContainer() {
  return (
    <Segment justifyContent="space-around" direction="column" maxWidth="1300">
      <PerformerContainer data={counters.topGainers} />
      <PerformerContainer data={counters.topLosers} />
      <PerformerContainer data={counters.topLosers} />
    </Segment>
  );
}
