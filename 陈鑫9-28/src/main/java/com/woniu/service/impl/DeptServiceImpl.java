package com.woniu.service.impl;

import java.util.List;

import com.woniu.dao.DeptHome;
import com.woniu.pojo.Dept;
import com.woniu.service.IDeptService;

public class DeptServiceImpl implements IDeptService{
DeptHome dd=new DeptHome();
	@Override
	public void add(Dept d) {
		// TODO Auto-generated method stub
		dd.persist(d);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dd.delete(id);
	}

	@Override
	public void update(Dept d) {
		// TODO Auto-generated method stub
		dd.attachDirty(d);
	}

	@Override
	public Dept findOne(Integer id) {
		// TODO Auto-generated method stub
		Dept d=dd.findById(id);
		return d;
	}

	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		List<Dept>depts=dd.findByExample(new Dept());
		return depts;
	}

}
