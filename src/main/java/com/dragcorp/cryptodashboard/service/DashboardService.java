package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.CoinGeckoClient;
import com.dragcorp.cryptodashboard.client.response.coingecko.CoinResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.MarketsResponse;
import com.dragcorp.cryptodashboard.model.Coin;
import com.dragcorp.cryptodashboard.model.Dashboard;
import com.dragcorp.cryptodashboard.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {
  private final CoinGeckoClient coinGeckoClient;
  private final NewsService newsService;
  Logger logger = LoggerFactory.getLogger(DashboardService.class);

  @Autowired
  public DashboardService(CoinGeckoClient coinGeckoClient, NewsService newsService) {
    this.coinGeckoClient = coinGeckoClient;
    this.newsService = newsService;
  }

  public Dashboard getDashboardData(String currency) {
    Dashboard dashboard = new Dashboard();
    logger.debug("fetching markets data for {}...", currency);
    MarketsResponse response = coinGeckoClient.getMarketsData(currency);
    logger.debug("fetching markets data done");
    List<CoinResponse> coinsResponse = response.getCoins();
    if (coinsResponse == null) {
      logger.debug("coin response is null");
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "coin response is null");
    }
    List<Coin> coins = coinsResponse
        .stream()
        .map(ResponseConverter::convertToCoin)
        .collect(Collectors.toList());
    dashboard.setCoins(coins);

    News news = newsService.getNewsFromDb(LocalDate.now());
    if (news == null) {
      news = newsService.fetchNewsFromApi();
    }
    dashboard.setNews(news);
    logger.debug("dashboard data: {}", dashboard);
    return dashboard;
  }
}
