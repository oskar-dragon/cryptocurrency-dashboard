package com.dragcorp.cryptodashboard.model;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
  private final String id;
  private final String guid;
  private final Date publishedOn;
  private final String title;
  private final String imageUrl;
  private final String url;
  private final String source;
  private final String body;
  private final String tags;
  private final String categories;
  private final String upvotes;
  private final String downvotes;
  private final String lang;
  private final ArticleSourceInfo sourceInfo;
}
