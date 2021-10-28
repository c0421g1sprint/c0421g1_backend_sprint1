package com.codegym.service;

import com.codegym.entity.about_classroom.Grade;

import java.util.List;

public interface IGradeService {
    //TaiNP && QuanTA
    List<Grade> findAllGrade();

    //DanhNT
    Grade findGradeById(Integer gradeId);

}
