package com.codegym.service.impl;


import com.codegym.entity.about_schedule.Subject;
import com.codegym.repository.ISubjectRepository;
import com.codegym.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements ISubjectService {
    @Autowired
    ISubjectRepository subjectRepository;
    @Override
    public List<Subject> findAllSubject() {
        return subjectRepository.findAllSubject();
    }
}
