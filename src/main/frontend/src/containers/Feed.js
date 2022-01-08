import React from "react";
import { Segment } from "../Components";
import counters from "../Data/counters.json";
import { PerformerContainer } from "../Containers";

export default function Feed() {
  return (
    <Segment flexDirection="row" width="1000px">
      <PerformerContainer data={counters.topGainers} />
      <PerformerContainer data={counters.topLosers} />
      <PerformerContainer data={counters.topLosers} />
    </Segment>
  );
}
