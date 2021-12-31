package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.CoinGeckoClient;
import com.dragcorp.cryptodashboard.client.response.coingecko.ChartResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.CoinResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.MarketsResponse;
import com.dragcorp.cryptodashboard.data.Chart;
import com.dragcorp.cryptodashboard.data.Coin;
import com.dragcorp.cryptodashboard.data.Counters;
import com.dragcorp.cryptodashboard.data.Dashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

  @Autowired
  private final CoinGeckoClient coinGeckoClient;

  public DashboardService(CoinGeckoClient coinGeckoClient) {
    this.coinGeckoClient = coinGeckoClient;
  }

  public Dashboard getDashboardData(String currency, String chartDays) {
    MarketsResponse response = coinGeckoClient.getDashboardData(currency);
    List<CoinResponse> coinsResponse = response.getCoins();

    List<CoinResponse> sortedCoins = coinsResponse
        .stream()
        .sorted(Comparator.comparing(CoinResponse::getPriceChangePerc24h))
        .collect(Collectors.toList());

//    Map<String, BigDecimal> topGainers;
//    Map<String, BigDecimal> topLosers;
//    Counters countersData = new Counters(topGainers, topLosers, BigDecimal.TEN);

    List<Coin> coins = coinsResponse
        .stream()
        .map(coin -> convertToCoin(coin, currency, chartDays))
        .collect(Collectors.toList());

//    Dashboard dashboardData = new Dashboard(coins, countersData);
    return null;
  }

  private Coin convertToCoin(CoinResponse response, String currency, String chartDays) {
    ChartResponse chartResponse = coinGeckoClient.getChartData(response.getId(), currency, chartDays);
    return new Coin(
        response.getName(),
        response.getCurrentPrice(),
        response.getTotalVolume(),
        response.getImage(),
        new Chart(
            chartResponse.getPrices(),
            chartResponse.getMarketCaps(),
            chartResponse.getTotalVolumes()
        )
    );
  }
}
