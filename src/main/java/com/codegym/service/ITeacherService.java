package com.codegym.service;

import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITeacherService{
    // Diep search teacher 25/10
//    Page<Teacher> searchTeacher(Pageable pageable, Integer teacherId, String teacherName,
//                                Byte teacherGender, Date teacherDateOfBirth, String teacherPhone,
//                                String teacherAddress);
    Page<Teacher> searchTeacher(Pageable pageable, String search);
}
