package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.CoinGeckoClient;
import com.dragcorp.cryptodashboard.client.response.coingecko.CoinResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.MarketsResponse;
import com.dragcorp.cryptodashboard.model.Coin;
import com.dragcorp.cryptodashboard.model.Counters;
import com.dragcorp.cryptodashboard.model.Dashboard;
import com.dragcorp.cryptodashboard.model.News;
import com.dragcorp.cryptodashboard.repository.CoinRepository;
import com.dragcorp.cryptodashboard.repository.NewsRepository;
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
  Logger logger = LoggerFactory.getLogger(DashboardService.class);
  @Autowired
  private final CoinGeckoClient coinGeckoClient;
  @Autowired
  private final NewsRepository newsRepository;

  public DashboardService(CoinGeckoClient coinGeckoClient, NewsRepository newsRepository) {
    this.coinGeckoClient = coinGeckoClient;
    this.newsRepository = newsRepository;
  }

  public Dashboard getDashboardData(String currency) {
    Dashboard dashboard = new Dashboard();
    logger.info("fetching markets data for {}...", currency);
    MarketsResponse response = coinGeckoClient.getMarketsData(currency);
    logger.info("fetching markets data done");
    List<CoinResponse> coinsResponse = response.getCoins();
    if (coinsResponse == null) {
      logger.info("coin response is null");
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
    }
    List<Coin> coins = coinsResponse
        .stream()
        .map(ResponseConverter::convertToCoin)
        .collect(Collectors.toList());
    dashboard.setCoins(coins);
    dashboard.setCounters(createCounters(coins));
    logger.info("dashboard data: {}", dashboard);
    return dashboard;
  }

  protected Counters createCounters(List<Coin> coins) {
    List<Coin> sortedCoins = coins
        .stream()
        .sorted(Comparator.comparing(Coin::getPriceChangePerc24h))
        .collect(Collectors.toList());
    List<Coin> topGainers = sortedCoins
        .stream()
        .limit(5)
        .collect(Collectors.toList());
    List<Coin> topLosers = sortedCoins
        .stream()
        .skip(Math.max(0, sortedCoins.size() - 5))
        .collect(Collectors.toList());
    logger.info("fetching news for counters...");
    News news = newsRepository.findFirstByOrderByCreatedAtDesc(LocalDate.now());
    logger.info("fetching news done");
    return new Counters(topGainers, topLosers, news);
  }
}
