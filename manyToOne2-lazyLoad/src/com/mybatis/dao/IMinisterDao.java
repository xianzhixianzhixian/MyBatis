/**
 * 作者：樊钰丰
 * 时间：2017.9.1
 * 功能：查询Minister的接口
 */

package com.mybatis.dao;

import com.mybatis.beans.Minister;

public interface IMinisterDao {

	Minister selectMinisterById(int mid);
}
