package com.codegym.repository;

import com.codegym.entity.about_teacher.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDivisionRepository extends JpaRepository<Division, Integer> {
    //lay ra danh sach cac phong ban - LinhDN
    @Query(value = "SELECT division_id, division_name FROM division",nativeQuery = true)
    List<Division> findAllDivisionByQuery();
}
