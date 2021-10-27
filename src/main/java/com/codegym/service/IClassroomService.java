package com.codegym.service;

import com.codegym.entity.about_classroom.Classroom;

import java.util.List;

public interface IClassroomService {
    List<Classroom> findAllClassroomExist();
}
