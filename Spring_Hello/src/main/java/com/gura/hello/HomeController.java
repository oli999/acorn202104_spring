package com.gura.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	/*
	 * 최상위 경로 / 요청이 왔을때 이 메소드를 통해서 응답하기 
	 */
	@RequestMapping("/")
	public String home() {
		
		// /WEB-INF/views/home.jsp 페이지로 forward 이동해서 응답하라는 의미 
		return "home";
	}
}



