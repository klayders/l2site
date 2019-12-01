package com.l2.site.api;

import com.l2.site.model.news.News;
import com.l2.site.news.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.l2.site.utils.SiteUtils.API;

@RestController
@RequiredArgsConstructor
@RequestMapping(NewsController.NEWS_URL)
public class NewsController {

  private static final String VERSION = "/v1";
  static final String NEWS_URL = API + VERSION + "/news";

  private final NewsService newsService;

  @GetMapping
  public List<News> findAll() {
    return newsService.findAll();
  }


}
