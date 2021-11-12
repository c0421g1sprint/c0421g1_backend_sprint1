package com.codegym.rest_controller;

import com.codegym.dto.MarkDto;
import com.codegym.entity.about_student.Mark;
import com.codegym.service.IMarkService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/marks")
public class MarkController {
    @Autowired
    private IMarkService iMarkService;
    //    MinhNN 27/10

    //    MinhNN 27/10
    @GetMapping("/{id}")
    public ResponseEntity<Mark> findById(@PathVariable("id") Integer id) {
        Mark mark = this.iMarkService.getById(id);
        if (mark != null) {
            return new ResponseEntity<>(mark, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    MinhNN 27/10
    @PatchMapping("/edit")
    public ResponseEntity<Mark> updateMark(@RequestBody MarkDto markDto) {
        Mark mark = new Mark();
        BeanUtils.copyProperties(markDto, mark);
        this.iMarkService.save(mark);
        return new ResponseEntity<>(mark,HttpStatus.OK);
    }

    //    MinhNN 27/10
    @GetMapping("/search")
    public ResponseEntity<Page<Mark>> searchNameStudent(@PageableDefault(size = 10) Pageable pageable, @RequestParam(required = false) String nameStudent, @RequestParam(required = false) Integer subjectId, @RequestParam(required = false) Integer classId) {
        Page<Mark> marks = this.iMarkService.search(pageable, nameStudent, subjectId, classId);
        return new ResponseEntity<>(marks, HttpStatus.OK);
    }
}