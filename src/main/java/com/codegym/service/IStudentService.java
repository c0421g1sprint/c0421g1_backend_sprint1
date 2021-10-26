package com.codegym.service;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService{
    Page<Student> findByClassroom(int classroomId, Pageable pageable);

    Student getById(int id);

    Student deleteById(int studentId);
    //    Diệp search student ngày 25/10
    Page<Student> searchstudent(Pageable pageable, String searchstudent);
}
