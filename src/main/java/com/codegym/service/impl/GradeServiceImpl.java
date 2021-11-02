package com.codegym.service.impl;

import com.codegym.entity.about_classroom.Grade;
import com.codegym.repository.IGradeRepository;
import com.codegym.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GradeServiceImpl implements IGradeService {

    @Autowired
    private IGradeRepository gradeRepository;
    //DungNM - sử dụng lại code của TaiNP - lấy toàn bộ danh sách khối có trong DB
    @Override
    public List<Grade> findAll() {
        return gradeRepository.findAllGrade();
    }


    //TaiNP && QuanTA
    @Override
    public List<Grade> findAllGrade() {
        return this.gradeRepository.findAllGrade();
    }

    @Override
    public Grade findGradeById(Integer id) {
        return this.gradeRepository.findGradeById(id);
    }
}
