package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.CryptoCompareClient;
import com.dragcorp.cryptodashboard.client.response.cryptocompare.NewsResponse;
import com.dragcorp.cryptodashboard.repository.NewsRepository;
import com.dragcorp.cryptodashboard.model.Article;
import com.dragcorp.cryptodashboard.model.ArticleSourceInfo;
import com.dragcorp.cryptodashboard.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class NewsService {

  @Autowired
  private final CryptoCompareClient cryptoCompareClient;
  @Autowired
  private final NewsRepository newsRepository;

  public NewsService(CryptoCompareClient cryptoCompareClient, NewsRepository newsRepository) {
    this.cryptoCompareClient = cryptoCompareClient;
    this.newsRepository = newsRepository;
  }

  public News getNewsFromDb() {
    return newsRepository.findFirstByOrderByCreatedAtDesc(LocalDate.now());
  }

  public NewsResponse getNewsFromApi() {
    NewsResponse news = cryptoCompareClient.getNews();
//    List<Article> convertedNews = news.getData()
//        .stream()
//        .map(this::convertToArticle)
//        .collect(Collectors.toList());
//    newsRepository.insert(new NewsData(LocalDate.now(), convertedNews));
    return news;
  }

  private Article convertToArticle(com.dragcorp.cryptodashboard.client.response.cryptocompare.News news) {
    return new Article(
        news.getId(),
        news.getGuid(),
        news.getPublishedOn(),
        news.getImageUrl(),
        news.getTitle(),
        news.getUrl(),
        news.getSource(),
        news.getBody(),
        news.getTags(),
        news.getCategories(),
        news.getUpvotes(),
        news.getDownvotes(),
        news.getLang(),
        new ArticleSourceInfo(
            news.getSourceInfo().getName(),
            news.getSourceInfo().getLang(),
            news.getSourceInfo().getImg()
        )
    );
  }
}
