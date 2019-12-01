package com.l2.site.news;

import com.l2.site.model.news.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

  private final NewsRepository newsRepository;

  public News save(News news) {
    return newsRepository.save(news);
  }

  public List<News> findAll() {
    return newsRepository.findAll();
  }
}
