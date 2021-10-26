package com.codegym.service;

import com.codegym.entity.about_student.Mark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import java.util.List;


public interface IMarkService  {
    Page<Mark> findAll(Pageable pageable);

    Mark getById(int id);

    void save(Mark mark);

    void delete(int id);

    Page<Mark> search(Pageable pageable, String nameStudent, String subject);
}
