package com.dragcorp.cryptodashboard.dao;

import com.dragcorp.cryptodashboard.data.NewsData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;

public interface NewsRepository extends MongoRepository<NewsData, String> {
  NewsData findFirstByOrderByCreatedAtDesc(LocalDate createdAt);
}