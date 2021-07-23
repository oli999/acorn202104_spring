package com.gura.spring01;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	// <input type="text" name="msg" />  에 입력한 파라미터를 어떻게 추출할까?
	@RequestMapping("/test/send")
	public String send(HttpServletRequest request) {
		
		String msg=request.getParameter("msg");
		System.out.println(msg);
		
		// "/WEB-INF/views/" + "test/send" + ".jsp"
		return "test/send";
	}
	
	/*
	 *  @RequestParam 어노테이션과 함께 메소드의 매개변수를 선언한다.
	 *  매개 변수명과 요청 파라미터명을 일치 시키면 된다. 
	 *  
	 *  <input type="text" name="msg" />  에서 name 속성의 value 와
	 *  @RequestParam String msg  에서  msg 와 같으면 된다. 
	 */
	@RequestMapping("/test/send2")
	public String send2(@RequestParam String msg) {
		//잘 추출이 되는지 콘솔창에 확인하기 
		System.out.println(msg);
		
		// "/WEB-INF/views/" + "test/send" + ".jsp"
		return "test/send";
	}	
	
//	@RequestMapping("/test/buy")
//	public String buy(HttpServletRequest request) {
//		int code=Integer.parseInt(request.getParameter("code"));
//		System.out.println(code+" 번 상품을 주문 합니다.");
//		
//		// "/WEB-INF/views/" + "test/buy" + ".jsp"
//		return "test/buy";
//	}
	
	@RequestMapping("/test/buy")
	public String buy(@RequestParam(defaultValue = "0") int code) { // int 로 선언하면 알아서 숫자로 바껴서 전달된다.
		System.out.println(code+" 번 상품을 주문 합니다.");
		// "/WEB-INF/views/" + "test/buy" + ".jsp"
		return "test/buy";
	}
	
//	@RequestMapping("/test/insert")
//	public String insert(HttpServletRequest request) {
//		//폼 전송되는 파라미터를 추출해서 
//		int num=Integer.parseInt(request.getParameter("num"));
//		String name=request.getParameter("name");
//		String addr=request.getParameter("addr");
//		//dto 에 담고
//		MemberDto dto=new MemberDto();
//		dto.setNum(num);
//		dto.setName(name);
//		dto.setAddr(addr);
//		//dao 를 이용해서 DB 에 저장하고
//		
//		//응답하기 
//		return "test/insert";
//	}
	
//	@RequestMapping("/test/insert")
//	public String insert(@RequestParam int num, 
//			@RequestParam String name,
//			@RequestParam String addr) {
//		
//		//dto 에 담고
//		MemberDto dto=new MemberDto();
//		dto.setNum(num);
//		dto.setName(name);
//		dto.setAddr(addr);
//		//dao 를 이용해서 DB 에 저장하고
//		
//		//응답하기 
//		return "test/insert";
//	}
	
	/*
	 *  전송되는 파라미터 명이 dto 의 필드명과 일치해야 한다. 
	 */
	@RequestMapping("/test/insert")
	public String insert(MemberDto dto) {
		
		//dao 를 이용해서 DB 에 저장하고
		
		//응답하기 
		return "test/insert";
	}
}








