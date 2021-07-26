package com.gura.spring03.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	//회원 추가 폼 요청 처리
	@RequestMapping("/member/insertform")
	public String insertform() {
		//회원 추가 폼으로 forward 이동만 시켜주면 된다. 
		return "member/insertform";
	}
	
	//회원 추가 요청 처리
	@RequestMapping("/member/insert")
	public ModelAndView insert(MemberDto dto, ModelAndView mView) {
		//폼전송된 파라미터가 MemberDto 객체에 담겨서 전달된다.
		dao.insert(dto);
		
		// ModelAndView 객체에 msg 라는 키값으로 문자열을 담고 
		mView.addObject("msg", "회원 한명의 정보를 추가 했습니다.");
		// view page 정보를 담고 
		mView.setViewName("member/alert");
		// ModelAndView 객체를 리턴해 준다. 
		return mView;
	}
	
	//회원 수정 폼 요청 처리
	@RequestMapping("/member/updateform")
	public ModelAndView updateform(@RequestParam int num, ModelAndView mView) {
		//회원 한명의 정보를 얻어와서 
		MemberDto dto=dao.getData(num);
		//ModelAndView 객체에 dto 라는 키값으로 담고
		mView.addObject("dto", dto);
		//view page 정보도 담고
		mView.setViewName("member/updateform");
		//ModelAndView 객체를 리턴해 준다. 
		return mView;
	}
	
	//회원 정보 수정 요청 처리
	@RequestMapping("/member/update")
	public ModelAndView update(MemberDto dto, ModelAndView mView) {
		//회원정보를 수정하고 
		dao.update(dto);
		
		//ModelAndView 에 msg 라는 키값으로 메세지를 담고 
		mView.addObject("msg", dto.getNum()+" 번 회원의 정보를 수정했습니다.");
		// view page 정보도 담아서 
		mView.setViewName("member/alert");
		//리턴해 준다. 
		return mView;
	}
}











