package com.xiaoxiao.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.xiaoxiao.domain.User;
import com.xiaoxiao.util.MyBatisUtils;

public class TestMybatis {
	@Test
	public void testSelectUsers() {
		SqlSession session = MyBatisUtils.getSqlSession();
		String statement = "com.xiaoxiao.mapping.userMapper.selectUsers";
		User user = session.selectOne(statement, 2);
		System.out.println(user);
		session.close();
	}
	
//	@Test
//	public void testSelectAllOfUsers() {
//		SqlSession session = MyBatisUtils.getSqlSession();
//		UserMapper mapper = session.getMapper(UserMapper.class);
//		User user = mapper.selectUser(2);
//		System.out.println(user);
//		session.close();
//		
//	}
}
