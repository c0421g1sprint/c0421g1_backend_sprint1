package com.codegym.service;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService{
    //Trùng với chị Hà nhưng khác kiểu trả về
    //Danh coding 2:00PM - 23-10-2021
    void updateClassForStudent(Integer classId, Integer studentId);

    //creator: HaNTT, date: 23/10/2021
    Page<Student> findByClassroom(int classroomId, Pageable pageable);

    //creator: HaNTT, date: 23/10/2021
    List<Student> findWhereClassroomIdNull();

    //creator: HaNTT, date: 23/10/2021
    Student findStudentById(Integer id);

    //creator: HaNTT, date: 23/10/2021
    void deleteStudentFromClass(Integer id);

    //LamNT
    void saveStudent(Student student);

    //LamNT
    void editStudent(Student student);

    //LamNT
    int findNewIdStudent();

}
