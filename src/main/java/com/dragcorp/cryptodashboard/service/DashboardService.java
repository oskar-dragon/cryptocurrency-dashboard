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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {

  @Autowired
  private final CoinGeckoClient coinGeckoClient;

  @Autowired
  private final NewsRepository newsRepository;

  @Autowired
  private final CoinRepository coinRepository;

  public DashboardService(CoinGeckoClient coinGeckoClient,
                          NewsRepository newsRepository,
                          CoinRepository coinRepository) {
    this.coinGeckoClient = coinGeckoClient;
    this.newsRepository = newsRepository;
    this.coinRepository = coinRepository;
  }

  public Dashboard getDashboardData(String currency) {
    Dashboard dashboard = new Dashboard();
    MarketsResponse response = coinGeckoClient.getMarketsData(currency);
    List<CoinResponse> coinsResponse = response.getCoins();

    List<Coin> coins = coinsResponse
        .stream()
        .map(ResponseConverter::convertToCoin)
        .collect(Collectors.toList());
    dashboard.setCoins(coins);

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
    News news = newsRepository.findFirstByOrderByCreatedAtDesc(LocalDate.now());
    Counters counters = new Counters(topGainers, topLosers, news);
    dashboard.setCounters(counters);

    return dashboard;
  }
}
