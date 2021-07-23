package com.gura.spring03.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gura.spring03.member.dao.MemberDao;
import com.gura.spring03.member.dto.MemberDto;

@Controller
public class MemberController {
	/*
	 *  필요한 핵심의존 객체를 인터페이스 type field 로 선언하고 
	 *  spring bean container 로 부터 객체의 참조값을 주입(DI) 받을수 있도록
	 *  @Autowired 어노테이션을 붙여 준다.
	 */
	
	@Autowired
	private MemberDao dao;
	
	
	//회원 한명의 정보를 삭제하는 메소드
	@RequestMapping("/member/delete")
	public String delete(@RequestParam int num) {
		//회원정보 삭제하고 
		dao.delete(num);
		//리다일렉트 이동
		return "redirect:/member/list.do";
	}
	
	
	@RequestMapping("/member/list")
	public String list(HttpServletRequest request) {
		//회원 목록은 MemberDaoImpl 객체를 이용해서 얻어와서 request 담아 준다. 
		
		List<MemberDto> list=dao.getList();
		
		request.setAttribute("list", list);
		
		// /WEB-INF/views/member/list.jsp 페이지로 forward 이동해서 응답하기 
		return "member/list";
	}
}





