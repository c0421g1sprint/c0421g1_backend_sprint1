package com.codegym.service.news;

import com.codegym.entity.about_news.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface INewsService  {

    Page<News> findAll(Pageable pageable);

    News findById(int id);

    void saveNews(News news);

    void deleteNews(int id);
}
