/**
 * 作者：樊钰丰
 * 时间：2017.8.29
 * 功能：测试类
 */

package com.mybatis.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.beans.Student;
import com.mybatis.dao.IStudentDao;
import com.mybatis.dao.StudentDaoImpl;

public class MyTest {

	private IStudentDao dao;

	@Before
	public void before(){
		
		dao = new StudentDaoImpl();
	}
	
	@Test
	public void test(){
		
		Student student=new Student("麻六",26,92.6);
		dao.insertStu(student);
	}
	
	@After
	public void after(){
		
	}
}
