package com.codegym.repository;

import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {

    //creator: HaNTT, date: 23/10/2021  (select-option)
    @Query(value = "SELECT teacher_id, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, " +
            "teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id," +
            "delete_flag\n" +
            "FROM teacher \n" +
            "WHERE teacher_id IN (\n" +
            "SELECT T.teacher_id FROM teacher T\n" +
            "LEFT JOIN classroom c ON c.teacher_id = t.teacher_id\n" +
            "WHERE c.teacher_id IS NULL);",
            nativeQuery = true)
    List<Teacher> findTeacherWhereTeacherIdNull();
}
