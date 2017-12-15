/**
 * 作者：樊钰丰
 * 时间：2017.9.4
 * 功能：mybatis注解式开发(主要用于替换映射文件mapper)
 */

package com.mybatis.test;

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
		
		Student student=new Student("张三",26,92.6);
		//student.setId(21);
		dao.insertStudentCatchId(student);

		//dao.deleteStudentById(20);
		//dao.updateStudent(student);
		
		List<Student> students=dao.selectAllStudents();
		//方法的名字要和mapper.xml中的接口的id名一样,才能够调用方法
		//List<Student> students=dao.selectStudentsByName("麻六");
		if(students!=null){
			//遍历所有的结果
			for(int i=0;i<students.size();i++){
				Student stu=students.get(i);
				System.out.println(stu.getId()+" "+stu.getName());
			}
		}
		
		Student stu=dao.selectStudentById(21);
		System.out.println(stu);
	}
	
	@After
	public void after(){
		//增删改后一定记得提交
		sqlSession.commit();
		//一定要关闭sqlSession
		if(sqlSession!=null) sqlSession.close(); sqlSession=null;
	}
}
