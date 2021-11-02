package com.codegym.repository;


import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {



    // Diep search teacher 26/10
    @Query(value = "select * from teacher\n" +
            "where  teacher.teacher_name like %:search% or " +
            "teacher.teacher_gender like %:search% or teacher.teacher_date_of_birth like %:search% or " +
            "teacher.teacher_phone like %:search% or teacher.teacher_address like %:search%",
            nativeQuery = true)
    Page<Teacher> searchTeacher(Pageable pageable, @Param("search") String search);

    //native Query hien thi danh sach - LinhDN
    @Query(value = "select" +
            " teacher_id, delete_flag, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id" +
            " from teacher where delete_flag = false ", nativeQuery = true, countQuery = "select count(*)  from teacher where delete_flag = false;")
    Page<Teacher> findAllTeacherByQuery(Pageable pageable);

    @Query(value = "select" +
            " teacher_id, delete_flag, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id " +
            "from teacher where teacher_id = :id", nativeQuery = true)
    Optional<Teacher> findByIdTeacherByQuery(int id);


    //native Query hien thi danh sach theo tu khoa nhap vao- LinhDN
    @Query(value = "select teacher_id, delete_flag, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id\n" +
            "from teacher where (delete_flag = false and teacher_name like %:name%)", nativeQuery = true, countQuery = "select teacher_id, delete_flag, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id\n" +
            "from teacher where (delete_flag = false and teacher_name like %:name%)")
    Page<Teacher> findAllTeacherByQueryWithKeyword(Pageable pageable, @Param("name") String name);

    //native Query hien thi danh sach theo phong ban- LinhDN
    @Query(value = "select" +
            " teacher_id, delete_flag, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id " +
            "from teacher where (delete_flag = false and division_id = :id)", nativeQuery = true, countQuery = "select" +
            " teacher_id, delete_flag, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id " +
            "from teacher where (delete_flag = false and division_id = :id)")
    Page<Teacher> findByIdTeacherByDivision(Pageable pageable, int id);

    @Modifying
    @Query(value = "INSERT INTO `teacher` (`delete_flag`, `teacher_address`, `teacher_date_of_birth`, `teacher_email`, `teacher_gender`, `teacher_image`, `teacher_name`, `teacher_phone`, `teacher_university`, `degree_id`, `division_id`) " +
            "VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11);", nativeQuery = true)
    void createNewTeacher(Boolean deleteFlag, String address, String dateOfBirth, String email, Byte gender, String image, String name, String phone, String teacher_university, Integer divisionId, Integer degreeId);


    @Modifying
    @Query(value = "update teacher set delete_flag = ?1,teacher_address = ?2,teacher_date_of_birth= ?3,teacher_email = ?4,teacher_gender=?5,teacher_image=?6,teacher_name=?7,teacher_phone=?8,teacher_university=?9,degree_id=?10,division_id=?11 \n" +
            "where (teacher_id = ?12);", nativeQuery = true)
    void updateTeacher(Boolean deleteFlag, String address, String dateOfBirth, String email, Byte gender, String image, String name, String phone, String teacher_university, Integer divisionId, Integer degreeId, Integer teacherId);




    @Modifying
    @Query(value = "UPDATE teacher as c\n" +
            "SET c.teacher_phone =?1, c.teacher_address = ?2, c.teacher_email = ?3\n" +
            "WHERE teacher_id = ?4 ", nativeQuery = true)
    void editPersonInfor(String phone, String address, String email, Integer id);

    //Tim kiem theo ten & phong ban - LinhDN - 27/10 - 09:55
    @Query(value = "select * from teacher where delete_flag = false and ((?1 is Null or teacher_name like %?1%) and (?2 is null or division_id = ?2))",
            countQuery = "select * from teacher where delete_flag = false and ((?1 is Null or teacher_name like %?1%) and (?2 is null or division_id = ?2))",
            nativeQuery = true)
    Page<Teacher> findAllTeacherByQueryWithKeywordAndDivision(Pageable pageable, @Param("name") String name, @Param("id") Integer id);



    //native Query xoa 1 giao vien (~ update deleteFlag = true) - LinhDN
    @Modifying
    @Query(value = "update teacher set delete_flag = true where teacher_id = :id ", nativeQuery = true)
    void saveDeleteTeacher(int id);



//    PhucNk liên kết với account của kiệt
    @Query(value="select t.teacher_id, t.delete_flag, t.teacher_address, t.teacher_date_of_birth," +
            " t.teacher_email, t.teacher_gender, t.teacher_image, t.teacher_name, t.teacher_phone," +
            " t.teacher_university, t.account_id, t.degree_id, t.division_id from teacher as t" +
            " join account on t.account_id = account.account_id where account.account_username = ?1",
            nativeQuery = true)
    Teacher findTeacherAccountUserName(String userName);
}
