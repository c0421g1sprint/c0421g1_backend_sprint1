package com.codegym.rest_controller;

import com.codegym.dto.ClassroomDto;
import com.codegym.dto.StudentDto;
import com.codegym.entity.about_classroom.Classroom;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/class-room")
public class ClassRoomController {
    @Autowired
    private IClassroomService iClassroomService;

    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ITeacherService iTeacherService;

    //create: HaNTT, date: 22/10/2021
    @GetMapping("/find-class-room")  //OK (check Class duplicate)
    public ResponseEntity<Classroom> isClassDuplicated(@RequestParam(name = "name", required = false) String name,
                                                       @RequestParam(name = "schoolYear",required = false) String schoolYear) {
        Classroom classroom = iClassroomService.findClassByNameAndSchoolYear(name, schoolYear);

        if (classroom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    //create: HaNTT, date: 23/10/2021
    @GetMapping("/find-student") //OK  (checkbox)
    public ResponseEntity<Page<Student>> getStudentNotHaveClass(@PageableDefault(size = 5) Pageable pageable) {
        Page<Student> studentList = iStudentService.findWhereClassroomIdNull(pageable);

        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    //create: HaNTT, date: 23/10/2021 (add student to List)
    @GetMapping("/find-student/{id}") //OK
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student student = iStudentService.findStudentById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    //create: HaNTT, date: 23/10/2021 (select-option)
    @GetMapping("/find-teacher") //OK
    public ResponseEntity<List<Teacher>> getListTeacherNotHaveChairedClass() {
        List<Teacher> teacherList = iTeacherService.findTeacherWhereTeacherIdNull();

        if (teacherList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacherList, HttpStatus.OK);
    }

    //create: HaNTT, date: 23/10/2021
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
            BeanUtils.copyProperties(item,student);
            studentSet.add(student);
        }
        //CHECK NULL :
        if(name == null || !name.equals("") || schoolYear == null || !schoolYear.equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //lưu class trước (return Integer/void)
        Integer newClassroomStatus = iClassroomService.saveClassRoom(name, schoolYear, 1, teacherId, false);
        //lấy lại classId:
        Integer classroomId = iClassroomService.findClassByNameAndSchoolYear(name, schoolYear).getClassroomId();
        System.err.println("classId khi lưu class: " + classroomId);
        //set class cho List student đã chọn
        for (Student student : studentSet) {
            iStudentService.setClassroomForNewStudent(classroomId, student.getStudentId());
        }
        return new ResponseEntity<>(newClassroomStatus, HttpStatus.OK);
    }
}
