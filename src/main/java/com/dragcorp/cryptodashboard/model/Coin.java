package com.dragcorp.cryptodashboard.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class Coin {
  private final String id;
  private final String name;
  private final String symbol;
  private final BigDecimal currentPrice;
  private final BigDecimal priceChangePerc;
  private final BigDecimal totalVolume;
  private final int marketCapRank;
  private final BigDecimal high24h;
  private final BigDecimal low24h;
  private final BigDecimal ath;
  private final BigDecimal atl;
  private final String image;
  private final LocalDateTime lastUpdated;
  private List<List<BigDecimal>> ohlc;
}
