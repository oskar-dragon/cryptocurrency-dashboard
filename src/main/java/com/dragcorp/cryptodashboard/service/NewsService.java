package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.CryptoCompareClient;
import com.dragcorp.cryptodashboard.client.response.cryptocompare.ArticleResponse;
import com.dragcorp.cryptodashboard.client.response.cryptocompare.NewsResponse;
import com.dragcorp.cryptodashboard.model.News;
import com.dragcorp.cryptodashboard.repository.NewsRepository;
import com.dragcorp.cryptodashboard.model.Article;
import com.dragcorp.cryptodashboard.model.ArticleSourceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

  public void fetchNewsFromApi() {
    NewsResponse news = cryptoCompareClient.getNews();
    List<Article> convertedNews = news.getData()
        .stream()
        .map(this::convertToArticle)
        .collect(Collectors.toList());
    newsRepository.insert(new News(LocalDate.now(), convertedNews));
  }

  private Article convertToArticle(ArticleResponse article) {
    return new Article(
        article.getId(),
        article.getGuid(),
        article.getPublishedOn(),
        article.getImageUrl(),
        article.getTitle(),
        article.getUrl(),
        article.getSource(),
        article.getBody(),
        article.getTags(),
        article.getCategories(),
        article.getUpvotes(),
        article.getDownvotes(),
        article.getLang(),
        new ArticleSourceInfo(
            article.getSourceInfo().getName(),
            article.getSourceInfo().getLang(),
            article.getSourceInfo().getImg()
        )
    );
  }
}
