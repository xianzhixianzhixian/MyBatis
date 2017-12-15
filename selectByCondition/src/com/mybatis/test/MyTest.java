/**
 * 作者：樊钰丰
 * 时间：2017.8.31
 * 功能：多条件查询,根据condiction查询
 */

package com.mybatis.test;

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
		
		//多条件查询
		List<Student> students=dao.selectStudentsByCondiction("张",23);
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
