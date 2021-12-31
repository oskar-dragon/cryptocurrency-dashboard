package com.dragcorp.cryptodashboard.api;

import com.dragcorp.cryptodashboard.data.NewsData;
import com.dragcorp.cryptodashboard.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/news")
@AllArgsConstructor
public class NewsController {

  private final NewsService newsService;

  @GetMapping
  public NewsData getNewsData() {
    return newsService.getNewsFromDb();
  }
}
