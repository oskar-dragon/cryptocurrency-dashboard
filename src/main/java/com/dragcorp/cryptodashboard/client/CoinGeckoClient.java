package com.dragcorp.cryptodashboard.client;

import com.dragcorp.cryptodashboard.client.response.coingecko.CoinOhlcResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.MarketsResponse;
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

  public CoinGeckoClient() {
    this.webClient = WebClient.builder()
        .baseUrl(BASE_URL)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
  }

  public MarketsResponse getMarketsData(String currency) {
    try {
      return this.webClient.get()
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
    } catch (WebClientException exception) {
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
    }
  }

  public CoinOhlcResponse getCoinOhlc(String coinId, String currency, int days) {
    try {
      return this.webClient.get()
          .uri(uriBuilder -> uriBuilder
              .path(COIN_OHLC_URI)
              .queryParam("vs_currency", currency)
              .queryParam("days", days)
              .build(coinId))
          .retrieve()
          .bodyToMono(CoinOhlcResponse.class)
          .block();
    } catch (WebClientException exception) {
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
    }
  }
}
