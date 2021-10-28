package com.codegym.service;

import com.codegym.entity.about_classroom.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClassroomService {

    //DanhNT coding 3:00PM 23-10-21
    Classroom getById(Integer id);

    //Trùng code với chị Hà
    //DanhNT coding 3:00PM 23-10-21
    void updateSchoolYear(String schoolYear, Integer teacherId, Integer classId);

    //DanhNT coding 3:00PM 23-10-21
    Page<Classroom> findAllPage(Pageable pageable);

    //creator: HaNTT, date: 23/10/2021  (check class Duplicate)
    Classroom findClassByNameAndSchoolYear(String firstName,String secondName, String schoolYear);

    //DanhNT coding 9:00 25-10-21
    void updateClassNameAfterPromote(String newName, Integer classId);

    //creator: HaNTT, date: 23/10/2021  (tạo mới)
    Integer saveClassRoom(String name, String schoolYear,Integer teacherId);
}
