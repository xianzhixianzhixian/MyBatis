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

	List<Student> selectStudentsByIf(Student student); //模糊查询
	List<Student> selectStudentsByWhere(Student student); //模糊查询
	List<Student> selectStudentsByChoose(Student student);
	List<Student> selectStudentsByForeachArray(int[] ids); //通过数组中的元素查询
	List<Student> selectStudentsByForeachList(List<Integer> ids); //通过List中的(基本变量)元素查询
	List<Student> selectStudentsByForeachStudentList(List<Student> students); //通过StudentList中的(泛型元素)元素查询
	List<Student> selectStudentsBySQLFragment(List<Student> students); //通过sql片断查询
}
