/**
 * 作者：樊钰丰
 * 时间：2017.8.31
 * 功能：mybatis的动态SQL(if,where,choose标签的使用)
 */

package com.mybatis.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.beans.Student;
import com.mybatis.dao.IStudentDao;
import com.mybatis.utils.MyBatisUtils;

public class MyTest {

	//改成mapper.xml文件中的namespace的名字(本例中是com.mybatis.dao.IStudentDao),形成mapper的动态代理
	private com.mybatis.dao.IStudentDao dao;
	private SqlSession sqlSession;

	@Before
	public void before(){
		
		sqlSession = MyBatisUtils.getSqlSession();
		dao=sqlSession.getMapper(com.mybatis.dao.IStudentDao.class);
	}
	
	@Test
	public void test(){
		
//		Student stu=new Student("张",23,0);
//		Student stu=new Student("",0,0);
		//多条件查询
//		List<Student> students=dao.selectStudentsByIf(stu);
//		List<Student> students=dao.selectStudentsByWhere(stu);
		
		
		
//		int[] ids={1,2,3};
//		List<Student> students=dao.selectStudentsByForeachArray(ids);
		
		
		
//		List<Integer> ids=new ArrayList<Integer>();
//		ids.add(1);
//		ids.add(2);
//		ids.add(3);
//		List<Student> students=dao.selectStudentsByForeachList(ids);
		
		Student stu1=new Student();
		stu1.setId(1);
		Student stu2=new Student();
		stu2.setId(2);
		Student stu3=new Student();
		stu3.setId(3);
		List<Student> stuList=new ArrayList<Student>();
		stuList.add(stu1);
		stuList.add(stu2);
		stuList.add(stu3);
//		List<Student> students=dao.selectStudentsByForeachStudentList(stuList);
		
		
		List<Student> students=dao.selectStudentsBySQLFragment(stuList);
		
		for(Student student : students){
			System.out.println(student);
		}
	}
	
	@After
	public void after(){
		//增删改后一定记得提交
		sqlSession.commit();
		//一定要关闭sqlSession
		if(sqlSession!=null) sqlSession.close(); sqlSession=null;
	}
}
