package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
<<<<<<< HEAD
import javax.validation.constraints.Pattern;
=======
>>>>>>> 7ce70fb5ff4ffd14dd3bcfdbc4c85f229e0d62af
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classroomId;

<<<<<<< HEAD
    @Pattern(regexp = "^(1A)[1-5]$",
            message = "Vui lòng nhập tên lớp theo định dạng '1Ax' (x:0-5)")
    private String classroomName;
=======
    private String classroomName;

>>>>>>> 7ce70fb5ff4ffd14dd3bcfdbc4c85f229e0d62af
    private String classroomSchoolYear;

    private GradeDto grade;

    private boolean deleteFlag;

    private TeacherDto teacher;

    private Set<StudentDto> students;

    private ScheduleDto schedule;
}
