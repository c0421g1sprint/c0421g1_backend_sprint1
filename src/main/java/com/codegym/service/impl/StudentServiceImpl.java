package com.codegym.service.impl;

import com.codegym.entity.about_student.Student;
import com.codegym.repository.IStudentRepository;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    //Phuc
    @Override
    public Page<Student> getListStudent(Pageable pageable, Integer id) {
        return studentRepository.getListStudent(pageable,id);

    }
    //Phuc
    @Override
    public Optional<Student> getListStudentDetail(Integer id) {
        return studentRepository.getListStudentDetail(id);
    }
}
