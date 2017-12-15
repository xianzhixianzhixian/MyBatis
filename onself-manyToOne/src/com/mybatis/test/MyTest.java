/**
 * 作者：樊钰丰
 * 时间：2017.9.1
 * 功能：多对一关系查询,查询指定栏目及所有父栏目
 * 中间表是多方，student表是一方,course表是一方
 * ！外键是定义在多方表中
 */

package com.mybatis.test;

import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.beans.Student;
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
		
		//多对多查询
		Student student=dao.selectStudentById(2);
		System.out.println(student);
	}
	
	@After
	public void after(){
		//增删改后一定记得提交
		sqlSession.commit();
		//一定要关闭sqlSession
		if(sqlSession!=null) sqlSession.close(); sqlSession=null;
	}
}
