package com.codegym.service.impl;

import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.repository.IScheduleRepository;
import com.codegym.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements IScheduleService {
    @Autowired
    private IScheduleRepository scheduleRepository;

    @Override
    public ScheduleDetail save(ScheduleDetail scheduleDetail) {
        return null;
    }

    @Override
    public List<ScheduleDetail> findScheduleDetailByClassroomId(Integer classroomId) {
        return scheduleRepository.findScheduleDetailByClassroomId(classroomId);
    }

    @Override
    public void updateSchedule(int updateValue, int idScheduleDetail) {
        this.scheduleRepository.updateSchedule(updateValue,idScheduleDetail);
    }
}
