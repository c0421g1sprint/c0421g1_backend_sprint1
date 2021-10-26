package com.codegym.repository;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select " +
            "student_id, s.delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, s.classroom_id " +
            "from student s " +
            "join classroom c on s.classroom_id = c.classroom_id " +
            "where s.classroom_id=:id and s.delete_flag = false order by s.student_id", nativeQuery = true)
    Page<Student> findByClassroomId(int id, Pageable pageable);

    @Query(value = "select " +
            "student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, classroom_id " +
            "from student s where s.student_id = :id", nativeQuery = true)
    Student getStudentById(int id);

    @Modifying
    @Query(value = "update student s " +
            "set s.delete_flag = true " +
            "where s.student_id = :id", nativeQuery = true)
    void deleteStudentById(@Param("id") Integer id);

    // Diep: search student 5h12 ngày 25/10
    @Query(value="select s.student_id, s.student_gender, s.student_father_name, " +
            "s.student_mother_name, s.student_date_of_birth, s.student_ethnicity, " +
            "s.student_address,s.student_name,s.student_religion, s.student_image," +
            "s.student_status, s.student_parent_phone, s.delete_flag, s.classroom_id" +
            "  from student s" +
            " join classroom on s.classroom_id = classroom.classroom_id " +
            " join mark on s.student_id = mark.student_id" +
            " join grade on classroom.grade_id = grade.grade_id" +
            " where s.student_name like %:searchstudent% or s.student_date_of_birth like %:searchstudent%" +
            " or classroom.classroom_name like %:searchstudent%", nativeQuery = true)
    Page<Student> searchstudent(Pageable pageable,@Param("searchstudent") String searchstudent);


}
