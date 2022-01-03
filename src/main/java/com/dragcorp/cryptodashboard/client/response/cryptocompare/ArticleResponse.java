package com.dragcorp.cryptodashboard.client.response.cryptocompare;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.Date;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleResponse {
  String id;
  String guid;
  Date publishedOn;
  String title;
  String imageUrl;
  String url;
  String source;
  String body;
  String tags;
  String categories;
  String upvotes;
  String downvotes;
  String lang;
  ArticleSourceInfoResponse sourceInfo;

  @JsonCreator
  public ArticleResponse(@JsonProperty("id") String id,
                         @JsonProperty("guid") String guid,
                         @JsonProperty("published_on") Date publishedOn,
                         @JsonProperty("imageurl") String imageUrl,
                         @JsonProperty("title") String title,
                         @JsonProperty("url") String url,
                         @JsonProperty("source") String source,
                         @JsonProperty("body") String body,
                         @JsonProperty("tags") String tags,
                         @JsonProperty("categories") String categories,
                         @JsonProperty("upvotes") String upvotes,
                         @JsonProperty("downvotes") String downvotes,
                         @JsonProperty("lang") String lang,
                         @JsonProperty("source_info") ArticleSourceInfoResponse sourceInfo) {
    this.id = id;
    this.guid = guid;
    this.publishedOn = publishedOn;
    this.imageUrl = imageUrl;
    this.title = title;
    this.url = url;
    this.source = source;
    this.body = body;
    this.tags = tags;
    this.categories = categories;
    this.upvotes = upvotes;
    this.downvotes = downvotes;
    this.lang = lang;
    this.sourceInfo = sourceInfo;
  }
}
