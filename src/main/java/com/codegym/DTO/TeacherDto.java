package com.codegym.DTO;

import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_teacher.Degree;
import com.codegym.entity.about_teacher.Division;

import javax.validation.constraints.*;


public class TeacherDto {
    private Integer teacherId;

    @NotEmpty(message = "Tên không được đê trống")
    @NotBlank
    @Size(max = 30, message = "Tên không được lớn hơn 30 kí tự")

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(max = 30, message = "Tên không được lớn hơn 30 kí tự")

    private String teacherName;
    private Byte teacherGender;
    @NotNull
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Ngày tháng năm sinh của bạn ko đúng định dạng dd/mm/yyyy")
    private String teacherDateOfBirth;
    @NotBlank(message = "Trường Đại học không được để trống")
    @NotEmpty
    @NotNull
    private String teacherUniversity;

    @NotNull
    @NotBlank(message = "Địa chỉ không được có khoảng trắng")
    @NotEmpty(message = "Địa chỉ không được trống")
    @Size(max = 30, message = "Địa chỉ không được lớn hơn 30 kí tự")
    @Size(min = 2, message = "Địa chỉ không được nhở  hơn 2 kí tự")
    private String teacherAddress;
    @NotNull
    @NotEmpty(message = "email không được rống")
    @Email(message = "email không đúng định dạng")
    @Size(max = 50, message = "Email không được lớn hơn 50 kí tự")
    @Size(min = 6, message = " Email không được nhở  hơn 6 kí tự")

    @NotNull
    private String teacherEmail;
    @NotEmpty(message = "số điện thoại không được để rỗng")
    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", message = "số điện thoại ko đúng định dạng")
    private String teacherPhone;
    @NotEmpty(message = "hình ảnh không được để trống")
    private String teacherImage;

    private Degree degree;
    private Division division;
    private Account account;
    private boolean deleteFlag;

    public TeacherDto() {
    }

    public TeacherDto(Integer teacherId, String teacherName, Byte teacherGender, String teacherDateOfBirth, String teacherUniversity, String teacherAddress, String teacherEmail, String teacherPhone, String teacherImage, Degree degree, Division division, Account account, boolean deleteFlag) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherGender = teacherGender;
        this.teacherDateOfBirth = teacherDateOfBirth;
        this.teacherUniversity = teacherUniversity;
        this.teacherAddress = teacherAddress;
        this.teacherEmail = teacherEmail;
        this.teacherPhone = teacherPhone;
        this.teacherImage = teacherImage;
        this.degree = degree;
        this.division = division;
        this.account = account;
        this.deleteFlag = deleteFlag;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Byte getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(Byte teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getTeacherDateOfBirth() {
        return teacherDateOfBirth;
    }

    public void setTeacherDateOfBirth(String teacherDateOfBirth) {
        this.teacherDateOfBirth = teacherDateOfBirth;
    }

    public String getTeacherUniversity() {
        return teacherUniversity;
    }

    public void setTeacherUniversity(String teacherUniversity) {
        this.teacherUniversity = teacherUniversity;
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

    public String getTeacherImage() {
        return teacherImage;
    }

    public void setTeacherImage(String teacherImage) {
        this.teacherImage = teacherImage;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}