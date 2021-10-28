package com.codegym.dto;

import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_teacher.Degree;
import com.codegym.entity.about_teacher.Division;

public class TeacherUpdateDto{
    private String teacherAddress;
    private String teacherEmail;
    private String teacherPhone;
    private Integer teacherId;


    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }
}
