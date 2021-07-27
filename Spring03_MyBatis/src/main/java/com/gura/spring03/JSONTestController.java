package com.gura.spring03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring03.member.dto.MemberDto;

@Controller
public class JSONTestController {
	
	// GET 방식  /json01.do 요청이 왔을때 호출되는 메소드 
	@RequestMapping(value = "/json01", method = RequestMethod.GET)
	public String json01() {
		
		// /WEB-INF/views/json01.jsp
		return "json01";
	}
	// GET 방식 /json02.do 요청이 왔을때  json 형식의 문자열을 응답하겠다는 의미 
	@RequestMapping(value = "/json02", method = RequestMethod.GET,
			produces = "application/json;charset=utf-8")
	@ResponseBody //리턴하는 문자열을 클라이언트에게 그대로 출력하겠다는 의미
	public String json02() {
		
		return "{\"num\":1, \"name\":\"김구라\"}";
	}
	
	/*
	 *  1. jackson-databind 라이브러리가 dependency 에 명시가 되어 있고
	 *  2. servlet-context.xml 에 <annotation-driven/> 이 명시 되어 있고
	 *  3. 컨트롤러의 메소드에 @ResponseBody  어노테이션이 붙어 있으면
	 *  Map 객체에 담긴 내용이 json 문자열로 변환되어 응답된다. 
	 */
	@RequestMapping("/json03")
	@ResponseBody
	public Map<String, Object> json03(){
		//Map 에 특정 키값으로 데이터를 담고 
		Map<String, Object> map=new HashMap<>();
		map.put("num",1);
		map.put("name", "김구라");
		map.put("isMan",true);
		
		//Map 을 리턴해 준다.
		return map;
	}
	
	@RequestMapping("/json04")
	@ResponseBody
	public MemberDto json04() {
		MemberDto dto=new MemberDto(1, "김구라", "노량진");
		return dto;
	}
	
	@RequestMapping("/json05")
	@ResponseBody
	public List<String> json05(){
		List<String> names=new ArrayList<String>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		
		return names;
	}
	
	@RequestMapping("/json06")
	@ResponseBody
	public List<Map<String, Object>> json06(){
		List<Map<String, Object>> list=new ArrayList<>();
		
		Map<String, Object> map=new HashMap<>();
		map.put("num",1);
		map.put("name", "김구라");
		map.put("isMan",true);
		
		Map<String, Object> map2=new HashMap<>();
		map2.put("num",2);
		map2.put("name", "해골");
		map2.put("isMan",false);
		
		list.add(map);
		list.add(map2);
		
		return list;
	}
	
	@RequestMapping("/json07")
	@ResponseBody
	public List<MemberDto> json07(){
		//ArrayList 객체를 생성해서 
		List<MemberDto> list=new ArrayList<>();
		
		//MemberDto 객체에 각각의 정보를 담고 
		MemberDto dto=new MemberDto(1, "김구라", "노량진");
		MemberDto dto2=new MemberDto(2, "해골", "행신동");
		
		//ArrayList 에 MemberDto 객체를 저장하고 
		list.add(dto);
		list.add(dto2);
		
		//ArrayList 객체의 참조값 리턴 
		return list;
	}
}







