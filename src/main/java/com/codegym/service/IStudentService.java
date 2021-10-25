package com.codegym.service;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {
    //creator: HaNTT, date: 23/10/2021
    Page<Student> findWhereClassroomIdNull(Pageable pageable);

    //creator: HaNTT, date: 23/10/2021
    Student findStudentById(Integer id);

    //creator: HaNTT, date: 23/10/2021
    Integer setClassroomForNewStudent(Integer classRoomId, Integer studentId);

}
