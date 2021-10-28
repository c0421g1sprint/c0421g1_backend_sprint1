package com.codegym.repository;

import com.codegym.entity.about_teacher.Degree;
import com.codegym.entity.about_teacher.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDegreeRepository extends JpaRepository<Degree,Integer> {

    @Query(value = "SELECT degree_id, degree_name FROM degree",nativeQuery = true)
    List<Degree> findAllDegreeByQuery();
}
