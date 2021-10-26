package com.codegym.service.impl;

import com.codegym.entity.about_student.Student;
import com.codegym.repository.IStudentRepository;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Student getById(int id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Student deleteById(int id) {
        Student student = getById(id);
        if (student != null) {
            studentRepository.deleteStudentById(id);
            return student;
        }else return null;
    }

    //DungNM - Tìm danh sách học sinh theo ID của classroom
    @Override
    public Page<Student> findByClassroom(int classroomId, Pageable pageable) {
        return studentRepository.findByClassroomId(classroomId, pageable);
    }

    // Diep search student 25/10
    @Override
    public Page<Student> searchstudent(Pageable pageable, String searchstudent) {
        return this.studentRepository.searchstudent(pageable, "%" + searchstudent + "%");
    }

    
    //LamNT saveStudent function
    @Override
    public void saveStudent(Student student) {
        studentRepository.saveStudent(student.isDeleteFlag(), student.getStudentAddress(), student.getStudentDateOfBirth(),
                student.getStudentEthnicity(), student.getStudentFatherName(), String.valueOf(student.getStudentGender()), student.getStudentMotherName(),
                student.getStudentName(), student.getStudentParentPhone(), student.getStudentReligion());
    }

    //LamNT editStudent function
    @Override
    public void editStudent(Student student) {
        studentRepository.editStudent(student.getStudentAddress(), student.getStudentDateOfBirth(), student.getStudentEthnicity(),
                student.getStudentFatherName(), String.valueOf(student.getStudentGender()), student.getStudentMotherName(), student.getStudentName(),
                student.getStudentParentPhone(), student.getStudentReligion(), student.getStudentId());
    }


}
