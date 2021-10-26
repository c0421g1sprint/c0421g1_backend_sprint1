package com.codegym.repository;

import com.codegym.entity.about_student.Mark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IMarkRepository extends JpaRepository<Mark, Integer> {
    @Query(value = "SELECT mark_id, mark_point_number1, mark_point_number2, mark_point_number3, student_id, subject_id\n" +
            "FROM mark ", nativeQuery = true)
    Page<Mark> getAllMarkStudent(Pageable pageable);

    @Query(value = "SELECT mark_id, mark_point_number1, mark_point_number2, mark_point_number3, student_id, subject_id\n" +
            "FROM mark \n" +
            "WHERE mark_id = ?1", nativeQuery = true)
    Mark getById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE mark as m\n" +
            "SET m.mark_point_number1=?1, m.mark_point_number2=?2, m.mark_point_number3=?3 \n" +
            "WHERE m.mark_id =?4 ", nativeQuery = true)
    void editMark(Double point1, Double point2, Double point3, Integer id);

    @Query(value = "SELECT *\n" +
            "FROM mark\n" +
            "JOIN student s on mark.student_id = s.student_id\n" +
            "JOIN subject sb on mark.subject_id = sb.subject_id\n" +
            "WHERE (?1 IS NULL OR s.student_name LIKE %?1%) AND  (sb.subject_name = ?2)", nativeQuery = true)
    Page<Mark> findAllStudentByName(Pageable pageable,String nameStudent, String subject);
}
