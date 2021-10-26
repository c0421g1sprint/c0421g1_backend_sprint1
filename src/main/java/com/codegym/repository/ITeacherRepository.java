package com.codegym.repository;

import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {

    // Diep search teacher 26/10
    //    @Query(value = "select * from teacher\n" +
//            "where teacher.teacher_id =:teacherId or teacher.teacher_name like :teacherName or " +
//            "teacher.teacher_gender =:teacherGender or teacher.teacher_date_of_birth like :teacherDateOfBirth or " +
//            "teacher.teacher_phone like :teacherPhone or teacher.teacher_address like :teacherAddress",
//            nativeQuery = true)
//    Page<Teacher> searchTeacher(Pageable pageable, Integer teacherId, String teacherName,
//                                Byte teacherGender, Date teacherDateOfBirth, String teacherPhone,
//                                String teacherAddress);
    @Query(value = "select * from teacher\n" +
            "where  teacher.teacher_name like %:search% or " +
            "teacher.teacher_gender like %:search% or teacher.teacher_date_of_birth like %:search% or " +
            "teacher.teacher_phone like %:search% or teacher.teacher_address like %:search%",
            nativeQuery = true)
    Page<Teacher> searchTeacher(Pageable pageable, @Param("search") String search);


}
