/**
 * 作者：樊钰丰
 * 时间：2017.9.1
 * 功能：课程实体类
 */

package com.mybatis.beans;

import java.util.Set;

public class Course {

	private Integer cid;
	private String cname;
	private Set<Student> students;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
