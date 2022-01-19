package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.CryptoCompareClient;
import com.dragcorp.cryptodashboard.client.response.cryptocompare.NewsResponse;
import com.dragcorp.cryptodashboard.model.Article;
import com.dragcorp.cryptodashboard.model.News;
import com.dragcorp.cryptodashboard.repository.NewsRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
  private final CryptoCompareClient cryptoCompareClient;
  private final NewsRepository newsRepository;
  Logger logger = LoggerFactory.getLogger(NewsService.class);

  @Autowired
  public NewsService(CryptoCompareClient cryptoCompareClient, NewsRepository newsRepository) {
    this.cryptoCompareClient = cryptoCompareClient;
    this.newsRepository = newsRepository;
  }

  public News getNews() {
    News news = getNewsFromDb(LocalDate.now());
    if (news == null) {
      news = fetchNewsFromApi();
    }
    return news;
  }

  public News getNewsFromDb(LocalDate date) {
    logger.debug("fetching news from db...");
    return newsRepository.findByCreatedAt(date);
  }

  public News fetchNewsFromApi() {
    logger.debug("fetching news from api...");
    NewsResponse newsResponse = cryptoCompareClient.getNews();
    logger.debug("fetching news from api done");
    List<Article> convertedNews = newsResponse.getData()
        .stream()
        .map(ResponseConverter::convertToArticle)
        .collect(Collectors.toList());
    logger.debug("inserting news...");
    News news = new News(LocalDate.now(), convertedNews);
    newsRepository.insert(news);
    logger.debug("inserting news done");
    return news;
  }
}
