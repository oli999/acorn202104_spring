package com.gura.spring05.cafe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring05.cafe.dto.CafeCommentDto;
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
	//글 자세히 보기 요청 처리
	@RequestMapping("/cafe/detail")
	public String detail(HttpServletRequest request) {
		service.getDetail(request);
		return "cafe/detail";
	}
	//새로운 댓글 저장 요청 처리
	@RequestMapping("/cafe/private/comment_insert")
	public String commentInsert(HttpServletRequest request, 
			@RequestParam int ref_group) {
		
		service.saveComment(request);
		
		return "redirect:/cafe/detail.do?num="+ref_group;
	}
	//댓글 더보기 요청 처리
	@RequestMapping("/cafe/ajax_comment_list")
	public String ajaxCommentList(HttpServletRequest request) {
		
		service.moreCommentList(request);
		
		return "cafe/ajax_comment_list";
	}
	//댓글 삭제 요청 처리
	@RequestMapping("/cafe/private/comment_delete")
	@ResponseBody
	public Map<String, Object> commentDelete(HttpServletRequest request) {
		service.deleteComment(request);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("isSuccess", true);
		// {"isSuccess":true} 형식의 JSON 문자열이 응답되도록 한다. 
		return map;
	}
	//댓글 수정 요청처리 (JSON 을 응답하도록 한다)
	@RequestMapping("/cafe/private/comment_update")
	@ResponseBody
	public Map<String, Object> commentUpdate(CafeCommentDto dto){
		service.updateComment(dto);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("isSuccess", true);
		// {"isSuccess":true} 형식의 JSON 문자열이 응답되도록 한다. 
		return map;
	}
	//카페글 삭제 요청 처리 
	@RequestMapping("/cafe/private/delete")
	public String delete(@RequestParam int num, HttpServletRequest request) {
		
		service.deleteContent(num, request);
		
		return "redirect:/cafe/list.do";
	}
	
	@RequestMapping("/cafe/private/updateform")
	public String updateForm(HttpServletRequest request) {
		
		service.getData(request);
		
		return "cafe/updateform";
	}
	//카페글 수정 요청 처리 
	@RequestMapping(value = "/cafe/private/update", method = RequestMethod.POST)
	public String update(CafeDto dto) {
		service.updateContent(dto);
		return "cafe/update";
	}
}











