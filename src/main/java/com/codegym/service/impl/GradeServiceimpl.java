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
    IGradeRepository gradeRepository;

    @Override
    public List<Grade> findAllGrade() {
        return gradeRepository.findAllGrade();
    }
}
