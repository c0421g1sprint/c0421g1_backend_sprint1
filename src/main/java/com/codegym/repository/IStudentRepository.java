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

    //creator: HaNTT, date: 23/10/2021
    @Query("select s from Student s where s.classroom.classroomId = :id and s.deleteFlag=false ")
    Page<Student> findByClassroomId(int id, Pageable pageable);


    //DungNM - lấy danh sách học sinh theo ID lớp
    @Query(value = "SELECT " +
            "student_id, s.delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, " +
            "student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, " +
            "student_status, s.classroom_id " +
            "FROM student s " +
            "JOIN classroom c ON s.classroom_id = c.classroom_id " +
            "JOIN teacher t ON t.teacher_id = c.teacher_id " +
            "WHERE s.classroom_id=:id AND s.delete_flag = false ORDER BY s.student_id",
            countQuery = "SELECT count(*) " +
                    "FROM student s " +
                    "JOIN classroom c ON s.classroom_id = c.classroom_id " +
                    "JOIN teacher t ON t.teacher_id = c.teacher_id " +
                    "WHERE s.classroom_id=:id AND s.delete_flag = false ORDER BY s.student_id",
            nativeQuery = true)
    Page<Student> findStudentsByClassroomId(int id, Pageable pageable);

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
    @Query(value = "select " +
            "s.student_id, s.student_gender, s.student_father_name, s.student_mother_name, s.student_date_of_birth, s.student_ethnicity, " +
            "s.student_address,s.student_name,s.student_religion, s.student_image, s.student_status, s.student_parent_phone, s.delete_flag, s.classroom_id, m.mark_point_number1,\n" +
            " m.mark_point_number2, m.mark_point_number3\n" +
            " from student s" +
            " join classroom on s.classroom_id = classroom.classroom_id " +
            " join mark m on s.student_id = m.student_id" +
            " join grade on classroom.grade_id = grade.grade_id" +
            " where s.student_name like :inforStudent or s.student_date_of_birth like :inforStudent or classroom.classroom_name like :inforStudent",
            countQuery = "SELECT count(*)" +
                    " from student s\n" +
                    " join classroom on s.classroom_id = classroom.classroom_id \n" +
                    " join mark m on s.student_id = m.student_id\n" +
                    " join grade on classroom.grade_id = grade.grade_id\n" +
                    " where s.student_name like :inforStudent or s.student_date_of_birth like :inforStudent or classroom.classroom_name like :inforStudent",
            nativeQuery = true)
    Page<Student> searchStudent(Pageable pageable, @Param("inforStudent") String inforStudent);

    @Query(value = "select " +
            "student_id, delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, student_gender, student_image, student_mother_name, student_name, student_parent_phone, student_religion, student_status, classroom_id " +
            "from student s " +
            "where s.student_name like :name and s.student_status like :status",
            countQuery = "SELECT count(*) " +
                    "FROM student s " +
                    "where s.student_name like :name and s.student_status like :status",
            nativeQuery = true)
        //    search Student by Nhật
    Page<Student> findSearch(Pageable pageable, @Param("name") String name, @Param("status") String status);

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
