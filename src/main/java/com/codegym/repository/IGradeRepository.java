package com.codegym.repository;

import com.codegym.entity.about_classroom.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGradeRepository extends JpaRepository<Grade,Integer> {
    @Query(value = "select grade_id,grade_name from grade",nativeQuery = true)
    List<Grade> findAllGrade();
}
