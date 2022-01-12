package com.dragcorp.cryptodashboard.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document("news")
public class News {
  @Id
  private String id;
  @Indexed
  private final LocalDate createdAt;
  private final List<Article> data;
}
