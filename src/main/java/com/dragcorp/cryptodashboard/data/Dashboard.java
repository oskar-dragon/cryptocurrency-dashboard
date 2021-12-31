package com.dragcorp.cryptodashboard.data;

import lombok.Data;

import java.util.List;

@Data
public class Dashboard {
  private List<Coin> coins;
  private Counters countersData;

  public Dashboard(List<Coin> coins, Counters countersData) {
    this.coins = coins;
    this.countersData = countersData;
  }
}
