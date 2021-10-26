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

    // TaiNP 26/10 method find schedule-detail by class id
    @Override
    public List<ScheduleDetail> findScheduleDetailByClassId(Integer classId) {
        return scheduleDetailRepository.findScheduleDetailByClassId(classId);
    }

}
