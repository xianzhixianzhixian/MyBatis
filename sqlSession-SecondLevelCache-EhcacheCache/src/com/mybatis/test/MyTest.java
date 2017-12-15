/**
 * 作者：樊钰丰
 * 时间：2017.9.4
 * 功能：mybatis结合EhcacheCache二级缓存
 */

package com.mybatis.test;

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
	 * 证明二级缓存是存在的
	 * 
	 * 开启内置的二级缓存步骤：
	 * 1、对实体进行序列化
	 * 2、在映射文件中添加<cache/>标签
	 * 
	 * 增删改会清空(刷新)内置二级缓存,无论是否提交
	 * 对于二级缓存的清空实质上是对key所对应的value置为null,
	 * 而非是将<key,value>(键-值)对,即Entry对象删除(key值依然存在,而value为null)
	 * 
	 * 从DB中进行select查询的条件是：
	 * 1、缓存中不存在这个key
	 * 2、缓存中存在该key所对应的Entry对象,但其值为null
	 */
	@Test
	public void test(){
		
		sqlSession = MyBatisUtils.getSqlSession();
		dao=sqlSession.getMapper(com.mybatis.dao.IStudentDao.class);
		Student student=dao.selectStudentById(3);
		System.out.println(student);
		
		sqlSession.close();
		
		sqlSession = MyBatisUtils.getSqlSession();
		dao=sqlSession.getMapper(com.mybatis.dao.IStudentDao.class);
		Student student2=dao.selectStudentById(3);
		System.out.println(student2);
		
		sqlSession.close();
		
		sqlSession = MyBatisUtils.getSqlSession();
		dao=sqlSession.getMapper(com.mybatis.dao.IStudentDao.class);
		Student student3=dao.selectStudentById(3);
		System.out.println(student3);
		
		sqlSession.close();
		
		sqlSession = MyBatisUtils.getSqlSession();
		dao=sqlSession.getMapper(com.mybatis.dao.IStudentDao.class);
		Student student4=dao.selectStudentById(3);
		System.out.println(student4);
		
		sqlSession.close();
		
		sqlSession = MyBatisUtils.getSqlSession();
		dao=sqlSession.getMapper(com.mybatis.dao.IStudentDao.class);
		Student student5=dao.selectStudentById(3);
		System.out.println(student5);
	}
	
	@After
	public void after(){
		//增删改后一定记得提交
		//sqlSession.commit();
		//一定要关闭sqlSession
		if(sqlSession!=null) sqlSession.close(); sqlSession=null;
	}
}
