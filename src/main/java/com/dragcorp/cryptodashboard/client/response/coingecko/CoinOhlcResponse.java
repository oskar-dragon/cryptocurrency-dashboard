package com.dragcorp.cryptodashboard.client.response.coingecko;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.List;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinOhlcResponse {
  List<List<BigDecimal>> ohlcData;

  @JsonCreator
  public CoinOhlcResponse(List<List<BigDecimal>> ohlcData) {
    this.ohlcData = ohlcData;
  }
}
