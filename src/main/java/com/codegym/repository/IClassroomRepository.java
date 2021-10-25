package com.codegym.repository;

import com.codegym.entity.about_classroom.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IClassroomRepository extends JpaRepository<Classroom, Integer> {
    //creator: HaNTT, date: 23/10/2021  (check class Duplicate)
    @Query(value="SELECT classroom_id, classroom_name, classroom_school_year, delete_flag, grade_id, teacher_id\n" +
            "FROM classroom\n" +
            "WHERE classroom_name = ?1 and classroom_school_year =?2",
            nativeQuery = true)
    Classroom findClassByNameAndSchoolYear(String name, String schoolYear);

    //creator: HaNTT, date: 23/10/2021  (tạp lớp mới)
    @Modifying
    @Query(value="INSERT INTO sprint1.classroom(classroom_name, classroom_school_year, grade_id,teacher_id, delete_flag)\n" +
            "values (?1,?2,?3,?4,?5);",
            nativeQuery = true)
    Integer saveClassRoom(String name, String schoolYear, Integer gradeId,Integer teacherId, boolean deleteFlag);

}
