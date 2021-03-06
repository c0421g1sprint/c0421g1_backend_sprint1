package com.codegym.service.impl;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.repository.IClassroomRepository;
import com.codegym.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClassroomServiceImpl implements IClassroomService {
    @Autowired
    private IClassroomRepository classroomRepository;


    //DungNM - sử dụng lại code từ DanhNT - lấy toàn bộ danh sách lớp có trong DB
    @Override
    public List<Classroom> findAll() {
        return this.classroomRepository.findAllList();
    }

    //TaiNP && QuanTA
    //search method search Classroom exists
    @Override
    public List<Classroom> findAllClassroomExist() {
        return this.classroomRepository.findAllList();
    }


    //DanhNT coding 2:00PM - 23-10-2021
    @Override
    public Classroom getById(Integer id) {
        return this.classroomRepository.findById(id).orElse(null);
    }


    //DanhNT coding 2:00PM - 23-10-2021
    @Override
    public void updateSchoolYear(String schoolYear, Integer teacherId, Integer classId) {
        this.classroomRepository.updateSchoolYear(schoolYear, teacherId, classId);
    }

    //DanhNT coding 2:00PM - 23-10-2021
    @Override
    public Page<Classroom> findAllPage(Pageable pageable) {
        return this.classroomRepository.findAllPage(pageable);
    }

    //creator: HaNTT, date: 23/10/2021  (check class Duplicate)
    @Override
    public Classroom findClassByNameAndSchoolYear(String firstName, String secondName, String schoolYear) {
        return this.classroomRepository.findClassByNameAndSchoolYear(firstName, secondName, schoolYear);
    }

    //Danh coding 10:PM - 25-10-2021
    @Override
    public void updateClassNameAfterPromote(String newName,Integer gradeId, Integer classId) {
        this.classroomRepository.updateClassNameAfterPromote(newName,gradeId, classId);
    }

    //creator: HaNTT, date: 23/10/2021  (tạo mới)
    @Override
    public Integer saveClassRoom(String name, String schoolYear, Integer gradeId,Integer teacherId, boolean deleteFlag) {
        return classroomRepository.saveClassRoom(name, schoolYear, gradeId,teacherId, deleteFlag);
    }

}
