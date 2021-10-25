package com.codegym.rest_controller;

import com.codegym.dto.StudentDTO;
import com.codegym.entity.about_student.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    //DungNM - Lấy danh sách học sinh của 1 lớp
    @GetMapping("/{classroomId}")
    public ResponseEntity<Page<StudentDTO>> getStudentsOfClassroom(@PathVariable String classroomId,
                                                                   @PageableDefault(value = 10) Pageable pageable) {
        try {
            int classId = Integer.parseInt(classroomId);
            Page<Student> students = studentService.findByClassroom(classId, pageable);
            if (students.getContent().size() == 0) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Page<StudentDTO> studentDTOPage = students.map(new Function<Student, StudentDTO>() {
                @Override
                public StudentDTO apply(Student entity) {
                    StudentDTO dto = new StudentDTO();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                }
            });
            return new ResponseEntity<>(studentDTOPage, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //DungNM - Xoá học sinh theo Id của học sinh
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDTO> deleteStudentById(@PathVariable String id) {
        try {
            int studentId = Integer.parseInt(id);
            Student studentDelete = studentService.deleteById(studentId);
            if (studentDelete == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else {
                StudentDTO studentDTO = new StudentDTO();
                BeanUtils.copyProperties(studentDelete,studentDTO);
                return new ResponseEntity<>(studentDTO, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
