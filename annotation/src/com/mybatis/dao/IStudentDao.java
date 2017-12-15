/**
 * 作者：樊钰丰
 * 时间：2017.9.4
 * 功能：学生数据库信息(注解式开发应用)
 * 同一个注解只能在一个函数上用一次
 */

package com.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.mybatis.beans.Student;

public interface IStudentDao {

	//对于value数组中只有一个元素的时候,value中的中括号({})可以不写
	@Insert(value = { "insert into student(name,age,score) values(#{name},#{age},#{score})" })
	void insertStudent(Student student);
	
	//此处比较复杂
	@Insert(value={ "insert into student(name,age,score) values(#{name},#{age},#{score})" } )
	@SelectKey(before = false, keyProperty = "id", resultType =Integer.class , statement = { "select @@identity" })
	void insertStudentCatchId(Student student);
	
	@Delete(value = "delete from student where id=#{id}" )
	void deleteStudentById(int id);
	
	@Update("delete from student where id=#{id}" )
	void updateStudent(Student student);
	
	@Select(value = { "select id,name,age,score from student" })
	List<Student> selectAllStudents();
	
	@Select(value = { "select id,name,age,score from student where id=#{id}" })
	Student selectStudentById(int id);
	
	@Select(value = { "select id,name,age,score from student where name like '%' #{name} '%'" })
	List<Student> selectStudentsByName(String name); //模糊查询
}
