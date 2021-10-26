package com.codegym.rest_controller;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_student.Student;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    //create: HaNTT, date: 23/10/2021
    @GetMapping("/find-student") //OK  (checkbox)
    public ResponseEntity<Page<Student>> getStudentNotHaveClass(@PageableDefault(size = 5) Pageable pageable) {
        Page<Student> studentList = this.studentService.findWhereClassroomIdNull(pageable);

        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    //*Note : CẦN CHECK LẠI PHƯƠNG THỨC
    //create: HaNTT, date: 23/10/2021 (add student to List)
    @GetMapping("/find-student/{id}") //OK
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student student = this.studentService.findStudentById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
