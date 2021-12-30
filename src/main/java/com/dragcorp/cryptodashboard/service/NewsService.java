package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.CryptoCompareClient;
import com.dragcorp.cryptodashboard.client.response.cryptocompare.News;
import com.dragcorp.cryptodashboard.client.response.cryptocompare.NewsResponse;
import com.dragcorp.cryptodashboard.dao.NewsRepository;
import com.dragcorp.cryptodashboard.data.Article;
import com.dragcorp.cryptodashboard.data.ArticleSourceInfo;
import com.dragcorp.cryptodashboard.data.NewsData;
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

  public NewsData getNewsFromDb() {
    return newsRepository.findFirstByOrderByCreatedAtDesc(LocalDate.now());
  }

  public void getNewsFromApi() {
    NewsResponse news = cryptoCompareClient.getNews();
    List<Article> convertedNews = news.getData()
        .stream()
        .map(this::convertToArticle)
        .collect(Collectors.toList());
    newsRepository.insert(new NewsData(LocalDate.now(), convertedNews));
    //TODO bulk insert new news
    //TODO bulk remove old news
  }

  private Article convertToArticle(News news) {
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
