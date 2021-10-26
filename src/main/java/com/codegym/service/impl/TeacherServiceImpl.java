package com.codegym.service.impl;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.repository.ITeacherRepository;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherRepository teacherRepository;


    @Override
    public Page<Teacher> searchTeacher(Pageable pageable, String search) {
        return teacherRepository.searchTeacher(pageable, "%" + search + "%");
    }
}
