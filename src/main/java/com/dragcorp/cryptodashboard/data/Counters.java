package com.dragcorp.cryptodashboard.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Document
public class Counters {
  @Id
  private String id;
  private String topGainers;
  private String topLosers;
  private BigDecimal marketCap;
  private LocalDate createdAt;

  public Counters(String topGainers,
                  String topLosers,
                  BigDecimal marketCap,
                  LocalDate createdAt) {
    this.topGainers = topGainers;
    this.topLosers = topLosers;
    this.marketCap = marketCap;
    this.createdAt = createdAt;
  }
}
