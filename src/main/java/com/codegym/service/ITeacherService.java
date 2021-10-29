package com.codegym.service;

import com.codegym.dto.TeacherUpdateDto;
import com.codegym.entity.about_teacher.Division;
import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ITeacherService {

    Page<Teacher> findAllTeacherByQuery(Pageable pageable);
    Teacher findTeacherByIdByQuery(int id);
    Page<Teacher> findAllTeacherByQueryWithName(Pageable pageable, String name);
    Page<Teacher> findAllTeacherByQueryWithDivision(Pageable pageable, int id);
    void delete(Integer id);
    void update(Teacher teacher);
    void updateInFor(TeacherUpdateDto teacher);
    void save(Teacher teacher);
    List<Division> findAllDivisionByQuery();
    Page<Teacher> findAllTeacherByQueryWithNameAndDivision(Pageable pageable,String name, Integer id);
    Page<Teacher> searchTeacher(Pageable pageable, String search);
    List<Teacher> findTeacherWhereTeacherIdNull();
}
