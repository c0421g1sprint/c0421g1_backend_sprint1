package com.codegym.service.impl;

import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.repository.IScheduleDetailRepository;
import com.codegym.service.IScheduleDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScheduleDetailServiceImpl  implements IScheduleDetailService {



    @Autowired
    private IScheduleDetailRepository iScheduleDetailRepository;

    //Phuc
    @Override
    public List<ScheduleDetail> getScheduleTeacher(Integer id) {
        return iScheduleDetailRepository.getScheduleTeacher(id);
    }
}
