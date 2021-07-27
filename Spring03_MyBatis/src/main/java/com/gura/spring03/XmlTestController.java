package com.gura.spring03;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class XmlTestController {
	
	@RequestMapping("/xml01")
	public String xml01() {
		
		return "xml01";
	}
	@RequestMapping("/xml02")
	@ResponseBody
	public Data xml02() {
		/*
		 *  XmlRootElement 와 XmlElement 설정이 되어있는 클래스로 객체 생성해서
		 *  데이터를 담고 
		 */
		Data d=new Data();
		d.setNum(1);
		d.setName("김구라");
		// 리턴해주면 xml 형식의 문자열이 응답된다.
		return d;
	}
	
	@RequestMapping("/xml03")
	@ResponseBody
	public HobbyList xml03() {
		//List 에 취미 목록을 담고 
		List<String> hobby=new ArrayList<>();
		hobby.add("java");
		hobby.add("jsp");
		hobby.add("spring");
		
		//HobbyList 객체를 생성해서 
		HobbyList h=new HobbyList();
		//취미 목록을 setter 메소드를 이용해서 넣어주고 
		h.setHobby(hobby);
		//리턴해준다. 
		return h;
	}	
}











