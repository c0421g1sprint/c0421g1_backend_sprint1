package com.codegym.DTO;

import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_teacher.Degree;
import com.codegym.entity.about_teacher.Division;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {


    private Integer teacherId;

    private String teacherName;
    private Byte teacherGender;
//    @NotEmpty(message = "Ngày sinh không được để trống")
//    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Phải đúng định dạng dd/mm/yyyy")
    private String teacherDateOfBirth;
//    @NotEmpty(message = "Trường đại học không được để trống")
    private String teacherUniversity;
//    @NotEmpty(message = "Địa chỉ không được để trống")
    private String teacherAddress;
//    @NotEmpty(message = "Email không được để trống")
//    @Email(message = "Phải đúng định dạng abc@gmail.com")
    private String teacherEmail;
//    @NotEmpty(message = "Số điện thoại không được để trống")
    private String teacherPhone;
//    @NotEmpty(message = "Ảnh không được để trống")
    private String teacherImage;
    private Degree degree;

    private Division division;

    private Account account;
    
    private Classroom classroom;

    private boolean deleteFlag;
}
