package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.client.response.coingecko.CoinResponse;
import com.dragcorp.cryptodashboard.client.response.cryptocompare.ArticleResponse;
import com.dragcorp.cryptodashboard.model.Article;
import com.dragcorp.cryptodashboard.model.ArticleSourceInfo;
import com.dragcorp.cryptodashboard.model.Coin;
import org.springframework.stereotype.Component;

@Component
public class ResponseConverter {

  public static Article convertToArticle(ArticleResponse response) {
    return new Article(
        response.getId(),
        response.getGuid(),
        response.getPublishedOn(),
        response.getImageUrl(),
        response.getTitle(),
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
        response.getPriceChangePerc24h(),
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
}
