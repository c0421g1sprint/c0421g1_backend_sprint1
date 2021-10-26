package com.codegym.service;

import com.codegym.DTO.TeacherDto;

import com.codegym.entity.about_teacher.Teacher;

public interface ITeacherService {


    //    MinhNN 24/10
    Teacher getById(int id);

    void update(TeacherDto teacherDto);
}
