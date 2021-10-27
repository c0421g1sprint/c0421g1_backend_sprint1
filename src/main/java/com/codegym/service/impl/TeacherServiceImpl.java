package com.codegym.service.impl;


import com.codegym.entity.about_teacher.Division;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.repository.ITeacherRepository;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void update(Teacher teacher) {
        this.teacherRepository.updateTeacher(teacher.isDeleteFlag(), teacher.getTeacherAddress(), teacher.getTeacherDateOfBirth(), teacher.getTeacherEmail(), teacher.getTeacherGender(), teacher.getTeacherImage(), teacher.getTeacherName(), teacher.getTeacherPhone(), teacher.getTeacherUniversity(),teacher.getDivision().getDivisionId(), teacher.getDegree().getDegreeId(),teacher.getAccount().getAccountId(),teacher.getTeacherId());
    }

    @Override
    public void save(Teacher teacher) {
        this.teacherRepository.createNewTeacher(teacher.isDeleteFlag(), teacher.getTeacherAddress(), teacher.getTeacherDateOfBirth(), teacher.getTeacherEmail(), teacher.getTeacherGender(), teacher.getTeacherImage(), teacher.getTeacherName(), teacher.getTeacherPhone(), teacher.getTeacherUniversity(),teacher.getDivision().getDivisionId(), teacher.getDegree().getDegreeId(),teacher.getAccount().getAccountId());
    }

    @Override
    public Optional<Teacher> findById(int id) {
        return this.teacherRepository.findByIdTeacherByQuery(id);
    }


    //MinhNN 24/10 update infor teacher
    @Override
    public void updateInFor(Teacher teacher) {
        teacherRepository.editPersonInfor(teacher.getTeacherPhone(), teacher.getTeacherAddress(), teacher.getTeacherEmail(), teacher.getTeacherId());
    }


    @Override
    public List<Division> findAllDivisionByQuery() {
        return this.teacherRepository.findAllDivisionByQuery();
    }

    @Override
    public Page<Teacher> findAllTeacherByQueryWithNameAndDivision(Pageable pageable,String name, Integer id) {
        return this.teacherRepository.findAllTeacherByQueryWithKeywordAndDivision(pageable, name, id);
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
