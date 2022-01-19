package com.dragcorp.cryptodashboard.client.response.coingecko;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Roi {
  BigDecimal times;
  String currency;
  BigDecimal percentage;

  @JsonCreator
  public Roi(@JsonProperty("times") BigDecimal times,
             @JsonProperty("currency") String currency,
             @JsonProperty("percentage") BigDecimal percentage
  ) {
    this.times = times;
    this.currency = currency;
    this.percentage = percentage;
  }
}