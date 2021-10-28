package com.codegym.service.impl;
import com.codegym.entity.about_student.Student;
import com.codegym.repository.IStudentRepository;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    //Phuc
//    @Override
//    public Page<Student> getListStudent(Pageable pageable, Integer id) {
//        return studentRepository.getListStudent(pageable,id);
//    }
//    //Phuc
//    @Override
//    public Student getListStudentDetail(Integer id) {
//        return studentRepository.findStudentWhereId(id);
//    }

    //Trùng code với chị Hà
    //Danh coding 2:00PM - 23-10-2021
    @Override
    public void updateClassForStudent(Integer classId, Integer studentId) {
        this.studentRepository.updateClassForStudent(classId, studentId);
    }

    //creator: HaNTT, date: 23/10/2021
    @Override
    public Page<Student> findByClassroom(int classroomId, Pageable pageable) {
        return studentRepository.findByClassroomId(classroomId, pageable);
    }

    //creator: HaNTT, date: 23/10/2021
    @Override
    public Page<Student> findWhereClassroomIdNull(Pageable pageable) {
        return studentRepository.findWhereClassroomIdNull(pageable);
    }

    //creator: HaNTT, date: 23/10/2021
    @Override
    public Student findStudentById(Integer id) {
        return studentRepository.findStudentWhereId(id);
    }

    //creator: HaNTT, date: 23/10/2021
    @Override
    public void deleteStudentFromClass(Integer id) {
       this.studentRepository.deleteStudentFromClass(id);
    }



}
