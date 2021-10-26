package com.codegym.rest_controller;

import com.codegym.DTO.TeacherDto;
import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.ITeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;



    @GetMapping("{id}")
    public ResponseEntity<Optional<Teacher>> findTeacherById(@PathVariable int id) {
        Optional<Teacher> teacher = teacherService.findById(id);
        if (teacher != null) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    // chức năng thêm mới - BaoHG
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Teacher> saveTeacher(@RequestBody @Validated TeacherDto teacherDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacherDto, teacher);
            this.teacherService.save(teacher);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }


     // chức năng  cập nhập  - BaoHG
    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateTeacher(@RequestBody @Validated TeacherDto teacherDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacherDto, teacher);
            this.teacherService.update(teacher);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


}
