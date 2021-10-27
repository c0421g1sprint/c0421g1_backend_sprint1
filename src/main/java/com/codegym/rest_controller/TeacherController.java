package com.codegym.rest_controller;

import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.IScheduleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/teachers")
public class TeacherController {

    @Qualifier("scheduleDetailServiceImpl")
    @Autowired
private IScheduleDetailService iScheduleDetailService;

//Phuc
    @GetMapping("/schedule/{id}")
    public ResponseEntity<List<ScheduleDetail>> showScheduleTeacher(@PathVariable Integer id) {
//        Teacher teacher = new Teacher();
//        List<ScheduleDetail> scheduleDetailList=iScheduleDetailService.getScheduleTeacher(teacher.getTeacherId());
        List<ScheduleDetail> scheduleDetailList=iScheduleDetailService.getScheduleTeacher(id);
        if(scheduleDetailList.isEmpty()) {
            System.out.println("233346365");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(scheduleDetailList,HttpStatus.OK);
        }
    }
}
