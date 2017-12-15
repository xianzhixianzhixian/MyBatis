/**
 * 作者：樊钰丰
 * 时间：2017.8.31
 * 功能：学生数据库信息
 */

package com.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.mybatis.beans.Student;

public interface IStudentDao {

	void insertStudent(Student student);
	void insertStudentCatchId(Student student);
	
	void deleteStudentById(int id);
	void updateStudent(Student student);
	
	List<Student> selectAllStudents();
	Map<String,Object> selectAllStudentsMap();
	
	Student selectStudentById(int id);
	List<Student> selectStudentsByName(String name); //模糊查询
}
