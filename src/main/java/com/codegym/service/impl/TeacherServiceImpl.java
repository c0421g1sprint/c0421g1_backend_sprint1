package com.codegym.service.impl;

import com.codegym.dto.TeacherDto;
import com.codegym.entity.about_teacher.Teacher;
import com.codegym.repository.ITeacherRepository;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherRepository iTeacherRepository;
    //MinhNN 24/10 find teacher by id account
    @Override
    public Teacher getById(int id) {
        return iTeacherRepository.getById(id);
    }


    //MinhNN 24/10 update infor teacher
    @Override
    public void update(TeacherDto teacherDto) {
        iTeacherRepository.editPersonInfor(teacherDto.getTeacherPhone(), teacherDto.getTeacherAddress(), teacherDto.getTeacherEmail(), teacherDto.getAccount().getAccountId());
    }
}
