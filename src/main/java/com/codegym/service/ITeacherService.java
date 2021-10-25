package com.codegym.service;

import com.codegym.entity.about_teacher.Teacher;

import java.util.List;

public interface ITeacherService {
    //creator: HaNTT, date: 23/10/2021  (select-option)
    List<Teacher> findTeacherWhereTeacherIdNull();

}
