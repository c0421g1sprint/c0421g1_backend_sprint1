package com.codegym.repository;

import com.codegym.entity.about_classroom.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IGradeRepository extends JpaRepository<Grade, Integer> {
    //DungNM - sử dụng lại code của TaiNP - Lấy danh sách toàn bộ khối
    @Query(value = "select g.grade_id, g.grade_name from grade g",nativeQuery = true)
    List<Grade> findAllGrade();
}
