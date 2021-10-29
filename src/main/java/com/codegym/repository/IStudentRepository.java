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

//Phuc xem thong tin hoc sinh cua giao vien chu nhiem
    @Query(value = " select student.student_id, student.delete_flag, student.student_address, " +
            "student.student_date_of_birth, student.student_ethnicity, student.student_father_name," +
            " student.student_gender, student.student_image, student.student_mother_name, student.student_name," +
            " student.student_parent_phone, student.student_religion, student.student_status, student.classroom_id ,t.teacher_id  " +
            " from classroom join teacher t on classroom.teacher_id = t.teacher_id join student on student.classroom_id = classroom.classroom_id " +
            "where t.teacher_id = :id ",
            countQuery = " select student.student_id, student.delete_flag, student.student_address, " +
                    "student.student_date_of_birth, student.student_ethnicity, student.student_father_name," +
                    " student.student_gender, student.student_image, student.student_mother_name, student.student_name," +
                    " student.student_parent_phone, student.student_religion, student.student_status, student.classroom_id ,t.teacher_id  " +
                    " from classroom join teacher t on classroom.teacher_id = t.teacher_id join student on student.classroom_id = classroom.classroom_id " +
                    "where t.teacher_id = :id ", nativeQuery = true)
    Page<Student> getListStudent(Pageable pageable, @Param("id") Integer id);

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
            "FROM student\n" +
            "WHERE classroom_id is null",
            countQuery="SELECT student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, classroom_id\n" +
                    "FROM student\n" +
                    "WHERE classroom_id is null;",
            nativeQuery = true)
    Page<Student> findWhereClassroomIdNull(Pageable pageable);

    //creator: HaNTT, date: 23/10/2021 (khi nhấn button tạo mới student: find one --> add to list student)
    @Query(value= "SELECT student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, " +
            "student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, classroom_id\n" +
            "FROM student\n" +
            "WHERE student_id = ?;",
            nativeQuery = true)
    Student findStudentWhereId(Integer id);

//    //Phuc xem chi tiet hoc sinh
//    @Query(value = "select * from student where student_id=?1", nativeQuery = true)
//    Optional<Student> getListStudentDetail(@Param("id") Integer id);

}
