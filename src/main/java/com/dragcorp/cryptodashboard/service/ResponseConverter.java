package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.response.coingecko.CoinResponse;
import com.dragcorp.cryptodashboard.client.response.cryptocompare.ArticleResponse;
import com.dragcorp.cryptodashboard.model.Article;
import com.dragcorp.cryptodashboard.model.ArticleSourceInfo;
import com.dragcorp.cryptodashboard.model.Coin;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Component
public class ResponseConverter {

  public static Article convertToArticle(ArticleResponse response) {
    return new Article(
        response.getId(),
        response.getGuid(),
        convertToDate(response.getPublishedOn()),
        response.getTitle(),
        response.getImageUrl(),
        response.getUrl(),
        response.getSource(),
        response.getBody(),
        response.getTags(),
        response.getCategories(),
        response.getUpvotes(),
        response.getDownvotes(),
        response.getLang(),
        new ArticleSourceInfo(
            response.getSourceInfo().getName(),
            response.getSourceInfo().getLang(),
            response.getSourceInfo().getImg()
        )
    );
  }

  public static Coin convertToCoin(CoinResponse response) {
    return new Coin(
        response.getId(),
        response.getName(),
        response.getSymbol(),
        response.getCurrentPrice(),
        response.getPriceChangePerc(),
        response.getTotalVolume(),
        response.getMarketCapRank(),
        response.getHigh24h(),
        response.getLow24h(),
        response.getAth(),
        response.getAtl(),
        response.getImage(),
        response.getLastUpdated()
    );
  }

  public static LocalDateTime convertToDate(int timestamp) {
    return LocalDateTime.ofInstant(
            Instant.ofEpochSecond(timestamp),
            TimeZone.getDefault().toZoneId()
    );
  }
}
