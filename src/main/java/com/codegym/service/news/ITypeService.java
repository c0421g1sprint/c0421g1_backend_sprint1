package com.codegym.service.news;


import com.codegym.entity.about_news.Type;

import java.util.List;

public interface ITypeService {
    List<Type> findAll();
}
