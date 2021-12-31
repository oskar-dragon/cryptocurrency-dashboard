package com.dragcorp.cryptodashboard.data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Coin {
  private String name;
  private BigDecimal currentPrice;
  private BigDecimal priceChange;
  private BigDecimal totalVolume;
  private String image;
  private Chart chart;

  public Coin(String name, BigDecimal currentPrice, BigDecimal totalVolume, String image, Chart chart) {
    this.name = name;
    this.currentPrice = currentPrice;
    this.totalVolume = totalVolume;
    this.image = image;
    this.chart = chart;
  }
}
