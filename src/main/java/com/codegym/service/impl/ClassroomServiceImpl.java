package com.codegym.service.impl;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.repository.IClassroomRepository;
import com.codegym.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements IClassroomService {
    @Autowired
    private IClassroomRepository classroomRepository;
    //search method search Classroom exists
    @Override
    public List<Classroom> findAllClassroomExist() {
        return this.classroomRepository.findAllClassroomExist();
    }

}
