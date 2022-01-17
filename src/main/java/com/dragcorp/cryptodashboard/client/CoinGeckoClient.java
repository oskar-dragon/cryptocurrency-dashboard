package com.dragcorp.cryptodashboard.client;

import com.dragcorp.cryptodashboard.client.response.coingecko.ErrorResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.CoinOhlcResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.MarketsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Component
public class CoinGeckoClient {
  private final String BASE_URL = "https://api.coingecko.com/api/v3";
  private final String MARKETS_URI = "/coins/markets";
  private final String COIN_OHLC_URI = "/coins/{id}/ohlc";
  private final WebClient webClient;
  Logger logger = LoggerFactory.getLogger(CoinGeckoClient.class);

  public CoinGeckoClient() {
    this.webClient = WebClient.builder()
        .baseUrl(BASE_URL)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
  }

  public MarketsResponse getMarketsData(String currency) {
    try {
      MarketsResponse response = this.webClient.get()
          .uri(uriBuilder -> uriBuilder.path(MARKETS_URI)
              .queryParam("vs_currency", currency)
              .build())
          .retrieve()
          .bodyToMono(MarketsResponse.class)
          .block();
      logger.debug("get markets data endpoint; got a response: {}", response);
      return response;
    } catch (WebClientResponseException exception) {
      String message = deserialiseErrorResponse(exception.getResponseBodyAsString());
      logger.debug("error response from gecko api: {}", message);
      throw new HttpClientErrorException(exception.getStatusCode(), message);
    }
  }

  public MarketsResponse getMarketsData(String currency, String period) {
    try {
      MarketsResponse response = this.webClient.get()
              .uri(uriBuilder -> uriBuilder.path(MARKETS_URI)
                      .queryParam("vs_currency", currency)
                      .queryParam("price_change_percentage", period)
                      .build())
              .retrieve()
              .bodyToMono(MarketsResponse.class)
              .block();
      logger.debug("get markets data endpoint; got a response: {}", response);
      return response;
    } catch (WebClientResponseException exception) {
      String message = deserialiseErrorResponse(exception.getResponseBodyAsString());
      logger.debug("error response from gecko api: {}", message);
      throw new HttpClientErrorException(exception.getStatusCode(), message);
    }
  }

  public MarketsResponse getMarketsDataForCoin(String id, String currency) {
    try {
      MarketsResponse response = this.webClient.get()
          .uri(uriBuilder -> uriBuilder.path(MARKETS_URI)
              .queryParam("vs_currency", currency)
              .queryParam("ids", id)
              .build())
          .retrieve()
          .bodyToMono(MarketsResponse.class)
          .block();
      logger.debug("get markets data for coin endpoint; got a response: {}", response);
      return response;
    } catch (WebClientResponseException exception) {
      String message = deserialiseErrorResponse(exception.getResponseBodyAsString());
      logger.debug("error response from gecko api: {}", message);
      throw new HttpClientErrorException(exception.getStatusCode(), message);
    }
  }

  public CoinOhlcResponse getCoinOhlc(String id, String currency, int days) {
    try {
      CoinOhlcResponse response = this.webClient.get()
          .uri(uriBuilder -> uriBuilder
              .path(COIN_OHLC_URI)
              .queryParam("vs_currency", currency)
              .queryParam("days", days)
              .build(id))
          .retrieve()
          .bodyToMono(CoinOhlcResponse.class)
          .block();
      logger.debug("get coin ohlc endpoint; got a response: {}", response);
      return response;
    } catch (WebClientResponseException exception) {
      String message = deserialiseErrorResponse(exception.getResponseBodyAsString());
      logger.debug("error response from gecko api: {}", message);
      throw new HttpClientErrorException(exception.getStatusCode(), message);
    }
  }

  private String deserialiseErrorResponse(String body) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      ErrorResponse response = mapper.readValue(body, ErrorResponse.class);
      return response.getMessage();
    } catch (JsonProcessingException jsonProcessingException) {
      logger.debug("error parsing response");
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
