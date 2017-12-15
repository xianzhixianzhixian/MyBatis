/**
 * 作者：樊钰丰
 * 时间：2017.9.1
 * 功能：一对多查询实体,当前的新闻栏目被看作是一方(即父栏目)
 */

package com.mybatis.beans;

import java.util.Set;

public class NewsLabel {

	private Integer id;
	private String name; //栏目名称
	private NewsLabel parent;
	
	public Integer getId() {
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
	public NewsLabel getParent() {
		return parent;
	}
	public void setParent(NewsLabel parent) {
		this.parent = parent;
	}
}
