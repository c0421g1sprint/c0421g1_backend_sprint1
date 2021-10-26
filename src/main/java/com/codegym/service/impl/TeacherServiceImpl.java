package com.codegym.service.impl;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.repository.ITeacherRepository;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherRepository teacherRepository;



    @Override
    public void delete(Integer id) {
        Teacher teacher = teacherRepository.findByIdTeacherByQuery(id).orElse(null);
        if (teacher != null) {
            teacherRepository.saveDeleteTeacher(teacher.getTeacherId());
        }
    }



    @Override
    public Page<Teacher> findAllTeacherByQuery(Pageable pageable) {
        return teacherRepository.findAllTeacherByQuery(pageable);
    }

    @Override
    public Teacher findTeacherByIdByQuery(int id) {
        Teacher teacher  = teacherRepository.findByIdTeacherByQuery(id).orElse(null);
        if (teacher != null) {
            return teacher;
        }
        return null;
    }

    @Override
    public Page<Teacher> findAllTeacherByQueryWithName(Pageable pageable, String name) {
        return teacherRepository.findAllTeacherByQueryWithKeyword(pageable, name);
    }

    @Override
    public Page<Teacher> findAllTeacherByQueryWithDivision(Pageable pageable, int id) {
        return teacherRepository.findByIdTeacherByDivision(pageable,id);
    }

}
