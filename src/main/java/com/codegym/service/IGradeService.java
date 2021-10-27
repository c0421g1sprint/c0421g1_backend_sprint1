package com.codegym.service;

import com.codegym.entity.about_classroom.Grade;

import java.util.List;

public interface IGradeService {
    //DungNM - lấy toàn bộ danh sách khối có trong DB
    List<Grade> findAll();
}
