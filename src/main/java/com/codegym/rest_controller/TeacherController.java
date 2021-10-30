package com.codegym.rest_controller;


import com.codegym.entity.about_teacher.Division;


import com.codegym.dto.TeacherDto;
import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.ITeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    // diep search teacher 25/10
    @GetMapping("/search")
    public ResponseEntity<Page<Teacher>> getSearchTeacher(@PageableDefault(value = 5) Pageable pageable,
                                                          @RequestParam(required = false) String search) {

        Page<Teacher> teachers = teacherService.searchTeacher(pageable, search);

        if (teachers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }




    //chuc nang hien thi danh sach giao vien - LinhDN
    @GetMapping("/list")
    public ResponseEntity<Page<Teacher>> getTeacherList
    (@PageableDefault(value = 2, sort = "teacher_id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Teacher> teacherList = teacherService.findAllTeacherByQuery(pageable);
        if (teacherList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(teacherList, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findTeacherById(@PathVariable int id) {
        Teacher teacher = teacherService.findTeacherByIdByQuery(id);
        if (teacher != null) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    //chuc nang xoa 1 giao vien (thuc chat la update teacher_deleteFlag = 1) - LinhDN
    @PatchMapping("delete/{id}")
    public void deleteTeacherById(@PathVariable int id) {
        teacherService.delete(id);
    }

    //chuc nang tim kiem theo ten  - LinhDN
    @GetMapping("/list/search")
    public ResponseEntity<Page<Teacher>> getTeacherListWithKeyWord
    (@PageableDefault(value = 2, sort = "teacher_id", direction = Sort.Direction.ASC) Pageable
             pageable, @RequestParam("name") String name) {
        Page<Teacher> teacherList = teacherService.findAllTeacherByQueryWithName(pageable, name);
        if (teacherList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(teacherList, HttpStatus.OK);
        }
    }

    //chuc nang tim kiem theo phong ban  - LinhDN
    @GetMapping("/list/division/{id}")
    public ResponseEntity<Page<Teacher>> getTeacherListByDivision
    (@PageableDefault(value = 2, sort = "teacher_id", direction = Sort.Direction.ASC) Pageable
             pageable, @PathVariable Integer id) {
        Page<Teacher> teacherList = teacherService.findAllTeacherByQueryWithDivision(pageable, id);
        if (teacherList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(teacherList, HttpStatus.OK);
        }
    }

    // chức năng thêm mới - BaoHG
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Teacher> saveTeacher(@RequestBody @Validated TeacherDto teacherDto, BindingResult
            bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacherDto, teacher);
            this.teacherService.save(teacher);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }


    //    MinhNN 24/10 update infor teacherg
    @PatchMapping("/updateInFor")
    public ResponseEntity<?> updateInforTeacher(@RequestBody @Validated TeacherDto teacherDto, BindingResult
            bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacherDto, teacher);
            this.teacherService.updateInFor(teacher);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // chức năng  cập nhập  - BaoHG
    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateTeacher(@RequestBody @Validated TeacherDto teacherDto, BindingResult
            bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacherDto, teacher);
            this.teacherService.update(teacher);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    @GetMapping("/listDivision/")
    public ResponseEntity<List<Division>> getDivisionList
            () {
        List<Division> divisionList = teacherService.findAllDivisionByQuery();
        if (divisionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(divisionList, HttpStatus.OK);
        }
    }
}
