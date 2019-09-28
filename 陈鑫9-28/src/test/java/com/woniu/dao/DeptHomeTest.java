package com.woniu.dao;

import java.util.List;

import com.woniu.pojo.Dept;

import junit.framework.TestCase;

public class DeptHomeTest extends TestCase {
DeptHome dh=new DeptHome();
	public void testPersist() {
		Dept dept=new Dept("xixi", "a");
		dh.persist(dept);
	}

	public void testAttachDirty() {
		Dept dept=new Dept(42,"xixi", "c");
		dh.attachDirty(dept);
	}

	public void testAttachClean() {
		
	}

	public void testDelete() {
		dh.delete(43);
	}

	public void testMerge() {
		
	}

	public void testFindById() {
		Dept dept=dh.findById(42);
		System.out.println(dept.toString());
	}

	public void testFindByExample() {
		List<Dept>depts=dh.findByExample(new Dept());
		for (Dept dept : depts) {
			System.out.println(dept.toString());
		}
	}

}
