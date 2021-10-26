package com.codegym.service;

import com.codegym.entity.about_schedule.ScheduleDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IScheduleDetailService {

    List<ScheduleDetail> getScheduleTeacher(Integer id);
}
