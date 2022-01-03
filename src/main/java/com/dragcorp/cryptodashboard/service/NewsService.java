package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.CryptoCompareClient;
import com.dragcorp.cryptodashboard.client.response.cryptocompare.NewsResponse;
import com.dragcorp.cryptodashboard.model.Article;
import com.dragcorp.cryptodashboard.model.News;
import com.dragcorp.cryptodashboard.repository.NewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {
  Logger logger = LoggerFactory.getLogger(NewsService.class);
  @Autowired
  private final CryptoCompareClient cryptoCompareClient;
  @Autowired
  private final NewsRepository newsRepository;

  public NewsService(CryptoCompareClient cryptoCompareClient, NewsRepository newsRepository) {
    this.cryptoCompareClient = cryptoCompareClient;
    this.newsRepository = newsRepository;
  }

  public News getNewsFromDb() {
    logger.debug("fetching news from db...");
    return newsRepository.findFirstByOrderByCreatedAtDesc(LocalDate.now());
  }

  public void fetchNewsFromApi() {
    logger.debug("fetching news from api...");
    NewsResponse newsResponse = cryptoCompareClient.getNews();
    logger.debug("fetching news from api done");
    List<Article> convertedNews = newsResponse.getData()
        .stream()
        .map(ResponseConverter::convertToArticle)
        .collect(Collectors.toList());
    logger.debug("inserting news...");
    newsRepository.insert(new News(LocalDate.now(), convertedNews));
    logger.debug("inserting news done");
  }
}
