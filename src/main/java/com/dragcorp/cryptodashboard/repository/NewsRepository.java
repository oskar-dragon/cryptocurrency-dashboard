package com.dragcorp.cryptodashboard.repository;

import com.dragcorp.cryptodashboard.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;

public interface NewsRepository extends MongoRepository<News, String> {
  News findFirstByOrderByCreatedAtDesc(LocalDate createdAt);
}