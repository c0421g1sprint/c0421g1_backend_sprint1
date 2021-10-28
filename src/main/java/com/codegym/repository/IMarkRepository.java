package com.codegym.repository;

import com.codegym.entity.about_student.Mark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface IMarkRepository extends JpaRepository<Mark, Integer> {

//    MinhNN 27/10 lấy danh sách điểm và thông tin học sinh
    @Query(value = "SELECT mark_id, mark_point_number1, mark_point_number2, mark_point_number3, student_id, subject_id\n" +
            "FROM mark ", nativeQuery = true)
    Page<Mark> getAllMarkStudent(Pageable pageable);

//  MinhNN 27/10 lấy ra giá trị id
    @Query(value = "SELECT mark_id, mark_point_number1, mark_point_number2, mark_point_number3, student_id, subject_id\n" +
            "FROM mark \n" +
            "WHERE mark_id = ?1", nativeQuery = true)
    Mark getById(Integer id);


    //  MinhNN 27/10
    @Modifying
    @Transactional
    @Query(value = "UPDATE mark as m\n" +
            "SET m.mark_point_number1=?1, m.mark_point_number2=?2, m.mark_point_number3=?3 \n" +
            "WHERE m.mark_id =?4 ", nativeQuery = true)
    void editMark(Double point1, Double point2, Double point3, Integer id);


//  MinhNN 27/10
    @Query(value = "SELECT mark.mark_id, mark.mark_point_number1, mark.mark_point_number2, mark.mark_point_number3, s.student_id, sb.subject_id\n" +
            "FROM mark\n" +
            "JOIN student s on mark.student_id = s.student_id\n" +
            "JOIN subject sb on mark.subject_id = sb.subject_id\n" +
            "JOIN classroom c ON s.classroom_id = c.classroom_id\n" +
            "WHERE (?1 IS NULL OR s.student_name LIKE %?1%) AND  (?2 IS NULL OR sb.subject_id = ?2) AND (?3 IS NULL OR c.classroom_name LIKE %?3%)",
            countQuery = "SELECT COUNT(*) FROM mark " +
                    "JOIN student s on mark.student_id = s.student_id\n" +
                    "JOIN subject sb on mark.subject_id = sb.subject_id\n" +
                    "JOIN classroom c ON s.classroom_id = c.classroom_id\n" +
                    "WHERE (?1 IS NULL OR s.student_name LIKE %?1%)\n" +
                    "AND  (?2 IS NULL OR sb.subject_id = ?2)\n" +
                    "AND (?3 IS NULL OR c.classroom_name LIKE %?3%)"

            ,nativeQuery = true)
    Page<Mark> findAllStudentByName(Pageable pageable,String nameStudent, Integer id, String className);
}
