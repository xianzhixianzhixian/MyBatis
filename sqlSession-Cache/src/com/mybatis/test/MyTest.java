/**
 * 作者：樊钰丰
 * 时间：2017.9.2
 * 功能：mybatis查询缓存,一级缓存
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
	
	/**
	 * 缓存的底层实现是一个Map,Map的value是查询结果
	 * Map的key(查询依据),使用的ORM不同,查询依据是不同的
	 * 
	 * MyBatis的查询依据是：SQL的id + SQL语句
	 * Hibernate的查询依据是：查询结果的id
	 * 
	 * 增删改操作都会清空(刷新)一级缓存,无论是否提交
	 * 而且无法关闭对一级缓存的清空(刷新)
	 */
	@Test
	public void test(){
		
		//多条件查询
		Student student=dao.selectStudentById(3);
		Student student2=dao.selectStudentById2(3);
		
		//多条件查询
		Student newStudent=new Student("天才",15,100);
		dao.insertStudent(newStudent);
		
		System.out.println(student);
		System.out.println(student2);
	}
	
	@After
	public void after(){
		//增删改后一定记得提交
		sqlSession.commit();
		//一定要关闭sqlSession
		if(sqlSession!=null) sqlSession.close(); sqlSession=null;
	}
}
