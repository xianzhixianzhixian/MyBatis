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
}
