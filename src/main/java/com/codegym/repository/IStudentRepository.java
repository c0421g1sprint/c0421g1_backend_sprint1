package com.codegym.repository;

import com.codegym.entity.about_student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
