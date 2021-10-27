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
    @Query(value = "select classroom_id,classroom_name,classroom_school_year,delete_flag,grade_id,teacher_id " +
            "from classroom where delete_flag = false",nativeQuery = true)
    List<Classroom> findAllClassroomExist();
}
