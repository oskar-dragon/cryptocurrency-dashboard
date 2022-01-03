package com.dragcorp.cryptodashboard.model;

import lombok.Data;

import java.util.List;

@Data
public class Dashboard {
  private List<Coin> coins;
  private Counters counters;

  public Dashboard() {
  }
}
