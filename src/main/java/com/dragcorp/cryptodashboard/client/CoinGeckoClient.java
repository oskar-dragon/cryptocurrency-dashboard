package com.dragcorp.cryptodashboard.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CoinGeckoClient {
  private final String BASE_URL = "https://api.coingecko.com/api/v3";
  private final String MARKETS_URI = "/coins/markets";
  private final String MARKET_CHART_URI = "/coins/{id}/market_chart";
  private final String COIN_OHLC_URI = "/coins/{id}/ohlc";

  private final WebClient webClient;

  public CoinGeckoClient() {
    this.webClient = WebClient.builder()
        .baseUrl(BASE_URL)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
  }
//
//  public Mono<> getCoinOhlc() {
//    return this.webClient.get().uri(COIN_OHLC_URI).retrieve().bodyToMono();
//  }
//
//  public Mono<> getChartData() {
//    return this.webClient.get().uri(MARKET_CHART_URI).retrieve().bodyToMono();
//  }
//
//  public Mono<> getCountersData() {
//    return this.webClient.get().uri(MARKETS_URI).retrieve().bodyToMono();
//  }
}
