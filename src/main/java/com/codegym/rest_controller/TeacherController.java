package com.codegym.rest_controller;

import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.service.IScheduleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private IScheduleDetailService iScheduleDetailService;


    @GetMapping("/schedule/{id}")
    public ResponseEntity<List<ScheduleDetail>> showScheduleTeacher(@PathVariable Integer id) {
        List<ScheduleDetail> scheduleDetailList=iScheduleDetailService.getScheduleTeacher(id);
        if(scheduleDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(scheduleDetailList,HttpStatus.OK);
        }
    }
}
