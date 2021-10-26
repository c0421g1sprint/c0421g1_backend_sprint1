package com.codegym.rest_controller;

import com.codegym.DTO.ScheduleDetailDto;
import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_classroom.Grade;
import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.service.IClassroomService;
import com.codegym.service.IGradeService;
import com.codegym.service.IScheduleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/schedules")
public class ScheduleController {
    // QuanTA
    // Tiem Service
    @Autowired
    private IGradeService gradeService;

    @Autowired
    private IClassroomService classroomService;

    @Autowired
    private IScheduleService scheduleService;

    // // QuanTA 22/10 10h:46 pm api tra ve 1 list  grade
    @GetMapping(value = "/grades")
    public ResponseEntity<List<Grade>> showListGrade() {
        List<Grade> gradeList = this.gradeService.findAllGrade();
        if (gradeList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gradeList, HttpStatus.ACCEPTED);
    }

    //QuanTA 22/10 10h:46 api tra ve 1 list classroom dang ton tai
    @GetMapping(value = "/classroom-exist")
    public ResponseEntity<List<Classroom>> showListClassroomExist() {
        List<Classroom> classroomList = this.classroomService.findAllClassroomExist();
        if (classroomList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classroomList, HttpStatus.ACCEPTED);
    }

    //QuanTA 22/10 11h:27 api tra ve tkb cua 1 classroom
    @GetMapping(value = "/schedule-classroom/{id}")
    public ResponseEntity<List<ScheduleDetail>> scheduleDetailClassroom(@PathVariable(required = false) Integer id) {
        List<ScheduleDetail> scheduleDetailListOfClassroom = this.scheduleService.findScheduleDetailByClassroomId(id);
        if (scheduleDetailListOfClassroom.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(scheduleDetailListOfClassroom, HttpStatus.ACCEPTED);
    }

    //QuanTA 22/10 10h:46 api update schedule detail
    @PutMapping(value = "/schedule-update")
    public ResponseEntity<ScheduleDetail> updateScheduleDetail(
            @RequestBody @Valid ScheduleDetailDto scheduleDetailDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        ScheduleDetail scheduleDetail = new ScheduleDetail();
        BeanUtils.copyProperties(scheduleDetailDto, scheduleDetail);
        this.scheduleService.updateSchedule(scheduleDetail.getSubject().getSubjectId(),
                scheduleDetail.getScheduleDetailId());
        return new ResponseEntity<>(scheduleDetail, HttpStatus.ACCEPTED);
    }
}
