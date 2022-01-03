package com.dragcorp.cryptodashboard.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
public class Dashboard {
  private List<Coin> coins;
  private Counters counters;

  public Dashboard() {
  }
}
