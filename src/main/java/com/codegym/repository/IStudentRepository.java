package com.codegym.repository;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    //DungNM - lấy danh sách học sinh theo ID lớp
    @Query(value = "SELECT " +
            "student_id, s.delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, s.classroom_id " +
            "FROM student s " +
            "JOIN classroom c ON s.classroom_id = c.classroom_id " +
            "WHERE s.classroom_id=:id AND s.delete_flag = false ORDER BY s.student_id",
            countQuery = "SELECT count(*) " +
                    "FROM student s JOIN classroom c ON s.classroom_id = c.classroom_id " +
                    "WHERE s.classroom_id=:id AND s.delete_flag = false ORDER BY s.student_id",
            nativeQuery = true)
    Page<Student> findByClassroomId(int id, Pageable pageable);

    //DungNM - lấy đối tượng học sinh theo ID của học sinh
    @Query(value = "select " +
            "student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, classroom_id " +
            "from student s where s.student_id = :id", nativeQuery = true)
    Student getStudentById(int id);

    //DungNM - gắn cờ delete cho đối tượng học sinh theo ID
    @Modifying
    @Query(value = "update student s " +
            "set s.delete_flag = true " +
            "where s.student_id = :id", nativeQuery = true)
    void deleteStudentById(@Param("id") Integer id);

    //LamNT do create function
    @Modifying
    @Query(value = "insert into `sprint1`.`student` (delete_flag,student_address, student_date_of_birth, student_ethnicity," +
            "student_father_name, student_gender, student_mother_name, student_name, student_parent_phone, student_religion) " +
            "VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    void saveStudent(boolean delete_flag, String student_address, String student_date_of_birth, String student_ethnicity, String student_father_name,
                     String student_gender, String student_mother_name, String student_name, String student_parent_phone, String student_religion);

    //LamNT do update function
    @Modifying
    @Query(value = "update `sprint1`.`student` set student_address = ?1, student_date_of_birth = ?2, student_ethnicity = ?3," +
            " student_father_name = ?4, student_gender = ?5, student_mother_name = ?6, student_name = ?7," +
            " student_parent_phone = ?8, student_religion = ?9 where (student_id = ?10)", nativeQuery = true)
    void editStudent(String student_address, String student_date_of_birth, String student_ethnicity, String student_father_name,
                     String student_gender, String student_mother_name, String student_name, String student_parent_phone,
                     String student_religion, Integer student_id);

     // Diep: search student 5h12 ngày 25/10
    @Query(value = "select s.student_id, s.student_gender, s.student_father_name, s.student_mother_name, s.student_date_of_birth, s.student_ethnicity, "
            + "s.student_address,s.student_name,s.student_religion, s.student_image, s.student_status," +
            " s.student_parent_phone, s.delete_flag, s.classroom_id, m.mark_point_number1,\n"
            + " m.mark_point_number2, m.mark_point_number3\n" +
            " from student s" + " join classroom on s.classroom_id = classroom.classroom_id " +
            " join mark m on s.student_id = m.student_id " + " join grade on classroom.grade_id = grade.grade_id"
            + " where s.student_id like :inforStudent or s.student_name like :inforStudent or s.student_date_of_birth like :inforStudent" +
            " or classroom.classroom_name like :inforStudent " +
            "group by s.student_id",
            countQuery = "SELECT count(*)" + " from student s\n" +
                    " join classroom on s.classroom_id = classroom.classroom_id \n" +
                    " join mark m on s.student_id = m.student_id\n" +
                    " join grade on classroom.grade_id = grade.grade_id\n" +
                    " where  s.student_id like :inforStudent or s.student_name like :inforStudent or s.student_date_of_birth" +
                    " like :inforStudent or classroom.classroom_name like :inforStudent " +
                    "group by s.student_id", nativeQuery = true)
    Page<Student> searchStudent(Pageable pageable,@Param("inforStudent") String inforStudent);

}
