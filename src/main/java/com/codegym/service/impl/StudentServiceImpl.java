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

    @Override
    //    search Student by Nhật
    public Page<Student> findSearch(Pageable pageable, String name, String status) {
        return studentRepository.findSearch(pageable,"%"+name+"%","%"+status+"%");
    }
}
