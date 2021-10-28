package com.codegym.service.impl;

import com.codegym.dto.TeacherUpdateDto;
import com.codegym.entity.about_teacher.Degree;
import com.codegym.entity.about_teacher.Division;
import com.codegym.entity.about_teacher.Teacher;
import com.codegym.repository.IDegreeRepository;
import com.codegym.repository.IDivisionRepository;
import com.codegym.repository.ITeacherRepository;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired

    private ITeacherRepository teacherRepository;

    @Autowired
    private IDivisionRepository divisionRepository;

    @Autowired
    private IDegreeRepository iDegreeRepository;

    //DiepLV
    @Override
    public Page<Teacher> searchTeacher(Pageable pageable, String search) {
        return teacherRepository.searchTeacher(pageable, "%" + search + "%");
    }

    //BaoHG
    @Override
    public void update(Teacher teacher) {
        this.teacherRepository.updateTeacher(teacher.isDeleteFlag(), teacher.getTeacherAddress(), teacher.getTeacherDateOfBirth(), teacher.getTeacherEmail(), teacher.getTeacherGender(), teacher.getTeacherImage(), teacher.getTeacherName(), teacher.getTeacherPhone(), teacher.getTeacherUniversity(), teacher.getDivision().getDivisionId(), teacher.getDegree().getDegreeId(), teacher.getTeacherId());
    }

    //BaoHG
    @Override
    public void save(Teacher teacher) {
        this.teacherRepository.createNewTeacher(teacher.isDeleteFlag(), teacher.getTeacherAddress(), teacher.getTeacherDateOfBirth(), teacher.getTeacherEmail(), teacher.getTeacherGender(), teacher.getTeacherImage(), teacher.getTeacherName(), teacher.getTeacherPhone(), teacher.getTeacherUniversity(), teacher.getDivision().getDivisionId(), teacher.getDegree().getDegreeId());
    }


    //MinhNN 24/10 update infor teacher
    @Override
    public void updateInFor(TeacherUpdateDto teacher) {
        teacherRepository.editPersonInfor(teacher.getTeacherPhone(), teacher.getTeacherAddress(), teacher.getTeacherEmail(), teacher.getTeacherId());
    }

    //LinhDN
    @Override
    public List<Division> findAllDivisionByQuery() {
        return this.divisionRepository.findAllDivisionByQuery();
    }

    @Override
    public List<Degree> findAllDegreeByQuery() {
        return this.iDegreeRepository.findAllDegreeByQuery();
    }


    //LinhDN
    @Override
    public Page<Teacher> findAllTeacherByQueryWithNameAndDivision(Pageable pageable, String name, Integer id) {
        return this.teacherRepository.findAllTeacherByQueryWithKeywordAndDivision(pageable, name, id);
    }

    //LinhDN
    @Override
    public Page<Teacher> findAllTeacherByQuery(Pageable pageable) {
        return teacherRepository.findAllTeacherByQuery(pageable);
    }

    //LinhDN
    @Override
    public Teacher findTeacherByIdByQuery(int id) {
        Teacher teacher = teacherRepository.findByIdTeacherByQuery(id).orElse(null);
        if (teacher != null) {
            return teacher;
        }
        return null;
    }

    //LinhDN
    @Override
    public Page<Teacher> findAllTeacherByQueryWithName(Pageable pageable, String name) {
        return teacherRepository.findAllTeacherByQueryWithKeyword(pageable, name);
    }

    //LinhDN
    @Override
    public Page<Teacher> findAllTeacherByQueryWithDivision(Pageable pageable, int id) {
        return teacherRepository.findByIdTeacherByDivision(pageable, id);
    }

    //LinhDN
    @Override
    public void delete(Integer id) {
        Teacher teacher = teacherRepository.findByIdTeacherByQuery(id).orElse(null);
        if (teacher != null) {
            teacherRepository.saveDeleteTeacher(teacher.getTeacherId());
        }
    }

    //creator: HaNTT, date: 23/10/2021  (select-option)
    @Override
    public List<Teacher> findTeacherWhereTeacherIdNull() {
        return teacherRepository.findTeacherWhereTeacherIdNull();
    }

}
