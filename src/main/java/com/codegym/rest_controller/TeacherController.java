package com.codegym.rest_controller;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;
    // diep search teacher 25/10
    @GetMapping("/search")
    public ResponseEntity<Page<Teacher>> getSearchTeacher(@PageableDefault(value = 2) Pageable pageable,
                                                          @RequestParam(required = false)String search) {
//        Page<Teacher> teachers = teacherService.searchTeacher(pageable, teacherId, teacherName, teacherGender, teacherDateOfBirth, teacherPhone, teacherAddress);
        Page<Teacher> teachers = teacherService.searchTeacher(pageable, search);

        if (teachers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

}
