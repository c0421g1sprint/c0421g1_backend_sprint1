package com.codegym.service.impl;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.repository.ITeacherRepository;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherRepository teacherRepository;

    //creator: HaNTT, date: 23/10/2021  (select-option)
    @Override
    public List<Teacher> findTeacherWhereTeacherIdNull() {
        return teacherRepository.findTeacherWhereTeacherIdNull();
    }
}
