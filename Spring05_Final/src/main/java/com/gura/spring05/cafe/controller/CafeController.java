package com.gura.spring05.cafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gura.spring05.cafe.dto.CafeDto;
import com.gura.spring05.cafe.service.CafeService;

@Controller
public class CafeController {
	@Autowired
	private CafeService service;
	
	@RequestMapping("/cafe/list")
	public String getList(HttpServletRequest request) {
		
		service.getList(request);
		
		return "cafe/list";
	}
	
	@RequestMapping("/cafe/private/insertform")
	public String insertForm() {
		
		return "cafe/insertform";
	}
	//새글 저장 요청 처리 
	@RequestMapping("/cafe/private/insert")
	public String insert(CafeDto dto, HttpSession session) {
		//글 작성자는 세션에서 얻어낸다. 
		String id=(String)session.getAttribute("id");
		//CafeDto 객체에 글 작성자도 담기
		dto.setWriter(id);
		service.saveContent(dto);
		
		return "cafe/insert";
	}
}











