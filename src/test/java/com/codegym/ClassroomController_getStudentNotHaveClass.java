package com.codegym;

import com.codegym.entity.about_student.Student;
import com.codegym.rest_controller.ClassRoomController;
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
@AutoConfigureMockMvc
public class ClassroomController_getStudentNotHaveClass {

    @Autowired
    private ClassRoomController classRoomController;

    @Test
    public void getStudentNotHaveClass_5() {
        ResponseEntity<Page<Student>> pageResponseEntity
                = this.classRoomController.getStudentNotHaveClass(PageRequest.of(0, 5));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    @Test
    public void getStudentNotHaveClass_6() {
        ResponseEntity<Page<Student>> pageResponseEntity
                = this.classRoomController.getStudentNotHaveClass(PageRequest.of(0, 5));

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Student> studentPage = pageResponseEntity.getBody();

        Assertions.assertEquals(13, studentPage.getTotalElements());
        Assertions.assertEquals(3, studentPage.getTotalPages());
        Assertions.assertEquals("Nguyễn Thành Bắc", studentPage.getContent().get(0).getStudentName());
    }
}
