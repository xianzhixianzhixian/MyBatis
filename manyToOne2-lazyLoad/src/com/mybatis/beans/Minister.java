/**
 * 作者：樊钰丰
 * 时间：2017.9.1
 * 功能：一个实体类
 */

package com.mybatis.beans;

public class Minister {

	//不要写成驼峰命名,jvm解析时易出错
	private Integer mid;
	private String mname;
	//关联属性
	private Country country;
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
}
