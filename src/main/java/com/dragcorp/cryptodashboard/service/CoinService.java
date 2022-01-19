package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.CoinGeckoClient;
import com.dragcorp.cryptodashboard.client.response.coingecko.CoinOhlcResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.CoinResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.MarketsResponse;
import com.dragcorp.cryptodashboard.model.Coin;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class CoinService {
  private final CoinGeckoClient coinGeckoClient;
  Logger logger = LoggerFactory.getLogger(CoinService.class);

  @Autowired
  public CoinService(CoinGeckoClient coinGeckoClient) {
    this.coinGeckoClient = coinGeckoClient;
  }

  public Coin getCoin(String id, String currency, int ohlcDays) {
    logger.debug("fetching markets data for {}({}), days: {}", id, currency, ohlcDays);
    MarketsResponse response = coinGeckoClient.getMarketsDataForCoin(id, currency);
    logger.debug("fetching markets data done");
    List<CoinResponse> coinsResponse = response.getCoins();
    Coin coin = coinsResponse
        .stream()
        .findFirst()
        .map(ResponseConverter::convertToCoin)
        .orElse(null);
    if (coin == null) {
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
    }
    logger.debug("fetching coin ohlc data");
    CoinOhlcResponse ohlcResponse = coinGeckoClient.getCoinOhlc(id, currency, ohlcDays);
    logger.debug("fetching coin ohlc data done");
    coin.setOhlc(ohlcResponse.getOhlcData());
    return coin;
  }

  public List<Coin> getCoins(String currency) {
    logger.debug("fetching markets data for {}...", currency);
    MarketsResponse response = coinGeckoClient.getMarketsData(currency);
    logger.debug("fetching markets data done");
    List<CoinResponse> coins = response.getCoins();
    if (coins == null) {
      logger.debug("coin response is null");
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Failed to fetch data for dashboard");
    }
    return coins
        .stream()
        .filter(coin -> coin.getPriceChangePerc() != null)
        .map(ResponseConverter::convertToCoin)
        .collect(Collectors.toList());
  }

  public List<Coin> getTopGainers(String currency, String period) {
    MarketsResponse response = coinGeckoClient.getMarketsData(currency, period);
    logger.debug("fetching markets data done");
    List<CoinResponse> coins = response.getCoins();
    if (coins == null) {
      logger.debug("coin response is null");
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Failed to fetch data for top gainers");
    }
    return coins
        .stream()
        .filter(coin -> coin.getPriceChangePerc() != null)
        .sorted(Comparator.comparing(CoinResponse::getPriceChangePerc).reversed())
        .limit(5)
        .map(ResponseConverter::convertToCoin)
        .collect(Collectors.toList());
  }

  public List<Coin> getTopLosers(String currency, String period) {
    MarketsResponse response = coinGeckoClient.getMarketsData(currency, period);
    logger.debug("fetching markets data done");
    List<CoinResponse> coins = response.getCoins();
    if (coins == null) {
      logger.debug("coin response is null");
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Failed to fetch data for top losers");
    }
    return coins
        .stream()
        .filter(coin -> coin.getPriceChangePerc() != null)
        .sorted(Comparator.comparing(CoinResponse::getPriceChangePerc))
        .limit(5)
        .map(ResponseConverter::convertToCoin)
        .collect(Collectors.toList());
  }
}
