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

//    // DungNM coding 5:00PM
//    @Modifying
//    @Query(value = "select c.classroom_id, c.classroom_name, c.classroom_school_year, c.delete_flag, c.grade_id, c.teacher_id\n" +
//            "from classroom c " +
//            "where c.delete_flag = false;", nativeQuery = true)
//    List<Classroom> findAllList();

    //QuanTA && TaiNP
    @Query(value = "select classroom_id,classroom_name,classroom_school_year,delete_flag,grade_id,teacher_id " +
            "from classroom where delete_flag = false",nativeQuery = true)
    List<Classroom> findAllList();

    // DanhNT coding 5:00PM
    @Query(value = "select c.classroom_id, c.classroom_name, c.classroom_school_year, c.delete_flag, c.grade_id, c.teacher_id\n" +
            "from classroom c\n" +
            "where c.delete_flag = false and c.classroom_id = ?1", nativeQuery = true)
    Optional<Classroom> findById(Integer id);

    //DanhNT Coding for update class 11:30PM
    @Modifying
    @Transactional
    @Query(value = "update classroom \n" +
            "set classroom_school_year = ?1, teacher_id = ?2\n" +
            "where classroom_id = ?3", nativeQuery = true)
    void updateSchoolYear(String schoolYear, Integer teacherId, Integer classId);

    //DanhNT coding find all list class pagination
    @Query(value = "select c.classroom_id, c.classroom_name, c.classroom_school_year, c.delete_flag, c.grade_id, c.teacher_id\n" +
            "from classroom c\n" +
            "where c.delete_flag = false",
            countQuery = "select count(*)\n" +
                    "from classroom c \n" +
                    "where c.delete_flag = false"
            ,nativeQuery = true)
    Page<Classroom> findAllPage(Pageable pageable);

    //creator: HaNTT merge DanhNT, date: 23/10/2021  (check class Duplicate)
    @Query(value="select classroom_id, classroom_name, classroom_school_year, delete_flag, grade_id, teacher_id\n" +
            "from classroom\n" +
            "where (classroom_name = ?1 or classroom_name = ?2) and  classroom_school_year = ?3",
            nativeQuery = true)
    Classroom findClassByNameAndSchoolYear(String firstName,String secondName, String schoolYear);

    //DanhNT coding update className
    @Modifying
    @Transactional
    @Query(value = "update classroom\n" +
            "set classroom_name = ?1, grade_id = ?2\n" +
            "where classroom_id = ?3" , nativeQuery = true)
    void updateClassNameAfterPromote(String newName, Integer gradeId, Integer classId);

    //creator: HaNTT, date: 23/10/2021  (tạp lớp mới)
    @Modifying
    @Query(value="INSERT INTO classroom(classroom_name, classroom_school_year, grade_id,teacher_id, delete_flag)\n" +
            "values (?1,?2,?3,?4,?5);",
            nativeQuery = true)
    Integer saveClassRoom(String name, String schoolYear, Integer gradeId,Integer teacherId, boolean deleteFlag);

}
