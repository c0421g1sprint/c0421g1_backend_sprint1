package com.codegym.service;

import com.codegym.entity.about_classroom.Classroom;

public interface IClassroomService {
    //creator: HaNTT, date: 23/10/2021  (check class Duplicate)
    Classroom findClassByNameAndSchoolYear(String name, String schoolYear);

    //creator: HaNTT, date: 23/10/2021  (tạo mới)
    Integer saveClassRoom(String name, String schoolYear, Integer gradeId,Integer teacherId, boolean deleteFlag);

}
