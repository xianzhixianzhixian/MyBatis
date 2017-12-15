/**
 * 作者：樊钰丰
 * 时间：2017.9.1
 * 功能：城市实体类
 */

package com.mybatis.beans;

import java.util.Set;

public class Country {

	private Integer cid;
	private String cname;
	//关联属性
	//一般一对多的关系中用的都是Set集合,set集合不允许重复值
	private Set<Minister> ministers;
	
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
	public Set<Minister> getMinisters() {
		return ministers;
	}
	public void setMinisters(Set<Minister> ministers) {
		this.ministers = ministers;
	}
	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + ", ministers=" + ministers + "]";
	}
}
