package com.codegym.service.impl;

import com.codegym.entity.about_student.Student;
import com.codegym.repository.IStudentRepository;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
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
    public Integer setClassroomForNewStudent(Integer classRoomId, Integer studentId) {
        return studentRepository.setClassroomForNewStudent(classRoomId, studentId);
    }

}
