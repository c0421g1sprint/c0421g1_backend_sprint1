package com.codegym.controller;

import com.codegym.entity.about_student.Student;
import com.codegym.rest_controller.StudentController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootTest
public class StudentRestController_getSearchStudent {
    @Autowired
    private StudentController studentController;

    // Tham số null
    @Test
    public void  getSearchStudent_7() {
        ResponseEntity<Page<Student>> pageResponseEntity = this.studentController.searchByName(PageRequest.of(0,3),null,null);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, pageResponseEntity.getStatusCode());
    }

    //    Tìm kiếm tương đối nên để rỗng vẫn HttpStatus.Ok
    @Test
    public void  getSearchStudent_8() {
        ResponseEntity<Page<Student>> pageResponseEntity = this.studentController.searchByName(PageRequest.of(0,3),"","");
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        Page<Student> studentPage = pageResponseEntity.getBody();

        Assertions.assertEquals(11, studentPage.getTotalElements());
        Assertions.assertEquals(4, studentPage.getTotalPages());
        Assertions.assertEquals("Nguyễn Thu Thủy", studentPage.getContent().get(1).getStudentName());
        Assertions.assertEquals("Lê Văn Cường", studentPage.getContent().get(0).getStudentName());
    }
    //    Tham số không tồn tại trong DB
    @Test
    public void  getSearchStudent_9() {
        ResponseEntity<Page<Student>> pageResponseEntity = this.studentController.searchByName(PageRequest.of(0,3),"linh","di choi");
        Assertions.assertEquals(HttpStatus.NO_CONTENT, pageResponseEntity.getStatusCode());
    }
    //    Tham số tồn tại trong DB và có size=0
    @Test
    public void  getSearchStudent_10() {
        ResponseEntity<Page<Student>> pageResponseEntity = this.studentController.searchByName(PageRequest.of(0,1),"Cường","Đã thôi học");
        Assertions.assertEquals(HttpStatus.NO_CONTENT, pageResponseEntity.getStatusCode());
    }


    // Tham số tồn tại trong DB, trường hợp trả về list có size >0
    @Test
    public void getSearchStudent_11() {
        ResponseEntity<Page<Student>> pageResponseEntity
                = this.studentController.searchByName(PageRequest.of(0, 5),"T","Đang học");
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Student> studentPage = pageResponseEntity.getBody();

        Assertions.assertEquals(8, studentPage.getTotalElements());
        Assertions.assertEquals(2, studentPage.getTotalPages());
        Assertions.assertEquals("Nguyễn Thu Thủy", studentPage.getContent().get(0).getStudentName());

    }

}

