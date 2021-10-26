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
    @Query(value = "select " +
            "student_id, s.delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, s.classroom_id " +
            "from student s " +
            "join classroom c on s.classroom_id = c.classroom_id " +
            "where s.classroom_id=:id and s.delete_flag = false order by s.student_id", nativeQuery = true)
    Page<Student> findByClassroomId(int id, Pageable pageable);

    @Query(value = "select " +
            "student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, classroom_id " +
            "from student s where s.student_id = :id", nativeQuery = true)
    Student getStudentById(int id);

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

    @Query(value="select * " +
            "from student s inner join classroom c on s.classroom_id = c.classroom_id where s.student_name like :name " +
            "and s.student_status like :status",nativeQuery=true)
            //    search Student by Nhật
            Page<Student> findSearch(Pageable pageable, @Param("name") String name, @Param("status") String status);

}
