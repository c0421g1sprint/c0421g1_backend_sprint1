package com.codegym.service;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IStudentService {

    Page<Student> getListStudent(Pageable pageable, Integer id);


    Student getStudentDetail(Integer id);


}
