/**
 * 作者：樊钰丰
 * 时间：2017.8.29
 * 功能：处理studentDao的类crud操作
 */

package com.mybatis.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.beans.Student;
import com.mybatis.utils.MyBatisUtils;

public class StudentDaoImpl implements IStudentDao {

	private SqlSession sqlSession;

	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			
			//1、加载主配置文件
			//InputStream inputStream=Resources.getResourceAsStream("mybatis.xml");
			//2、创建SqlSessionFactoryBuilder对象
			//SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
			//3、创建SqlSessionFactory对象
			//SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
			//4、创建SqlSession对象
			//sqlSession = sqlSessionFactory.openSession();
			sqlSession=MyBatisUtils.getSqlSession();
			//4、相关操作
			//第一个参数对应mapper.xml中的操作的id
			//第二个参数对应
			sqlSession.insert("insertStudent", student);
			//一定要提交事务,没提交则事务会被回滚
			sqlSession.commit();
		} finally{
			
			//sqlSession关闭后会自动提交,自动关闭IO流,出错后会自动回滚
			if(sqlSession!=null) sqlSession.close();
		}
	}

	@Override
	public void insertStudentCatchId(Student student) {
		// TODO Auto-generated method stub
		try {
			
			sqlSession=MyBatisUtils.getSqlSession();
			
			sqlSession.insert("insertStudentCatchId", student);
			//一定要提交事务,没提交则事务会被回滚
			sqlSession.commit();
		} finally{
			
			//sqlSession关闭后会自动提交,自动关闭IO流,出错后会自动回滚
			if(sqlSession!=null) sqlSession.close();
		}
	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		try {
			
			sqlSession=MyBatisUtils.getSqlSession();
			
			sqlSession.delete("deleteStudentById",id);
			//一定要提交事务,没提交则事务会被回滚
			sqlSession.commit();
		} finally{
			
			//sqlSession关闭后会自动提交,自动关闭IO流,出错后会自动回滚
			if(sqlSession!=null) sqlSession.close();
		}
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			
			sqlSession=MyBatisUtils.getSqlSession();
			
			sqlSession.update("updateStudent",student);
			//一定要提交事务,没提交则事务会被回滚
			sqlSession.commit();
		} finally{
			
			//sqlSession关闭后会自动提交,自动关闭IO流,出错后会自动回滚
			if(sqlSession!=null) sqlSession.close();
		}
	}

	@Override
	public List<Student> selectAllStudents() {
		// TODO Auto-generated method stub
		
		List<Student> students=null;
		try {
			
			sqlSession=MyBatisUtils.getSqlSession();
			
			students=sqlSession.selectList("selectAllStudents");

		} finally{
			
			//sqlSession关闭后会自动提交,自动关闭IO流,出错后会自动回滚
			if(sqlSession!=null) sqlSession.close();
		}
		return students;
	}

	@Override
	public Map<String, Object> selectAllStudentsMap() {
		// TODO Auto-generated method stub
		Map<String, Object> map=null;
		try {
			
			sqlSession=MyBatisUtils.getSqlSession();
			
			//第二个参数想放什么都行,但必须是要查询对象的属性
			map=sqlSession.selectMap("selectAllStudents","id");

		} finally{
			
			//sqlSession关闭后会自动提交,自动关闭IO流,出错后会自动回滚
			if(sqlSession!=null) sqlSession.close();
		}
		return map;
	}

	@Override
	public Student selectStudentById(int id) {
		// TODO Auto-generated method stub
		Student student=null;
		try {
			
			sqlSession=MyBatisUtils.getSqlSession();
			
			student=sqlSession.selectOne("selectStudentById", id);
			
		} finally {
			
			if(sqlSession!=null) sqlSession.close(); sqlSession=null;
		}
		return student;
	}

	//模糊查询
	@Override
	public List<Student> selectStudentsByName(String name) {
		// TODO Auto-generated method stub
		List<Student> students=null;
		try{
			
			sqlSession=MyBatisUtils.getSqlSession();
			
			students=sqlSession.selectList("selectStudentsByName", name);
			
		} finally {
			
			if(sqlSession!=null) sqlSession.close(); sqlSession=null;
		}
		
		return students;
	}

}
