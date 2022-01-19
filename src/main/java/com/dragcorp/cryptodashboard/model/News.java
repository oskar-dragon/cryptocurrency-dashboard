package com.dragcorp.cryptodashboard.model;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("news")
public class News {
  @Indexed
  private final LocalDate createdAt;
  private final List<Article> data;
  @Id
  private String id;
}
