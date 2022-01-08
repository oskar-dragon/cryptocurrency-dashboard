package com.dragcorp.cryptodashboard.client;

import com.dragcorp.cryptodashboard.client.response.cryptocompare.NewsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Component
public class CryptoCompareClient {
  private final String BASE_URL = "https://min-api.cryptocompare.com/data";
  private final String NEWS_ARTICLES_URI = "/v2/news/";
  private final String API_KEY = "Apikey e3b0b857a19cef247f3996360c579ad10750f67b5189013f3bdb3af353c5b92e";
  private final WebClient webClient;
  Logger logger = LoggerFactory.getLogger(CryptoCompareClient.class);

  public CryptoCompareClient() {
    this.webClient = WebClient
        .builder()
        .baseUrl(BASE_URL)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
  }

  public NewsResponse getNews() {
    try {
      NewsResponse response = this.webClient.get()
          .uri(uriBuilder -> uriBuilder
              .path(NEWS_ARTICLES_URI)
              .queryParam("lang", "EN")
              .queryParam("extraParams", "oskar-crypto-dashboard")
              .build())
          .header("authorization", API_KEY)
          .retrieve()
          .bodyToMono(NewsResponse.class)
          .block();
      logger.debug("get news endpoint; got a response: {}", response);
      return response;
    } catch (WebClientResponseException exception) {
      throw new HttpClientErrorException(exception.getStatusCode());
    }
  }
}
