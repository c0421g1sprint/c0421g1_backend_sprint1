package com.codegym.repository;

import com.codegym.entity.about_classroom.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IClassroomRepository extends JpaRepository<Classroom, Integer> {

    // TaiNP query findALL class
    @Query(value = "select c.classroom_id, c.classroom_name, c.classroom_school_year, " +
            "c.delete_flag, c.grade_id, c.teacher_id from classroom c ",  nativeQuery = true)
    List<Classroom> findAllClass();
}
