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
    @Query(value = "select classroom.classroom_id, classroom.classroom_name, classroom.classroom_school_year, " +
            "classroom.delete_flag, classroom.grade_id from classroom ",  nativeQuery = true)
    List<Classroom> findAllClass();
}
