package com.dragcorp.cryptodashboard.controller;

import com.dragcorp.cryptodashboard.model.News;
import com.dragcorp.cryptodashboard.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/news")
@AllArgsConstructor
@CrossOrigin("*")
public class NewsController {
  private final NewsService newsService;

  @GetMapping()
  public News getNews() {
    return newsService.getNews();
  }
}
