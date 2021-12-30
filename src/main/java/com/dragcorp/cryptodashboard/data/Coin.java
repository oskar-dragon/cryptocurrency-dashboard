package com.dragcorp.cryptodashboard.data;

import lombok.Data;

import java.awt.*;
import java.math.BigDecimal;

@Data
public class Coin {
  private String name;
  private BigDecimal currentPrice;
  private BigDecimal priceChange;
  private BigDecimal volume;
  private Image image;
  private Chart chartData;
}
