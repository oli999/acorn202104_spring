package com.gura.spring03.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.member.dao.MemberDao;
import com.gura.spring03.member.dto.MemberDto;
import com.gura.spring03.member.service.MemberService;
/*
 *  [ 컨트롤러에서 하는 작업 ]
 *  
 *  1. 전송된 파라미터 추출 가능
 *  2. 특정 요청이 왔을때 서비스를 이용해서 비즈니스 로직을 처리하고 forward, 혹은 redirect 이동한다.
 *  3. HttpServletRequest, HttpServletResponse, HttpSession, ModelAndView 등의 
 *     객체가 필요하면 메소드의 인자로 전달 받는다.
 */
@Controller
public class MemberController {
	/*
	 *  필요한 핵심의존 객체를 인터페이스 type field 로 선언하고 
	 *  spring bean container 로 부터 객체의 참조값을 주입(DI) 받을수 있도록
	 *  @Autowired 어노테이션을 붙여 준다.
	 */
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private MemberDao dao;
	
	//안드로이드에서 전송하는 회원 추가 요청을 처리하고 결과를 json 으로 응답하는 메소드
	@RequestMapping(value = "/api/member/insert", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insert(MemberDto dto){
		dao.insert(dto);
		
		Map<String, Object> map=new HashMap<>();
		map.put("isSuccess", true);
		
		return map;
	}
	
	//안드로이드에서 요청하는 회원 목록 요청에 대해서 회원 목록을 json 으로 응답하는 메소드
	@RequestMapping("/api/member/list")
	@ResponseBody
	public List<MemberDto> getList(){
		
		return dao.getList();
	}
	
	
	//회원 한명의 정보를 삭제하는 메소드
	@RequestMapping("/member/delete")
	public String delete(@RequestParam int num) {
		service.deleteMember(num);
		//리다일렉트 이동
		return "redirect:/member/list.do";
	}
	
	
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		//MemberService 에 ModelAndView 객체의 참조값을 전달해서 회원 목록이 담기게 한다. 
		service.getListMember(mView);
		
		//ModelAndView 객체에 view page 의 정보를 담고 
		mView.setViewName("member/list");
		//리턴해준다. 
		return mView;
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
		service.addMember(dto);
		
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
		//MemberService 를 이용해서 ModelAndView 객체에 회원 한명의 정보가 담기게 한다.
		service.getMember(num, mView);
		//view page 정보도 담고
		mView.setViewName("member/updateform");
		//ModelAndView 객체를 리턴해 준다. 
		return mView;
	}
	
	//회원 정보 수정 요청 처리
	@RequestMapping("/member/update")
	public ModelAndView update(MemberDto dto, ModelAndView mView) {
		//회원정보를 수정하고 
		service.updateMember(dto);
		
		//ModelAndView 에 msg 라는 키값으로 메세지를 담고 
		mView.addObject("msg", dto.getNum()+" 번 회원의 정보를 수정했습니다.");
		// view page 정보도 담아서 
		mView.setViewName("member/alert");
		//리턴해 준다. 
		return mView;
	}
}











