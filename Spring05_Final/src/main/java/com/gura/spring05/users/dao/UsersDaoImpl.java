package com.gura.spring05.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.users.dto.UsersDto;

//bean 이 될수 있도록 
@Repository
public class UsersDaoImpl implements UsersDao{
	//필요한 핵심 의존 객체
	@Autowired
	private SqlSession session;

	@Override
	public boolean isExist(String inputId) {
		//인자로 전달 받은 아이디가 존재 하는지 select 해 본다.
		String id=session.selectOne("users.isExist", inputId);
		if(id==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert", dto);
	}
	
}





