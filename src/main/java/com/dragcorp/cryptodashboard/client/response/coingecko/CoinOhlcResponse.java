package com.dragcorp.cryptodashboard.client.response.coingecko;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinOhlcResponse {
  List<List<BigDecimal>> ohlcData;

  @JsonCreator
  public CoinOhlcResponse(List<List<BigDecimal>> ohlcData) {
    this.ohlcData = ohlcData;
  }
}
