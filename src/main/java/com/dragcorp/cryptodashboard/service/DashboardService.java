package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.CoinGeckoClient;
import com.dragcorp.cryptodashboard.client.response.coingecko.CoinResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.MarketsResponse;
import com.dragcorp.cryptodashboard.model.Coin;
import com.dragcorp.cryptodashboard.model.Counters;
import com.dragcorp.cryptodashboard.model.Dashboard;
import com.dragcorp.cryptodashboard.model.News;
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

  public DashboardService(CoinGeckoClient coinGeckoClient, NewsRepository newsRepository) {
    this.coinGeckoClient = coinGeckoClient;
    this.newsRepository = newsRepository;
  }

  public Dashboard getDashboardData(String currency) {
    MarketsResponse response = coinGeckoClient.getMarketsData(currency);
    List<CoinResponse> coinsResponse = response.getCoins();

    List<Coin> coins = coinsResponse
        .stream()
        .map(this::convertToCoin)
        .collect(Collectors.toList());

    List<CoinResponse> sortedCoins = coinsResponse
        .stream()
        .sorted(Comparator.comparing(CoinResponse::getPriceChangePerc24h))
        .collect(Collectors.toList());
    List<Coin> topGainers = sortedCoins
        .stream()
        .limit(5)
        .map(this::convertToCoin)
        .collect(Collectors.toList());
    List<Coin> topLosers = sortedCoins
        .stream()
        .skip(Math.max(0, sortedCoins.size() - 5))
        .map(this::convertToCoin)
        .collect(Collectors.toList());

    News news = newsRepository.findFirstByOrderByCreatedAtDesc(LocalDate.now());

    Counters countersData = new Counters(topGainers, topLosers, news);

    return new Dashboard(coins, countersData);
  }

  private Coin convertToCoin(CoinResponse response) {
    return new Coin(
        response.getId(),
        response.getName(),
        response.getSymbol(),
        response.getCurrentPrice(),
        response.getPriceChangePerc24h(),
        response.getTotalVolume(),
        response.getMarketCapRank(),
        response.getHigh24h(),
        response.getLow24h(),
        response.getAth(),
        response.getAtl(),
        response.getImage(),
        response.getLastUpdated()
    );
  }
}
