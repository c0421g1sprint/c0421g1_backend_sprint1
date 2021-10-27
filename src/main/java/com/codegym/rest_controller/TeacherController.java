package com.codegym.rest_controller;

import com.codegym.entity.about_student.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/teachers")
public class TeacherController {


    @Autowired
    private IStudentService iStudentService;

    //PhucNK
    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Page<Student>> showListStudentByIdTeacher(@PageableDefault(size = 1) Pageable pageable, @PathVariable Optional<Integer> id) {
        if(id == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Page<Student> studentList = iStudentService.getListStudent(pageable, id.get());
        if (studentList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(studentList, HttpStatus.OK);
        }
    }

    //PhucNK
    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Student> getListStudentDetail(@PathVariable(required = false) Integer id) {
        Optional<Student> studentList = iStudentService.getListStudentDetail(id);
        if (!studentList.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(studentList.get(), HttpStatus.OK);
        }
    }

}
//    _________________________________________



