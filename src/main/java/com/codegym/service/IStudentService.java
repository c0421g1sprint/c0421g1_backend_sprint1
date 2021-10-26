package com.codegym.service;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService{
    Page<Student> findByClassroom(int classroomId, Pageable pageable);

    Student getById(int id);

    Student deleteById(int studentId);

    void saveStudent(Student student);

    void editStudent(Student student);

}
