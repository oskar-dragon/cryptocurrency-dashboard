package com.dragcorp.cryptodashboard.data;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Counters {
  private Map<String, BigDecimal> topGainers;
  private Map<String, BigDecimal> topLosers;
  private BigDecimal marketCap;

  public Counters(Map<String, BigDecimal> topGainers,
                  Map<String, BigDecimal> topLosers,
                  BigDecimal marketCap) {
    this.topGainers = topGainers;
    this.topLosers = topLosers;
    this.marketCap = marketCap;
  }
}
