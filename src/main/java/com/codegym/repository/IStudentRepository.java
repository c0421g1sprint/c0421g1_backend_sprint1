package com.codegym.repository;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    //creator: HaNTT, date: 23/10/2021 (khi nhấn nút chọn student có sẵn: checkbox)
    @Query(value="SELECT student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity," +
            " student_father_name, student_gender, student_image, student_mother_name, student_name, " +
            "student_parent_phone, student_religion, student_status, classroom_id\n" +
            "FROM sprint1.student\n" +
            "WHERE classroom_id is null",
            countQuery="SELECT student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, classroom_id\n" +
                    "FROM sprint1.student\n" +
                    "WHERE classroom_id is null;",
            nativeQuery = true)
    Page<Student> findWhereClassroomIdNull(Pageable pageable);

    //creator: HaNTT, date: 23/10/2021 (khi nhấn button tạo mới student: find one --> add to list student)
    @Query(value= "SELECT student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, " +
            "student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, classroom_id\n" +
            "FROM sprint1.student\n" +
            "WHERE student_id = ?;",
            nativeQuery = true)
    Student findStudentWhereId(Integer id);

    //creator: HaNTT, date: 23/10/2021 (set classId cho new student)
    @Modifying
    @Query(value= "UPDATE student\n" +
            "SET classroom_id =:classRoomId\n" +
            "WHERE student_id =:studentId\n" ,
            nativeQuery = true)
    Integer setClassroomForNewStudent(Integer classRoomId, Integer studentId);

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
            "WHERE classroom_id is null",
            countQuery="SELECT student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, classroom_id\n" +
                    "FROM sprint1.student\n" +
                    "WHERE classroom_id is null;",
            nativeQuery = true)
    Page<Student> findWhereClassroomIdNull(Pageable pageable);

    //creator: HaNTT, date: 23/10/2021 (khi nhấn button tạo mới student: find one --> add to list student)
    @Query(value= "SELECT student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, " +
            "student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, classroom_id\n" +
            "FROM sprint1.student\n" +
            "WHERE student_id = ?;",
            nativeQuery = true)
    Student findStudentWhereId(Integer id);
}
