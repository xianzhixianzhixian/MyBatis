/**
 * 作者：樊钰丰
 * 时间：2017.9.1
 * 功能：查询的接口
 */

package com.mybatis.dao;

import java.util.List;

import com.mybatis.beans.Student;

public interface IStudentDao {

	Student selectStudentById(int sid);
}
