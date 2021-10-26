package com.codegym.repository;

import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {

//    @Query(value= "select * from teacher join acount on teacher.teacher_id = acount.teacher_id where acount.acount_id =?1", nativeQuery = true)
//    Teacher findTeacherByAccountId();
}
