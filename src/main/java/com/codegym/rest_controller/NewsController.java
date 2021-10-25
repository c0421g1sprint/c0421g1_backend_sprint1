package com.codegym.rest_controller;

import com.codegym.entity.about_news.News;
import com.codegym.entity.about_news.NewsDto;
import com.codegym.entity.about_news.Type;
import com.codegym.service.news.INewsService;
import com.codegym.service.news.ITypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private INewsService iNewsService;
    @Autowired
    private ITypeService iTypeService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<News>> findAllNews(@PageableDefault(size = 3) Pageable pageable) {
        Page<News> newsList = this.iNewsService.findAll(pageable);

        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @GetMapping(value = "/type-list")
    public ResponseEntity<List<Type>> findAllType() {
        List<Type> typeList = this.iTypeService.findAll();

        if (typeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/read/{id}")
    public ResponseEntity<News> findById(@PathVariable int id) {
        News readNews = this.iNewsService.findById(id);

        if (readNews == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(readNews, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        News deleteNews = this.iNewsService.findById(id);

        if (deleteNews != null) {
            this.iNewsService.deleteNews(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createNews(@Valid @RequestBody NewsDto newsDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.FORBIDDEN);
        }
        News news = new News();
        BeanUtils.copyProperties(newsDto, news);
        news.setPostDate(new java.sql.Date(System.currentTimeMillis()));
        news.setNewTitle(newsDto.getNewsTitle());
        this.iNewsService.saveNews(news);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
