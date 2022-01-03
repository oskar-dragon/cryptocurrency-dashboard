package com.dragcorp.cryptodashboard.client;

import com.dragcorp.cryptodashboard.client.response.coingecko.CoinOhlcResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.MarketsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

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
              .queryParam("order", "market_cap_desc")
              .queryParam("per_page", 100)
              .queryParam("page", 1)
              .queryParam("sparkline", false)
              .build())
          .retrieve()
          .bodyToMono(MarketsResponse.class)
          .block();
      logger.debug("get markets data endpoint; got a response: {}", response);
      return response;
    } catch (WebClientException exception) {
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
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
    } catch (WebClientException exception) {
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
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
    } catch (WebClientException exception) {
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
    }
  }
}
