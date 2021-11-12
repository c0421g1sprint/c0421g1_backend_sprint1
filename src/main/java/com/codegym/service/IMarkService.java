package com.codegym.service;

import com.codegym.entity.about_student.Mark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMarkService  {
    Page<Mark> findAll(Pageable pageable);
    Mark getById(int id);
    void save(Mark mark);
    Page<Mark> search(Pageable pageable, String nameStudent, Integer subjectId, Integer classId);
}