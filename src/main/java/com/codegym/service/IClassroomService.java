package com.codegym.service;

import com.codegym.entity.about_classroom.Classroom;

import java.util.List;

public interface IClassroomService {


    //DanhNT coding 3:00PM 23-10-21
    List<Classroom> findAll();
}
