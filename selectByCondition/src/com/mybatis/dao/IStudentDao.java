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

	List<Student> selectStudentsByCondiction(String name,int age); //模糊查询
}
