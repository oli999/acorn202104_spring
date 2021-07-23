package com.gura.hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. @Controller 어노테이션을 클래스에 붙인다.
@Controller
public class FortuneController {
	
	//2. 메소드를 만들고 어떤 경로 요청을 처리할지 RequestMapping 어노테이션에 명시한다.
	@RequestMapping("/fortune")
	public String fortune(HttpServletRequest request) { //메소드명은 마음대로 , return type 은 String
		//오늘의 운세를 얻어오는 비즈니스 로직을 수행한다.
		String fortuneToday="동쪽으로 가면 귀인을 만나요!";
		//request 에 "fortuneToday" 라는 키값으로 담기 
		request.setAttribute("fortuneToday", fortuneToday);
		
		//3. forward 이동해서 응답할 jsp 페이지의 위치를 문자열로 리턴한다.
		return "fortune"; // 리턴한 문자열의 앞에 /WEB-INF/views/ 뒤에 .jsp 가 붙는다.
	}
}






