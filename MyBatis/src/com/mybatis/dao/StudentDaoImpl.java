/**
 * 作者：樊钰丰
 * 时间：2017.8.29
 * 功能：处理studentDao的类
 */

package com.mybatis.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.beans.Student;

public class StudentDaoImpl implements IStudentDao {

	private SqlSession sqlSession;

	@Override
	public void insertStu(Student student) {
		// TODO Auto-generated method stub
		try {
			
			//1、加载主配置文件
			InputStream inputStream=Resources.getResourceAsStream("mybatis.xml");
			//2、创建SqlSessionFactoryBuilder对象
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
			//3、创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
			//4、创建SqlSession对象
			sqlSession = sqlSessionFactory.openSession();
			//4、相关操作
			//第一个参数对应mapper.xml中的操作的id
			//第二个参数对应
			sqlSession.insert("insertStudent", student);
			//一定要提交事务
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
			//sqlSession关闭后会自动提交,自动关闭IO流,出错后会自动回滚
			if(sqlSession!=null) sqlSession.close();
		}
	}

}
