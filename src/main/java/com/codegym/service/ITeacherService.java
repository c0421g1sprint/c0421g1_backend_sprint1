package com.codegym.service;

import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ITeacherService {

    Optional<Teacher> findById(int id);

    void update(Teacher teacher);
    void save(Teacher teacher);


}
