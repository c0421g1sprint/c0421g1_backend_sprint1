package com.codegym.repository;

import com.codegym.entity.about_classroom.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IGradeRepository extends JpaRepository<Grade,Integer> {
    // QuanTA query find Grade 27/10
    @Query(value = "select grade_id,grade_name from grade",nativeQuery = true)
    List<Grade> findAllGrade();
}
