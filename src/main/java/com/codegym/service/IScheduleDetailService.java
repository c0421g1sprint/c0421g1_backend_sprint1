package com.codegym.service;

import com.codegym.dto.IScheduleTeacher;
import java.util.List;

public interface IScheduleDetailService {

    //Phuc
    List<IScheduleTeacher> getScheduleTeacher(Integer id);
}
