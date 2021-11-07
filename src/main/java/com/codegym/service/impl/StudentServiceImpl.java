package com.codegym.service.impl;

import com.codegym.dto.StudentListFromTeacher;
import com.codegym.entity.about_student.Student;
import com.codegym.repository.IStudentRepository;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    //Phuc

    //Phuc sửa lại
    @Override
    public Page<StudentListFromTeacher> getListStudent(Pageable pageable, Integer id) {
        return studentRepository.getListStudent(pageable, id);
    }

    //Phuc
    @Override
    public Student getListStudentDetail(Integer id) {
        return studentRepository.getStudentById(id);
    }

    //Trùng code với chị Hà
    //Danh coding 2:00PM - 23-10-2021
    @Override
    public void updateClassForStudent(Integer classId,String status, Integer studentId) {
        this.studentRepository.updateClassForStudent(classId, status, studentId);
    }

    //creator: HaNTT, date: 23/10/2021
    @Override
    public Page<Student> findByClassroom(int classroomId, Pageable pageable) {
        return studentRepository.findByClassroomId(classroomId, pageable);
    }

    //creator: HaNTT, date: 23/10/2021
    @Override
    public List<Student> findWhereClassroomIdNull() {
        return studentRepository.findWhereClassroomIdNull();
    }

    //creator: HaNTT, date: 23/10/2021
    @Override
    public Student findStudentById(Integer id) {
        return studentRepository.getStudentById(id);
    }

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
        } else return null;
    }

    //DungNM - Tìm danh sách học sinh theo ID của classroom
    @Override
    public Page<Student> findStudentsByClassroomId(int classroomId, Pageable pageable) {
        return studentRepository.findStudentsByClassroomId(classroomId, pageable);
    }

    //LamNT saveStudent function
    @Override
    public void saveStudent(Student student) {
        studentRepository.saveStudent(student.isDeleteFlag(), student.getStudentAddress(), student.getStudentDateOfBirth(),
                student.getStudentEthnicity(), student.getStudentFatherName(), String.valueOf(student.getStudentGender()), student.getStudentMotherName(),
                student.getStudentName(), student.getStudentParentPhone(), student.getStudentReligion(), student.getStudentImage());
    }


    //LamNT editStudent function
    @Override
    public void editStudent(Student student) {
        studentRepository.editStudent(student.getStudentAddress(), student.getStudentDateOfBirth(), student.getStudentEthnicity(),
                student.getStudentFatherName(), String.valueOf(student.getStudentGender()), student.getStudentMotherName(), student.getStudentName(),
                student.getStudentParentPhone(), student.getStudentReligion(), student.getStudentImage(), student.getStudentId());
    }

    // Diep search student 25/10
    @Override
    public Page<Student> searchStudent(Pageable pageable, String inforStudent) {
        return this.studentRepository.searchStudent(pageable, "%" + inforStudent + "%");
    }

    //    search Student by Nhật
    public Page<Student> findSearch(Pageable pageable, String name, String status) {
        return studentRepository.findSearch(pageable, "%" + name + "%", "%" + status + "%");
    }

    @Override
    public void deleteStudentFromClass(Integer id) {
        this.studentRepository.deleteStudentFromClass(id);
    }

    @Override
    public List<Student> findListStudentByClassroomId(Integer id) {
        return this.studentRepository.findListStudentByClassroomId(id);
    }

    @Override
    public int findNewIdStudent() {
        return this.studentRepository.findNewIdStudent();
    }
}
