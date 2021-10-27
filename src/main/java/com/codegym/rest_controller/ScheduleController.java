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

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/schedules")
public class ScheduleController {
    @Autowired
    private ISubjectService subjectService;

    @GetMapping(value = "/subject")
    public ResponseEntity<List<Subject>> findAllSubject(){
        List<Subject> subjectList = this.subjectService.findAllSubject();
        if (subjectList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(subjectList, HttpStatus.ACCEPTED);
    }
}
