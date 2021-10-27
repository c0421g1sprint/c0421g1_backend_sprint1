package com.codegym.rest_controller;

import com.codegym.dto.ClassroomDto;
import com.codegym.dto.StudentDto;
import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_student.Mark;
import com.codegym.entity.about_student.Student;
import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.IClassroomService;
import com.codegym.service.IStudentService;
import com.codegym.service.ITeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/classroom")
public class ClassroomController {

    //DanhNT & HaNTT coding controller
    @Autowired
    private IClassroomService classroomService;

    //DanhNT & HaNTT coding controller
    @Autowired
    private IStudentService studentService;

    //DanhNT & HaNTT coding controller
    @Autowired
    private ITeacherService teacherService;

    //DanhNT coding controller show list
    // check ok 9:00 AM
    @GetMapping
    public ResponseEntity<?> showList(@PageableDefault(size = 5) Pageable pageable) {
        Page<Classroom> classroomList = this.classroomService.findAllPage(pageable);
        if (classroomList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classroomList, HttpStatus.OK);
    }

    //DanhNT coding controller find by id
    // check ok 9:00 AM
    @GetMapping("/get/{id}")
    public ResponseEntity<Classroom> findById(@PathVariable Integer id) {
        Classroom classroom = this.classroomService.getById(id);
        if (classroom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    //DanhNT - coding controller for edit class information
    // check ok
    @PutMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateClass(@RequestBody Classroom classroom) {

        this.classroomService.updateSchoolYear(classroom.getClassroomSchoolYear(),
                classroom.getTeacher().getTeacherId(),
                classroom.getClassroomId());


        return new ResponseEntity<>(HttpStatus.OK);
    }

    //DanhNT - coding controller for promote
    @PutMapping(value = "/promote")
    public ResponseEntity<?> promoteClass(@RequestBody Classroom classroom) {

        Classroom newClassroom = this.classroomService.getById(classroom.getClassroomId());
        if (newClassroom != null) {
            String currentName = newClassroom.getClassroomName();
            String[] promoteName = newClassroom.getClassroomName().split("");
            String[] demoteName = newClassroom.getClassroomName().split("");
            if (promoteName[0].equals("5")) {
                newClassroom.setDeleteFlag(true);
            } else {
                promoteName[0] = String.valueOf(Integer.parseInt(promoteName[0]) + 1);
                String rejoinName = String.join("", promoteName);
                newClassroom.setClassroomName(rejoinName);
            }
            Set<Student> studentSet = newClassroom.getStudents();
            for (Student student : studentSet) {
                Set<Mark> mark = student.getMarks();
                List<Double> avgList = new ArrayList<>();
                // average mark
                for (Mark m : mark) {
                    avgList.add((m.getMarkPointNumber1() + m.getMarkPointNumber2() * 2 + m.getMarkPointNumber3() * 3) / 6);
                }
                Double avgMark = avgArray(avgList);
                // demote student
                if (avgMark < 3.5 && !student.getStudentStatus().equals(student.getClassroom().getClassroomName())) {
                    student.setStudentStatus(student.getClassroom().getClassroomName());
                    if (student.getClassroom().getGrade().getGradeId() == 1) {
                        student.setClassroom(null);
                    }
                    demoteName[0] = String.valueOf(Integer.parseInt(demoteName[0]) - 1);
                    String rejoinName = String.join("", demoteName);
                    String year = String.valueOf(Integer.parseInt(newClassroom.getClassroomSchoolYear()) + 1);
                    Classroom promoteClass = this.classroomService.findClassByNameAndSchoolYear(currentName, rejoinName, year);
                    student.setClassroom(promoteClass);
                    // rejoin student to database
                    this.studentService.updateClassForStudent(student.getClassroom().getClassroomId(), student.getStudentId());
                }
            }
            this.classroomService.updateClassNameAfterPromote(newClassroom.getClassroomName(), newClassroom.getClassroomId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    //DanhNT - coding
    public Double avgArray(List<Double> arrayList) {
        double sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i);
        }
        return sum / arrayList.size();
    }

    //create: HaNTT, date: 22/10/2021
    //check ok
    @GetMapping("/find-class-room")  //OK (check Class duplicate)
    public ResponseEntity<Classroom> isClassDuplicated(@RequestParam(name = "name", required = false) String name,
                                                       @RequestParam(name = "schoolYear", required = false) String schoolYear) {
        Classroom classroom = this.classroomService.findClassByNameAndSchoolYear(name, name, schoolYear);

        if (classroom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }


    //create: HaNTT, date: 23/10/2021
    //check ok
    @PostMapping("/create") //OK
    public ResponseEntity<Integer> create(@RequestBody ClassroomDto classroomDto) {
        //get field:
        String name = classroomDto.getClassroomName();
        String schoolYear = classroomDto.getClassroomSchoolYear();
        Integer teacherId = classroomDto.getTeacher().getTeacherId();
        Set<StudentDto> studentDtoSet = classroomDto.getStudents();
        // angurlar-service: làm sao để add studentSet vào class? -->TS: classroom =  getFormValue --> classroom.setStudents = hashset<Student>?
        //Chuyển StudentDto-> Student
        Set<Student> studentSet = new HashSet<>();
        for (StudentDto item : studentDtoSet) {
            Student student = new Student();
            BeanUtils.copyProperties(item, student);
            studentSet.add(student);
        }
        //lưu class trước (return Integer/void)
        Integer newClassroomStatus = this.classroomService.saveClassRoom(name, schoolYear, 1, teacherId, false);
        //lấy lại classId:
        Integer classroomId = this.classroomService.findClassByNameAndSchoolYear(name, name, schoolYear).getClassroomId();
        System.err.println("classId khi lưu class: " + classroomId);
        //set class cho List student đã chọn
        for (Student student : studentSet) {
            this.studentService.updateClassForStudent(classroomId, student.getStudentId());
        }
        return new ResponseEntity<>(newClassroomStatus, HttpStatus.OK);
    }

    //DanhNT
    @PatchMapping("/delete")
    public ResponseEntity<?> deleteStudentFromClass(@RequestBody StudentDto studentDto) {
        if (studentDto != null) {
            this.studentService.deleteStudentFromClass(studentDto.getStudentId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //DanhNT
    @PatchMapping("/updateClassForStudent")
    public ResponseEntity<?> updateClassForStudent(@RequestBody List<StudentDto> studentList, @RequestBody Integer id) {
        if (studentList != null) {
            for (StudentDto student : studentList) {
                this.studentService.updateClassForStudent(id, student.getStudentId());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
