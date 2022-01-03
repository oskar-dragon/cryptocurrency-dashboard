package com.dragcorp.cryptodashboard.model;

import lombok.Data;

import java.util.List;

@Data
public class Counters {
  private List<Coin> topGainers;
  private List<Coin> topLosers;
  private News news;

  public Counters(List<Coin> topGainers, List<Coin> topLosers, News news) {
    this.topGainers = topGainers;
    this.topLosers = topLosers;
    this.news = news;
  }
}
