package com.codegym.repository;

import com.codegym.entity.about_classroom.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface IClassroomRepository extends JpaRepository<Classroom, Integer> {


    //QuanTA && TaiNP
    @Query(value = "select classroom_id,classroom_name,classroom_school_year,delete_flag,grade_id,teacher_id " +
            "from classroom where delete_flag = false", nativeQuery = true)
    List<Classroom> findAllClassroomExist();


    // DanhNT coding 5:00PM
    @Query(value = "select classroom_id, classroom_name, classroom_school_year, delete_flag, grade_id, teacher_id\n" +
            "from classroom\n" +
            "where classroom_id = ?1\n", nativeQuery = true)
    Optional<Classroom> findById(int id);

    //DanhNT Coding for update class 11:30PM
    @Modifying
    @Transactional
    @Query(value = "update classroom \n" +
            "set classroom_school_year = ?1, teacher_id = ?2\n" +
            "where classroom_id = ?3", nativeQuery = true)
    void updateSchoolYear(String schoolYear, Integer teacherId, Integer classId);

    //DanhNT coding find all list class pagination
    @Query(value = "select classroom_id, classroom_name, classroom_school_year, c.delete_flag, grade_id,\n" +
            "t.teacher_id, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender,\n" +
            " teacher_image, teacher_name, teacher_phone, teacher_university, account_id, degree_id, division_id\n" +
            "from classroom c\n" +
            "join teacher t on t.teacher_id = c.teacher_id\n" +
            "where c.delete_flag = false\n",
            countQuery = "select count(*)\n" +
                    "from classroom c\n" +
                    "join teacher t on t.teacher_id = c.teacher_id\n" +
                    "where c.delete_flag = false"
            , nativeQuery = true)
    Page<Classroom> findAllPage(Pageable pageable);

    //creator: HaNTT merge DanhNT, date: 23/10/2021  (check class Duplicate)
    @Query(value = "select classroom_id, classroom_name, classroom_school_year, delete_flag, grade_id, teacher_id\n" +
            "from classroom\n" +
            "where (classroom_name = ?1 or classroom_name = ?2) and  classroom_school_year = ?3",
            nativeQuery = true)
    Classroom findClassByNameAndSchoolYear(String firstName, String secondName, String schoolYear);

    //DanhNT coding update className
    @Modifying
    @Transactional
    @Query(value = "update classroom\n" +
            "set classroom_name = ?1, grade_id = ?2\n" +
            "where classroom_id = ?3", nativeQuery = true)
    void updateClassNameAfterPromote(String newName, Integer gradeId, Integer classId);

    //creator: HaNTT, date: 23/10/2021  (tạp lớp mới)
    @Modifying
    @Query(value = "INSERT INTO classroom(classroom_name, classroom_school_year, grade_id,teacher_id, delete_flag)\n" +
            "values (?1,?2,1,?3,false);",
            nativeQuery = true)
    Integer saveClassRoom(String name, String schoolYear, Integer teacherId);


}
