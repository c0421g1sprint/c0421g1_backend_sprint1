package com.codegym.repository.news;

import com.codegym.entity.about_news.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ITypeRepository extends JpaRepository<Type, Integer> {


    // Find all
    @Query(value = "select * from type", nativeQuery = true)
    List<Type> getAllType();
}
