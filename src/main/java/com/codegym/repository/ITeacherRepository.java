package com.codegym.repository;

import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {

}
