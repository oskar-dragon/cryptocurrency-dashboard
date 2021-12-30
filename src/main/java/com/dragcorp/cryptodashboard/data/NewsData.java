package com.dragcorp.cryptodashboard.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document("news")
public class NewsData {
  @Id
  private String id;
  @Indexed
  private LocalDate createdAt;
  private List<Article> news;

  public NewsData(LocalDate createdAt, List<Article> news) {
    this.createdAt = createdAt;
    this.news = news;
  }
}
