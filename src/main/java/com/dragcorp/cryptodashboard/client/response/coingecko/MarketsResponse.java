package com.dragcorp.cryptodashboard.client.response.coingecko;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketsResponse {
  List<CoinResponse> coins;

  @JsonCreator
  public MarketsResponse(List<CoinResponse> coins) {
    this.coins = coins;
  }
}
