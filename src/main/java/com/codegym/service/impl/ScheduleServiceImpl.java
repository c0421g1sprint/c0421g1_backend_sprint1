package com.codegym.service.impl;

import com.codegym.repository.IScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl {
    @Autowired
    private IScheduleRepository scheduleRepository;
}
