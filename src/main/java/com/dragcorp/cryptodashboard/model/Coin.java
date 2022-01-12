package com.dragcorp.cryptodashboard.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class Coin {
  private String id;
  private String name;
  private String symbol;
  private BigDecimal currentPrice;
  private float priceChangePerc1h;
  private float priceChangePerc24h;
  private float priceChangePerc7d;
  private float priceChangePerc30d;
  private BigDecimal totalVolume;
  private int marketCapRank;
  private BigDecimal high24h;
  private BigDecimal low24h;
  private BigDecimal ath;
  private BigDecimal atl;
  private String image;
  private LocalDate lastUpdated;
  private List<List<BigDecimal>> ohlc;

  public Coin(String id,
              String name,
              String symbol,
              BigDecimal currentPrice,
              float priceChangePerc1h,
              float priceChangePerc24h,
              float priceChangePerc7d,
              float priceChangePerc30d,
              BigDecimal totalVolume,
              int marketCapRank,
              BigDecimal high24h,
              BigDecimal low24h,
              BigDecimal ath,
              BigDecimal atl,
              String image,
              LocalDate lastUpdated) {
    this.id = id;
    this.name = name;
    this.symbol = symbol;
    this.currentPrice = currentPrice;
    this.priceChangePerc1h = priceChangePerc1h;
    this.priceChangePerc24h = priceChangePerc24h;
    this.priceChangePerc7d = priceChangePerc7d;
    this.priceChangePerc30d = priceChangePerc30d;
    this.totalVolume = totalVolume;
    this.marketCapRank = marketCapRank;
    this.high24h = high24h;
    this.low24h = low24h;
    this.ath = ath;
    this.atl = atl;
    this.image = image;
    this.lastUpdated = lastUpdated;
  }

  public List<List<BigDecimal>> getOhlc() {
    return ohlc;
  }

  public void setOhlc(List<List<BigDecimal>> ohlc) {
    this.ohlc = ohlc;
  }
}
