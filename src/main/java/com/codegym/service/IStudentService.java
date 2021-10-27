package com.codegym.service;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface IStudentService{
    //Trùng với chị Hà nhưng khác kiểu trả về
    //Danh coding 2:00PM - 23-10-2021
    void updateClassForStudent(Integer classId, Integer studentId);

    //creator: HaNTT, date: 23/10/2021
    Page<Student> findByClassroom(int classroomId, Pageable pageable);

    //creator: HaNTT, date: 23/10/2021
    Page<Student> findWhereClassroomIdNull(Pageable pageable);

    //creator: HaNTT, date: 23/10/2021
    Student findStudentById(Integer id);


    Page<Student> getListStudent(Pageable pageable, Integer id);


    Student getListStudentDetail(Integer id);


}
