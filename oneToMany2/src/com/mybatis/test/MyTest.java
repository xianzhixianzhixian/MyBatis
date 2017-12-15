/**
 * 作者：樊钰丰
 * 时间：2017.9.1
 * 功能：一对多关系查询(延迟加载查询)
 */

package com.mybatis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.beans.Country;
import com.mybatis.utils.MyBatisUtils;

public class MyTest {

	//改成mapper.xml文件中的namespace的名字(本例中是com.mybatis.dao.IStudentDao),形成mapper的动态代理
	private com.mybatis.dao.ICountryDao dao;
	private SqlSession sqlSession;

	@Before
	public void before(){
		
		sqlSession = MyBatisUtils.getSqlSession();
		dao=sqlSession.getMapper(com.mybatis.dao.ICountryDao.class);
	}
	
	@Test
	public void test(){
		
		//一对多查询
		Country country=dao.selectCountryById(1);
		System.out.println(country);
	}
	
	@After
	public void after(){
		//增删改后一定记得提交
		sqlSession.commit();
		//一定要关闭sqlSession
		if(sqlSession!=null) sqlSession.close(); sqlSession=null;
	}
}
