package com.codegym.service.impl.news;

import com.codegym.entity.about_news.News;
import com.codegym.repository.news.INewsRepository;
import com.codegym.service.news.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private INewsRepository iNewsRepository;

    @Override
    public Page<News> findAll(Pageable pageable) {
        return this.iNewsRepository.findAllNews(pageable);
    }

    @Override
    public News findById(int id) {
        return this.iNewsRepository.findNewsById(id);
    }

    @Override
    public void saveNews(News news) {
        this.iNewsRepository.saveNews(news.getNewTitle(), news.getNewsBrief(), news.getNewsContent(), news.getImageUrl(), news.getPostDate(), news.getType().getTypeId());
    }

    @Override
    public void deleteNews(int id) {
        this.iNewsRepository.deleteNews(id);
    }
}
