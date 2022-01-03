package com.dragcorp.cryptodashboard.client.response.cryptocompare;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleSourceInfoResponse {
  String name;
  String lang;
  String img;

  @JsonCreator
  public ArticleSourceInfoResponse(@JsonProperty("name") String name,
                                   @JsonProperty("lang") String lang,
                                   @JsonProperty("img") String img) {
    this.name = name;
    this.lang = lang;
    this.img = img;
  }
}
