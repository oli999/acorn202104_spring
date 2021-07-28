package com.gura.spring05.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//bean 이 될수 있도록 
@Repository
public class UsersDaoImpl implements UsersDao{
	//필요한 핵심 의존 객체
	@Autowired
	private SqlSession session;
	
}
