package com.dragcorp.cryptodashboard.model;

import lombok.Data;

import java.util.List;

@Data
public class Dashboard {
  private List<Coin> coins;
  private News news;

  public Dashboard() { }
}
