/**
 * 作者：樊钰丰
 * 时间：2017.8.31
 * 功能：mybatis增删改查操作
 */

package com.mybatis.test;

import java.util.List;
import java.util.Map;

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
		
		Student student=new Student("张三",26,92.6);
		student.setId(21);
		//dao.insertStudentCatchId(student);
		//dao.deleteStudentById(20);
		//dao.updateStudent(student);
		
		//List<Student> students=dao.selectAllStudents();
		List<Student> students=dao.selectStudentsByName("麻六");
		if(students!=null){
			//遍历所有的结果
			for(int i=0;i<students.size();i++){
				Student stu=students.get(i);
				System.out.println(stu.getId()+" "+stu.getName());
			}
		}
		
//		Map<String,Object> map=dao.selectAllStudentsMap();
//		System.out.println(map.get(21));
		
//		Student stu=dao.selectStudentById(21);
//		System.out.println(stu);
	}
	
	@After
	public void after(){
		
	}
}
