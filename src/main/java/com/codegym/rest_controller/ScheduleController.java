package com.codegym.rest_controller;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_classroom.Grade;
import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private IScheduleDetailService scheduleDetailService;

    @Autowired
    private IGradeService gradeService;


    @Autowired
    private IClassroomService classroomService;

    // TaiNP 24/10/2021 method return list grade
    @GetMapping(value = "/grades")
    public ResponseEntity<List<Grade>> showListGrade() {
        List<Grade> grades = this.gradeService.findAll();
        if (grades == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }

    // TaiNP 24/10/2021 method return list  class
    @GetMapping(value = "/classroom")
    public ResponseEntity<List<Classroom>> showListClass() {
        List<Classroom> classrooms = classroomService.findAll();
        if (classrooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }


    // TaiNP 24/10/2021 method return schedule of class_id
    @GetMapping("/schedule-detail/{classId}")
    public ResponseEntity<List<ScheduleDetail>> showScheduleTailByIdClass(@PathVariable Optional<Integer> classroomId) {
        if(classroomId == null){
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
        if(!classroomId.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<ScheduleDetail> scheduleDetailList = this.scheduleDetailService.findScheduleDetailByClassId(classroomId.get());
        if (scheduleDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(scheduleDetailList, HttpStatus.OK);
    }
}
