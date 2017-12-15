/**
 * 作者：樊钰丰
 * 时间：2017.9.1
 * 功能：多对一关系查询,查询指定栏目及所有父栏目
 */

package com.mybatis.test;

import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.beans.NewsLabel;
import com.mybatis.utils.MyBatisUtils;

public class MyTest {

	//改成mapper.xml文件中的namespace的名字(本例中是com.mybatis.dao.IStudentDao),形成mapper的动态代理
	private com.mybatis.dao.INewsLabelDao dao;
	private SqlSession sqlSession;

	@Before
	public void before(){
		
		sqlSession = MyBatisUtils.getSqlSession();
		dao=sqlSession.getMapper(com.mybatis.dao.INewsLabelDao.class);
	}
	
	@Test
	public void test(){
		
		//一对多自关联查询
		NewsLabel newsLabel=dao.selectNewsLabelById(3);
		System.out.println(newsLabel);
	}
	
	@After
	public void after(){
		//增删改后一定记得提交
		sqlSession.commit();
		//一定要关闭sqlSession
		if(sqlSession!=null) sqlSession.close(); sqlSession=null;
	}
}
