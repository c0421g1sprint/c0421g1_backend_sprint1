package com.codegym.service.impl;

import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.repository.IScheduleDetailRepository;
import com.codegym.service.IScheduleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ScheduleDetailServiceImpl implements IScheduleDetailService {


    @Autowired
    private IScheduleDetailRepository scheduleDetailRepository;

    @Override
    public List<ScheduleDetail> findScheduleDetailByClassId(Integer classroomId) {
        return scheduleDetailRepository.findScheduleDetailByClassroomId(classroomId);
    }

}
