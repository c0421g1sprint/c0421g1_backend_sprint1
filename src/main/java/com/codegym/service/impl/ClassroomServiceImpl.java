package com.codegym.service.impl;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.repository.IClassroomRepository;
import com.codegym.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements IClassroomService {
    @Autowired
    private IClassroomRepository classroomRepository;

    //creator: HaNTT, date: 23/10/2021  (check class Duplicate)
    @Override
    public Classroom findClassByNameAndSchoolYear(String name, String schoolYear) {
        return this.classroomRepository.findClassByNameAndSchoolYear(name, schoolYear);
    }

    //creator: HaNTT, date: 23/10/2021  (tạo mới)
    @Override
    public Integer saveClassRoom(String name, String schoolYear, Integer gradeId,Integer teacherId, boolean deleteFlag) {
        return classroomRepository.saveClassRoom(name, schoolYear, gradeId,teacherId, deleteFlag);
    }

}
