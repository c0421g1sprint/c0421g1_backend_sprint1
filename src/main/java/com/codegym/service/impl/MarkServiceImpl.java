package com.codegym.service.impl;

import com.codegym.entity.about_student.Mark;
import com.codegym.repository.IMarkRepository;
import com.codegym.service.IMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarkServiceImpl implements IMarkService {
    @Autowired
    private IMarkRepository iMarkRepository;

    @Override
    public Page<Mark> findAll(Pageable pageable) {
        return iMarkRepository.getAllMarkStudent(pageable);
    }

    @Override
    public Mark getById(int id) {
        return iMarkRepository.getById(id);
    }



    @Override
    public void save(Mark mark) {
        iMarkRepository.editMark(mark.getMarkPointNumber1(), mark.getMarkPointNumber2(),mark.getMarkPointNumber3(), mark.getMarkId());
    }

    @Override
    public void delete(int id) {

    }


    @Override
    public Page<Mark> search(Pageable pageable, String nameStudent, Integer subjectId, String className) {
        return iMarkRepository.findAllStudentByName(pageable,nameStudent, subjectId, className);
    }
}
