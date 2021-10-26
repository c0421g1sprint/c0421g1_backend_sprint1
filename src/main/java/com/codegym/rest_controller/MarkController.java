package com.codegym.rest_controller;

import com.codegym.entity.about_student.Mark;
import com.codegym.service.IMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/marks")
public class MarkController {

    @Autowired
    private IMarkService iMarkService;

    @GetMapping("/list")
    public ResponseEntity<Page<Mark>> getAll(@PageableDefault(size = 5) Pageable pageable) {
        Page<Mark> markList = this.iMarkService.findAll(pageable);
        if (markList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(markList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        Mark mark = this.iMarkService.getById(id);
        if (mark != null) {
            return new ResponseEntity<>(mark, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateMark(@RequestBody Mark mark) {
        this.iMarkService.save(mark);
        return new ResponseEntity<>(mark,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchNameStudent(@PageableDefault(size = 5) Pageable pageable,@RequestParam String nameStudent, String subject) {
        Page<Mark> marks = this.iMarkService.search(pageable,nameStudent, subject);
        return new ResponseEntity<>(marks,HttpStatus.OK);
    }
}
