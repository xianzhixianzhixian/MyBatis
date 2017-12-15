/**
 * 作者：樊钰丰
 * 时间：2017.9.1
 * 功能：查询country的接口
 */

package com.mybatis.dao;

import com.mybatis.beans.Country;

public interface ICountryDao {

	Country selectCountryById(int cid);
}
