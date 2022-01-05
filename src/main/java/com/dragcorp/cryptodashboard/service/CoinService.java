package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.CoinGeckoClient;
import com.dragcorp.cryptodashboard.client.response.coingecko.CoinOhlcResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.CoinResponse;
import com.dragcorp.cryptodashboard.client.response.coingecko.MarketsResponse;
import com.dragcorp.cryptodashboard.model.Coin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CoinService {
  @Autowired
  private final CoinGeckoClient coinGeckoClient;
  Logger logger = LoggerFactory.getLogger(CoinService.class);

  public CoinService(CoinGeckoClient coinGeckoClient) {
    this.coinGeckoClient = coinGeckoClient;
  }

  public Coin getCoinData(String id, String currency, int ohlcDays) {
    logger.debug("fetching markets data for {}({}), days: {}", id, currency, ohlcDays);
    MarketsResponse response = coinGeckoClient.getMarketsDataForCoin(id, currency);
    logger.debug("fetching markets data done");
    List<CoinResponse> coinsResponse = response.getCoins();
    Coin coin = coinsResponse
        .stream()
        .map(ResponseConverter::convertToCoin)
        .findFirst()
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
}
