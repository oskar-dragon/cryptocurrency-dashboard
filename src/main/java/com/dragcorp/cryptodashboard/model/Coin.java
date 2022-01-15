package com.dragcorp.cryptodashboard.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class Coin {
  private final String id;
  private final String name;
  private final String symbol;
  private final BigDecimal currentPrice;
  private final float priceChangePerc1h;
  private final float priceChangePerc24h;
  private final float priceChangePerc7d;
  private final float priceChangePerc30d;
  private final BigDecimal totalVolume;
  private final int marketCapRank;
  private final BigDecimal high24h;
  private final BigDecimal low24h;
  private final BigDecimal ath;
  private final BigDecimal atl;
  private final String image;
  private final LocalDate lastUpdated;
  private List<List<BigDecimal>> ohlc;
}
