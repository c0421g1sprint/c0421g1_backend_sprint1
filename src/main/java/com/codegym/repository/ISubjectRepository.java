package com.codegym.repository;

import com.codegym.entity.about_schedule.Subject;
import com.codegym.entity.about_student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISubjectRepository extends JpaRepository<Subject, Integer> {
//    MinhNN 27/10
    @Query(value = "select subject_id,subject_name from subject", nativeQuery = true)
    List<Subject> findAllSubject();
}
