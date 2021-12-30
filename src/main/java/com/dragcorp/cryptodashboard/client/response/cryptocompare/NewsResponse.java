package com.dragcorp.cryptodashboard.client.response.cryptocompare;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsResponse {
  int type;
  String message;
  List<News> promoted;
  List<News> data;
  RateLimit rateLimit;
  boolean hasWarning;

  @JsonCreator
  public NewsResponse(
      @JsonProperty("Type") int type,
      @JsonProperty("Message") String message,
      @JsonProperty("Promoted") List<News> promoted,
      @JsonProperty("Data") List<News> data,
      @JsonProperty("RateLimit") RateLimit rateLimit,
      @JsonProperty("HasWarning") boolean hasWarning
  ) {
    this.type = type;
    this.message = message;
    this.promoted = promoted;
    this.data = data;
    this.rateLimit = rateLimit;
    this.hasWarning = hasWarning;
  }
}
