package com.dragcorp.cryptodashboard.client.response.coingecko;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChartResponse {
  List<List<BigDecimal>> prices;
  List<List<BigDecimal>> marketCaps;
  List<List<BigDecimal>> totalVolumes;

  @JsonCreator
  public ChartResponse(@JsonProperty("prices") List<List<BigDecimal>> prices,
                       @JsonProperty("market_caps") List<List<BigDecimal>> marketCaps,
                       @JsonProperty("total_volumes") List<List<BigDecimal>> totalVolumes) {
    this.prices = prices;
    this.marketCaps = marketCaps;
    this.totalVolumes = totalVolumes;
  }
}
