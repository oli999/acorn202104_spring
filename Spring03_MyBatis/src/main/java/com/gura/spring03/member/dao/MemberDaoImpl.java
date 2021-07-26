package com.gura.spring03.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring03.member.dto.MemberDto;

// 스프링이 객체를 생성하고 spring bean container 에서 관리하도록 어노테이션을 붙여준다. 
@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<MemberDto> getList() {
		/*
		 *  Mapper's namespace : member
		 *  sql's id : getList
		 *  resultType : MemberDto 
		 */
		List<MemberDto> list=session.selectList("member.getList");
		
		return list;
	}

	@Override
	public void delete(int num) {
		/* 
		 * Mapper's nameaspace : member
		 * sql's id : delete
		 * parameterType : int
		 */
		session.delete("member.delete", num);
	}

	@Override
	public void insert(MemberDto dto) {
		/*
		 *  Mapper's nameaspace : member
		 *  sql's id : insert
		 *  parameterType : MemberDto
		 */
		session.insert("member.insert", dto);
	}

	@Override
	public MemberDto getData(int num) {
		/*
		 *  Mapper's namespace : member
		 *  sql's id : getData
		 *  parameterType : int
		 *  resultType : MemberDto
		 */
		MemberDto dto=session.selectOne("member.getData", num);
		return dto;
	}

	@Override
	public void update(MemberDto dto) {
		/*
		 * Mapper's namespace : member
		 * sql's id : update
		 * parameterType : MemberDto
		 */
		session.update("member.update", dto);
	}

}





