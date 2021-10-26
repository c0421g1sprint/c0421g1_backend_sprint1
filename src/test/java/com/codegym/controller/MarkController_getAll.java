package com.codegym.controller;

import com.codegym.entity.about_student.Mark;
import com.codegym.rest_controller.MarkController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest

public class MarkController_getAll {

    @Autowired
    private MarkController markController;

    @Test
    public void getAll_5() {
        ResponseEntity<Page<Mark>> pageResponseEntity
                = this.markController.getAll(PageRequest.of(0,2));
        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    @Test
    public void getAll_6() {
        ResponseEntity<Page<Mark>> pageResponseEntity
                = this.markController.getAll(PageRequest.of(0,5));
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        Page<Mark> markPage = pageResponseEntity.getBody();
        Assertions.assertEquals(15, markPage.getTotalElements());
        Assertions.assertEquals(3, markPage.getTotalPages());

    }
}
