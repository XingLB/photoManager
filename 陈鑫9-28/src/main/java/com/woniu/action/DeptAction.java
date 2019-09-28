package com.woniu.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.woniu.pojo.Dept;
import com.woniu.service.IDeptService;
import com.woniu.service.impl.DeptServiceImpl;

public class DeptAction extends ActionSupport{
IDeptService ds=new DeptServiceImpl();
	
Dept d;
List<Dept>depts;
public Dept getD() {
	return d;
}
public void setD(Dept d) {
	this.d = d;
}
public List<Dept> getDepts() {
	return depts;
}
public void setDepts(List<Dept> depts) {
	this.depts = depts;
}

public String save() {
	ds.add(d);
	return "list";
}
public String update() {
    Dept dept=new Dept(d.getDeptno(),d.getDname(),d.getLoc());
    ds.update(dept);
	return "list";
}
public String delete() {
	ds.delete(d.getDeptno());
	return "list";
}
public String findOne() {
	d=ds.findOne(d.getDeptno());
	return "updateForm";
}
public String list() {
	depts=ds.findAll();
	return "show";
}
}
