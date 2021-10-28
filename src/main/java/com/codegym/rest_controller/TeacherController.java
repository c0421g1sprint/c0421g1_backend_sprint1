package com.codegym.rest_controller;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;

    //*Note : CẦN CHECK LẠI PHƯƠNG THỨC
    //create: HaNTT, date: 23/10/2021 (select-option)
    @GetMapping("/find-teacher") //OK
    public ResponseEntity<List<Teacher>> getListTeacherNotHaveChairedClass() {
        List<Teacher> teacherList = this.teacherService.findTeacherWhereTeacherIdNull();

        if (teacherList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacherList, HttpStatus.OK);
    }

}
