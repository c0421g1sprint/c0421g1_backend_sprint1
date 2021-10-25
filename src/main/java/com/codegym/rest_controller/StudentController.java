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

    //creator: HaNTT, date: 23/10/2021
    @GetMapping("/{classroomId}")
    public ResponseEntity<Page<Student>> getStudentsOfClassroom(@PathVariable String classroomId,
                                                                @PageableDefault(value = 10) Pageable pageable) {
        try {
            int classId = Integer.parseInt(classroomId);
            Page<Student> students = studentService.findByClassroom(classId, pageable);
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //creator: HaNTT, date: 23/10/2021
//    @PostMapping("/add")
//    public ResponseEntity<Integer> addStudent() {
//        Classroom classroom = new Classroom();
//        Student student = new Student(1, (byte) 1,"a","a", null,"a","a","a","a","a","a","a",false, classroom, null);
//        Student newStudent = this.studentService.save(student);
//        return new ResponseEntity<>(newStudent.getStudentId(), HttpStatus.CREATED);
//    }
}
