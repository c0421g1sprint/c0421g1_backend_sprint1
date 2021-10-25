package com.codegym.repository;

import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {
    //native Query hien thi danh sach - LinhDN
    @Query(value = "select" +
            " teacher_id, delete_flag, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id" +
            " from teacher where delete_flag = false ", nativeQuery = true, countQuery="select count(*)  from teacher where delete_flag = false;")
    Page<Teacher> findAllTeacherByQuery(Pageable pageable);

    //native Query chon 1 giao vien - LinhDN
    @Query(value = "select" +
            " teacher_id, delete_flag, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id " +
            "from teacher where teacher_id = :id", nativeQuery = true)
    Optional<Teacher> findByIdTeacherByQuery(int id);

    //native Query xoa 1 giao vien (~ update deleteFlag = true) - LinhDN
    @Modifying
    @Query(value = "update teacher set delete_flag = true where teacher_id = :id ", nativeQuery = true)
    void saveDeleteTeacher(int id);

    //native Query hien thi danh sach theo tu khoa nhap vao- LinhDN
    @Query(value = "select teacher_id, delete_flag, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id\n" +
            "from teacher where (delete_flag = false and teacher_name like %:name%)", nativeQuery = true, countQuery="select teacher_id, delete_flag, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id\n" +
            "from teacher where (delete_flag = false and teacher_name like %:name%)")
    Page<Teacher> findAllTeacherByQueryWithKeyword(Pageable pageable, @Param("name") String name);

    //native Query hien thi danh sach theo phong ban- LinhDN
    @Query(value = "select" +
            " teacher_id, delete_flag, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id " +
            "from teacher where (delete_flag = false and division_id = :id)", nativeQuery = true, countQuery="select" +
            " teacher_id, delete_flag, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id " +
            "from teacher where (delete_flag = false and division_id = :id)")
    Page<Teacher> findByIdTeacherByDivision(Pageable pageable, int id);
}
