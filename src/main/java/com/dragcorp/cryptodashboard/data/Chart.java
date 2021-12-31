package com.dragcorp.cryptodashboard.data;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Chart {
  private final List<List<BigDecimal>> prices;
  private final List<List<BigDecimal>> marketCaps;
  private final List<List<BigDecimal>> totalVolumes;
}
