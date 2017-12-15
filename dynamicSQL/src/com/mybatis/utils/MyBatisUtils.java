/**
 * 作者：樊钰丰
 * 时间：2017.8.29
 * 功能：MyBatis工具类
 */

package com.mybatis.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {

	//SqlSessionFactory是重量级对象,并且是线程安全的
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSession getSqlSession(){
		
		try {
			
			//1、加载主配置文件
			InputStream inputStream=Resources.getResourceAsStream("mybatis.xml");
			//2、创建SqlSessionFactoryBuilder对象
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
			
			if(sqlSessionFactory==null){
				//3、创建SqlSessionFactory对象
				sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
			}

			//4、创建SqlSession对象
			return sqlSessionFactory.openSession();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
