package com.codegym.rest_controller;
import com.codegym.entity.about_schedule.Subject;
import com.codegym.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codegym.dto.ScheduleDetailDto;
import com.codegym.dto.ScheduleSubjectDto;
import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_classroom.Grade;
import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.service.IClassroomService;
import com.codegym.service.IGradeService;
import com.codegym.service.IScheduleService;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @Autowired
    private ISubjectService subjectService;

    // // QuanTA 22/10 10h:46 pm api tra ve 1 list  grade
    @GetMapping(value = "/grades")
    public ResponseEntity<List<Grade>> showListGrade() {
        List<Grade> gradeList = this.gradeService.findAllGrade();
        if (gradeList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(gradeList, HttpStatus.ACCEPTED);
    }

    //QuanTA 22/10 10h:46 api tra ve 1 list classroom dang ton tai
    @GetMapping(value = "/classroom-exist")
    public ResponseEntity<List<Classroom>> showListClassroomExist() {
        List<Classroom> classroomList = this.classroomService.findAllClassroomExist();
        if (classroomList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(classroomList, HttpStatus.ACCEPTED);
    }

    //QuanTA 22/10 11h:27 api tra ve tkb cua 1 classroom
    @GetMapping(value = "/schedule-classroom/{id}")
    public ResponseEntity<List<ScheduleDetail>> scheduleDetailClassroom(@PathVariable(required = false) Integer id) {
        List<ScheduleDetail> scheduleDetailListOfClassroom = this.scheduleService.findScheduleDetailByClassroomId(id);
        if (scheduleDetailListOfClassroom.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(scheduleDetailListOfClassroom, HttpStatus.ACCEPTED);
    }

    //QuanTA 22/10 10h:46 api update schedule detail
    @PutMapping(value = "/schedule-update")
    public ResponseEntity<Void> updateScheduleDetail(@RequestBody List<ScheduleSubjectDto> scheduleSubjectDtoList) {
        for (ScheduleSubjectDto n : scheduleSubjectDtoList){
            scheduleService.updateSchedule(n.getSubjectId(),n.getScheduleDetailId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // list subject QuanTA
    @GetMapping(value = "/subject")
    public ResponseEntity<List<Subject>> findAllSubject(){
        List<Subject> subjectList = this.subjectService.findAllSubject();
        if (subjectList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(subjectList, HttpStatus.ACCEPTED);
    }
}

