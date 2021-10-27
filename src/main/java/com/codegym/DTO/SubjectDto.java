package com.codegym.dto;

import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.entity.about_student.Mark;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.OneToMany;
import java.util.Set;

public class SubjectDto {

    private Integer subjectId;
    private String subjectName;
    private Set<Mark> marks;
    private Set<ScheduleDetail> scheduleDetails;

    public SubjectDto() {
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public Set<ScheduleDetail> getScheduleDetails() {
        return scheduleDetails;
    }

    public void setScheduleDetails(Set<ScheduleDetail> scheduleDetails) {
        this.scheduleDetails = scheduleDetails;
    }
}
