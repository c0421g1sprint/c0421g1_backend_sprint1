package com.codegym.repository;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    //Trùng code với chị Hà nhưng khác nhau kiểu trả về
    //DanhNT coding for edit class for student 11:30 PM 22-10-21
    @Modifying
    @Transactional
    @Query(value = "update student\n" +
            "set classroom_id = ?1\n" +
            "where student_id = ?2",nativeQuery = true)
    void updateClassForStudent(Integer classId,Integer studentId);

    //creator: HaNTT, date: 23/10/2021
    @Query("select s from Student s where s.classroom.classroomId = :id and s.deleteFlag=false ")
    Page<Student> findByClassroomId(int id, Pageable pageable);

    //creator: HaNTT, date: 23/10/2021 (khi nhấn nút chọn student có sẵn: checkbox)
    @Query(value="SELECT student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity," +
            " student_father_name, student_gender, student_image, student_mother_name, student_name, " +
            "student_parent_phone, student_religion, student_status, classroom_id\n" +
            "FROM sprint1.student\n" +
            "WHERE classroom_id is null and student_status = 'lưu ban'",
            nativeQuery = true)
    List<Student> findWhereClassroomIdNull();

    //creator: HaNTT, date: 23/10/2021 (khi nhấn button tạo mới student: find one --> add to list student)
    @Query(value= "SELECT student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, " +
            "student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, classroom_id\n" +
            "FROM student\n" +
            "WHERE student_id = ?;",
            nativeQuery = true)
    Student findStudentWhereId(Integer id);

    //creator: DanhNT
    @Modifying
    @Query(value = "update student\n" +
            "set classroom_id = null\n" +
            "where student_id = ?1",nativeQuery = true)
    void deleteStudentFromClass(Integer id);

    //DanhNT
    @Query(value = "select student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, classroom_id " +
            "from student " +
            "where classroom_id = ?1", nativeQuery = true)
    List<Student> findAllByClassroomId(Integer id);


    //LamNT do create function
    @Modifying
    @Query(value = "insert into `sprint1`.`student` (delete_flag,student_address, student_date_of_birth, student_ethnicity," +
            "student_father_name, student_gender, student_mother_name, student_name, student_parent_phone, student_religion,student_image) " +
            "VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)", nativeQuery = true)
    void saveStudent(boolean delete_flag, String student_address, String student_date_of_birth, String student_ethnicity, String student_father_name,
                     String student_gender, String student_mother_name, String student_name, String student_parent_phone, String student_religion,String student_image);

    //LamNT do update function
    @Modifying
    @Query(value = "update `sprint1`.`student` set student_address = ?1, student_date_of_birth = ?2, student_ethnicity = ?3," +
            " student_father_name = ?4, student_gender = ?5, student_mother_name = ?6, student_name = ?7," +
            " student_parent_phone = ?8, student_religion = ?9,student_image = ?10 where (student_id = ?11)", nativeQuery = true)
    void editStudent(String student_address, String student_date_of_birth, String student_ethnicity, String student_father_name,
                     String student_gender, String student_mother_name, String student_name, String student_parent_phone,
                     String student_religion,String student_image, Integer student_id);


    //LamNT
    @Query(value = "SELECT MAX(student_id) AS max FROM student",nativeQuery = true)
    int findNewIdStudent();
}
