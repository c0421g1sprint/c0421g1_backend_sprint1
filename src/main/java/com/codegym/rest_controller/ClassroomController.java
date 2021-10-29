package com.codegym.rest_controller;

import com.codegym.dto.ClassroomDto;
import com.codegym.dto.StudentDto;
import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_student.Mark;
import com.codegym.entity.about_student.Student;
import com.codegym.service.IClassroomService;
import com.codegym.service.IGradeService;
import com.codegym.service.IStudentService;
import com.codegym.service.ITeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    //DanhNT
    @Autowired
    private IGradeService gradeService;

    //DanhNT coding controller show list
    //check ok 9:00 AM
    //check ok : 27/10 - 9:55
    @GetMapping
    public ResponseEntity<?> showList(@PageableDefault(size = 5) Pageable pageable) {
        Page<Classroom> classroomList = this.classroomService.findAllPage(pageable);
        if (classroomList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classroomList, HttpStatus.OK);
    }

    //DanhNT coding controller find by id
    //check ok 9:00 AM - ok
    //check ok : 27/10 - 9:55
    @GetMapping("/get-classroom/{id}")
    public ResponseEntity<Classroom> findById(@PathVariable int id) {
        Classroom classroom = this.classroomService.getById(id);
        if (classroom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    //DanhNT
    @GetMapping("/get-student-classroom/{id}")
    public ResponseEntity<?> findAllByClassroomId(@PathVariable int id) {
        List<Student> studentList = this.classroomService.findAllByClassroomId(id);
        if (studentList != null) {
            return new ResponseEntity<>(studentList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //DanhNT - coding controller for edit class information
    //check ok
    //check ok : 27/10 - 9:55
    @PatchMapping("/edit")
    public ResponseEntity<?> updateClass(@RequestBody ClassroomDto classroomDto) {
        Classroom classroom = new Classroom();
        BeanUtils.copyProperties(classroomDto, classroom);
        if (classroomDto.getTeacher() != null) {
            this.classroomService.updateSchoolYear(classroomDto.getClassroomSchoolYear(),
                    classroomDto.getTeacher().getTeacherId(),
                    classroomDto.getClassroomId());
        }
        Set<Student> studentList = classroomDto.getStudents();
        if (studentList != null) {
            for (Student student : studentList) {
                this.studentService.updateClassForStudent(classroomDto.getClassroomId(), student.getStudentId());
            }
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //DanhNT - coding controller for promote
    //check ok : 27/10 - 9:55
    @PutMapping(value = "/promote")
    public ResponseEntity<?> promoteClass(@RequestBody ClassroomDto classroomDto) {
        Classroom newClassroom = null;
        newClassroom = this.classroomService.getById(classroomDto.getClassroomId());
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
                int number = classroomDto.getGrade().getGradeId() + 1;
                classroomDto.setGrade(this.gradeService.findGradeById(number));
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
                if (avgMark < 3.5 ) {
                    student.setStudentStatus(student.getClassroom().getClassroomName());
                    if (student.getClassroom().getGrade().getGradeId() == 1) {
                        student.setClassroom(null);
                        student.setStudentStatus("Lưu ban");
                    } else {
                        demoteName[0] = String.valueOf(Integer.parseInt(demoteName[0]) - 1);
                        String rejoinName = String.join("", demoteName);
                        String year = String.valueOf(Integer.parseInt(newClassroom.getClassroomSchoolYear()) + 1);
                        Classroom promoteClass = this.classroomService.
                                findClassByNameAndSchoolYear(currentName, rejoinName, year);
                        student.setClassroom(promoteClass);
                        // rejoin student to database
                        this.studentService.
                                updateClassForStudent(student.getClassroom().getClassroomId(), student.getStudentId());
                    }
                }
            }
            if (newClassroom.getGrade().getGradeId() !=5 ){
                this.classroomService.
                        updateClassNameAfterPromote(newClassroom.getClassroomName(),
                                newClassroom.getGrade().getGradeId()+1,
                                newClassroom.getClassroomId());
            }

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
    //check ok -- OK
    //check ok : 27/10 - 9:55
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
    //check ok : 27/10 - 9:55
    @PostMapping("/create") //OK
    public ResponseEntity<Integer> create(@RequestBody ClassroomDto classroomDto) {
        //get field:
        String name = classroomDto.getClassroomName();
        String schoolYear = classroomDto.getClassroomSchoolYear();
        Integer teacherId = classroomDto.getTeacher().getTeacherId();
        Set<Student> studentDtoSet = classroomDto.getStudents();
        // angurlar-service: làm sao để add studentSet vào class? -->TS: classroom =  getFormValue --> classroom.setStudents = hashset<Student>?
        //Chuyển StudentDto-> Student
        if (studentDtoSet != null) {
            Set<Student> studentSet = new HashSet<>();
            for (Student item : studentDtoSet) {
                Student student = new Student();
                BeanUtils.copyProperties(item, student);
                studentSet.add(student);
            }
            //lưu class trước (return Integer/void)
            Integer newClassroomStatus = this.classroomService.saveClassRoom(name, schoolYear, teacherId);
            //lấy lại classId:
            Integer classroomId = this.classroomService.findClassByNameAndSchoolYear(name, name, schoolYear).getClassroomId();
            //set class cho List student đã chọn
            for (Student student : studentSet) {
                this.studentService.updateClassForStudent(classroomId, student.getStudentId());
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //DanhNT
    @PatchMapping("/delete")
    public ResponseEntity<Integer> removeStudentFromClass(@RequestBody List<StudentDto> studentDtoList) {
        if (studentDtoList != null) {
            for (StudentDto student : studentDtoList) {
                this.studentService.deleteStudentFromClass(student.getStudentId());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
