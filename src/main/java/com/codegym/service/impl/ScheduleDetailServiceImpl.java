package com.codegym.service.impl;

import com.codegym.dto.IScheduleTeacher;
import com.codegym.repository.IScheduleDetailRepository;
import com.codegym.service.IScheduleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleDetailServiceImpl  implements IScheduleDetailService {

    @Autowired
    private IScheduleDetailRepository iScheduleDetailRepository;

    //Phuc
    @Override
    public List<IScheduleTeacher> getScheduleTeacher(Integer id) {
        return iScheduleDetailRepository.getScheduleTeacher(id);
    }

}
