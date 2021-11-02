package com.codegym.service;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IStudentService{
    //    Dung Nm find student flow id class
    Page<Student> findStudentsByClassroomId(int classroomId, Pageable pageable);

    //creator: HaNTT, date: 23/10/2021
    Page<Student> findByClassroom(int classroomId, Pageable pageable);

    //creator: HaNTT, date: 23/10/2021
    List<Student> findWhereClassroomIdNull();

    //creator: HaNTT, date: 23/10/2021
    Student findStudentById(Integer id);


    Page<Student> getListStudent(Pageable pageable, Integer id);


    Student getListStudentDetail(Integer id);

    //Trùng với chị Hà nhưng khác kiểu trả về
    //Danh coding 2:00PM - 23-10-2021
    void updateClassForStudent(Integer classId,String status, Integer studentId);

    Student getById(int id);

    Student deleteById(int studentId);
    
    void saveStudent(Student student);

    void editStudent(Student student);

    //    Diệp search student ngày 25/10
    Page<Student> searchStudent(Pageable pageable, String inforStudent);

    Page<Student> findSearch(Pageable pageable, String name, String status);

    //creator: DanhNT
    void deleteStudentFromClass(Integer id);

    //DanhNT
    List<Student> findListStudentByClassroomId(Integer id);

    //LamNT
    int findNewIdStudent();
}
