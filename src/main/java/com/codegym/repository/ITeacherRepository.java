package com.codegym.repository;

import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {
    //    MinhNN 24/10 update infor teacher
    @Modifying
    @Query(value = "UPDATE teacher as c\n" +
            "SET c.teacher_phone =?1, c.teacher_address = ?2, c.teacher_email = ?3\n" +
            "WHERE c.account_id = ?4 ", nativeQuery = true)
    void editPersonInfor(String phone, String address, String email, Integer id);

    @Query(value = "SELECT *\n" +
            "FROM teacher\n" +
            "WHERE teacher_id = ?1", nativeQuery = true)
    Teacher getById(Integer id);

}
