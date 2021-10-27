package com.codegym.controller;

import com.codegym.entity.about_news.News;
import com.codegym.rest_controller.NewsController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class NewsRestController_findAllNews {

    @Autowired
    private NewsController newsController;

    // Test list size = 0
    @Test
    public void findAllNews_05() {
        ResponseEntity<Page<News>> pageResponseEntity = this.newsController.findAllNews(PageRequest.of(0, 3));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, pageResponseEntity.getStatusCode());
    }

    // Test list size > 0
    @Test
    public void findAllNews_06() {
        ResponseEntity<Page<News>> pageResponseEntity = this.newsController.findAllNews(PageRequest.of(0, 3));

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<News> newsPage = pageResponseEntity.getBody();

        Assertions.assertEquals(5, newsPage.getTotalElements());
        Assertions.assertEquals(2, newsPage.getTotalPages());
        Assertions.assertEquals("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. " +
                "Nhà trường kết hợp ứng dụng này với Microsoft Teams.", newsPage.getContent().get(1).getNewsBrief());
    }
}
