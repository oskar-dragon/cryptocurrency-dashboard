package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.CoinGeckoClient;
import com.dragcorp.cryptodashboard.client.response.coingecko.CoinOhlcResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.CoinResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.MarketsResponse;
import com.dragcorp.cryptodashboard.model.Coin;
import com.dragcorp.cryptodashboard.repository.CoinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CoinService {
  Logger logger = LoggerFactory.getLogger(CoinService.class);
  @Autowired
  private final CoinGeckoClient coinGeckoClient;
  @Autowired
  private final CoinRepository coinRepository;

  public CoinService(CoinGeckoClient coinGeckoClient, CoinRepository coinRepository) {
    this.coinGeckoClient = coinGeckoClient;
    this.coinRepository = coinRepository;
  }

  public Coin getCoinData(String id, String currency, int ohlcDays) {
    MarketsResponse response = coinGeckoClient.getMarketsDataForCoin(id, currency);
    logger.info("markets data for {}({}): {}", id, currency, response.toString());
    List<CoinResponse> coinsResponse = response.getCoins();
    Coin coin = coinsResponse
        .stream()
        .map(ResponseConverter::convertToCoin)
        .findFirst()
        .orElse(null);
    if (coin == null) {
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
    }
    CoinOhlcResponse ohlcResponse = coinGeckoClient.getCoinOhlc(id, currency, ohlcDays);
    logger.info("ohlc data for {}({}): {}", id, currency, ohlcResponse.toString());
    coin.setOhlc(ohlcResponse.getOhlcData());
    return coin;
  }
}
