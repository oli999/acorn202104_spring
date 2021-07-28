package com.gura.spring03.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.member.dao.MemberDao;
import com.gura.spring03.member.dto.MemberDto;

// spring bean container 에서 관리되는 객체가 되기 위해 
@Service
public class MemberServiceImpl implements MemberService{
	
	// 의존객체를 주입 받기위해 
	@Autowired
	private MemberDao dao;
	
	@Override
	public void addMember(MemberDto dto) {
		dao.insert(dto);
	}

	@Override
	public void updateMember(MemberDto dto) {
		dao.update(dto);
	}

	@Override
	public void deleteMember(int num) {
		dao.delete(num);
	}

	@Override
	public void getMember(int num, ModelAndView mView) {
		//인자로 전달된 회원의 번호를 이용해서 회원정보를 얻어와서 
		MemberDto dto=dao.getData(num);
		//ModelAndView 객체에 담아준다. 
		mView.addObject("dto", dto);
	}

	@Override
	public void getListMember(ModelAndView mView) {
		//회원 전체의 목록을 얻어와서 
		List<MemberDto> list=dao.getList();
		//ModelAndView 객체에 담아준다.
		mView.addObject("list", list);
	}

}





