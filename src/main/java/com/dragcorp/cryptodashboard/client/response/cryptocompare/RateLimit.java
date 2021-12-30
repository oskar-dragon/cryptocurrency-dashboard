package com.dragcorp.cryptodashboard.client.response.cryptocompare;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateLimit {

  @JsonCreator
  public RateLimit() {
  }
}
