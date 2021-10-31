package com.codegym.rest_controller;

import com.codegym.dto.StudentDto;
import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_student.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
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

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    //create: HaNTT, date: 23/10/2021
    @GetMapping("/find-student") //OK  (checkbox)
    public ResponseEntity<List<Student>> getStudentNotHaveClass() {
        List<Student> studentList = this.studentService.findWhereClassroomIdNull();

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

    //LamNT do createStudent function
    @PostMapping("/add")
    public ResponseEntity<Integer> addStudent(@RequestBody @Validated StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.saveStudent(student);
        int id = this.studentService.findNewIdStudent();
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    //LamNT do editStudent function
    @PatchMapping("/edit")
    public ResponseEntity<StudentDto> editStudent(@RequestBody @Validated StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.editStudent(student);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }
}
