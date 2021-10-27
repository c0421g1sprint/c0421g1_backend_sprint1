package com.codegym.entity.about_classroom;
import com.codegym.entity.about_schedule.Schedule;
import com.codegym.entity.about_student.Student;
import com.codegym.entity.about_teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classroomId;
    private String classroomName;
    private String classroomSchoolYear;

    @ManyToOne(targetEntity = Grade.class)
    @JoinColumn(name = "grade_id", referencedColumnName = "gradeId")
    private Grade grade;

    private boolean deleteFlag;


    @JsonBackReference(value = "teacher_classroom")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;

    @JsonBackReference(value = "student_classroom")
    @OneToMany(mappedBy = "classroom")
    private Set<Student> students;

    @JsonBackReference(value = "schedule_classroom")
    @OneToOne(mappedBy = "classroom")
    private Schedule schedule;
}
