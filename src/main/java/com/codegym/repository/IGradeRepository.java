package com.codegym.repository;

import com.codegym.entity.about_classroom.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGradeRepository extends JpaRepository<Grade, Integer> {
    //TaiNP query find All grade
    @Query(value = "select g.grade_id, g.grade_name from grade g",nativeQuery = true)
    List<Grade> findAllGrade();
}
