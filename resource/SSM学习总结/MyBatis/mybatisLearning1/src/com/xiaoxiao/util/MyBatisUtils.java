package com.xiaoxiao.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//通过一个工具类来获取sqlSession，这个sqlSession相当于JDBC的Connection对象
public class MyBatisUtils {
//	public static SqlSession getSqlSession() {
//		String resource = "mybatis-configuration.xml";
//		InputStream inputStream = MyBatisUtils.class.getResourceAsStream(resource);
//		//每个基于MyBatis的应用都是以一个SqlSessionFactory的实例为核心的。SqlSessionFactory的实例可以通过SqlSessionFactoryBuilder来获取。
//		//而SqlSessionFactoryBuilder则可以通过从XML配置文件或一个预先定制的Configuration的实例构建出SqlSessionFactory的实例
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//		return factory.openSession();
//	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		String resource= "mybatis-configuration.xml";
		//缺少getClassLoader()方法报NullPointerExcepition错误
		InputStream inputStream = MyBatisUtils.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		return factory;
	}
	
	public static SqlSession getSqlSession() {
		return getSqlSessionFactory().openSession();
	}
}
