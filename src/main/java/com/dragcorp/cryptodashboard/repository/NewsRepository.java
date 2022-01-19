package com.dragcorp.cryptodashboard.repository;

import com.dragcorp.cryptodashboard.model.News;
import java.time.LocalDate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<News, String> {
  News findByCreatedAt(LocalDate date);
}