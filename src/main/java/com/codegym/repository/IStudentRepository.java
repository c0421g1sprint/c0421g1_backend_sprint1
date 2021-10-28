package com.codegym.repository;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {


    @Query(value = "select * from student where student_id=?1", nativeQuery = true)
    Student getLStudentDetail(@Param("id") Integer id);


    @Query(value = " select student.student_id, student.delete_flag, student.student_address, " +
            "student.student_date_of_birth, student.student_ethnicity, student.student_father_name," +
            " student.student_gender, student.student_image, student.student_mother_name, student.student_name," +
            " student.student_parent_phone, student.student_religion, student.student_status, student.classroom_id ,t.teacher_id  " +
            " from classroom join teacher t on classroom.teacher_id = t.teacher_id join student on student.classroom_id = classroom.classroom_id " +
            "where t.teacher_id = :id ",
            countQuery = " select student.student_id, student.delete_flag, student.student_address, " +
                    "student.student_date_of_birth, student.student_ethnicity, student.student_father_name," +
                    " student.student_gender, student.student_image, student.student_mother_name, student.student_name," +
                    " student.student_parent_phone, student.student_religion, student.student_status, student.classroom_id ,t.teacher_id  " +
                    " from classroom join teacher t on classroom.teacher_id = t.teacher_id join student on student.classroom_id = classroom.classroom_id " +
                    "where t.teacher_id = :id ", nativeQuery = true)
    Page<Student> getListStudent(Pageable pageable, @Param("id") Integer id);

}
