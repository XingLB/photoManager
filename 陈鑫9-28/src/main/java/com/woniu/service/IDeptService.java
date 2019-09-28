package com.woniu.service;

import java.util.List;

import com.woniu.pojo.Dept;

public interface IDeptService {
 void add(Dept d);
 void delete(Integer id);
 void update(Dept d);
 Dept findOne(Integer id);
 List<Dept> findAll();
}
