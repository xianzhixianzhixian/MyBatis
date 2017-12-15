/**
 * 作者：樊钰丰
 * 时间：2017.8.30
 * 功能：学生实体类
 */

package com.mybatis.beans;

import java.io.Serializable;

//开启EhcacheCache二级缓存不用将实体类序列化
public class Student {

	//成员变量
	private Integer id; //id需要定义成引用类型
	private String name;
	private int age;
	private double score;
	
	
	public Student() {
		super();
	}
	
	public Student(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	public Integer getId() { //getId->Id->id属性(属性是对外公开的)
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + "]";
	}	
}
