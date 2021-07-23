package com.gura.spring02;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// component scan 을 통해서 객체가 생성이되고 spring bean container 에서 관리가 된다. 
@Controller
public class FriendsController {
	
	// "/friends.do" 요청을 처리할 메소드  .do 는 생략 가능
	@RequestMapping("/friends")
	public String friends(HttpServletRequest request) {
		//DB 에서 얻어온 친구 목록이라고 가정하자 
		List<String> names=new ArrayList<String>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		
		//view page 에 전달할 데이터를 request 에 담는다.
		request.setAttribute("names", names);
		
		//view page 로 forward 이동해서 친구 목록 응답하기 
		return "friends";
	}
	
	// "/friends2.do" 요청을 처리할 메소드  .do 는 생략 가능
	@RequestMapping("/friends2")
	public ModelAndView friends2() {
		//DB 에서 얻어온 친구 목록이라고 가정하자 
		List<String> names=new ArrayList<String>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		/*
		 *  Model (Data) 와  view page 의 정보를 모두 가지고 있는 객체를
		 *  생성해서 정보를 담고 
		 *  컨트롤러의 메소드에서 리턴해주면 알아서 동작하다. 
		 */
		ModelAndView mView=new ModelAndView();
		mView.addObject("names", names);
		mView.setViewName("friends");
		
		return mView;
	}
	
	// ModelAndView type 을 메소드의 인자로 받을 준비를 해 놓으면
	// spring 이 알아서 객체를 생성해서 참조값을 메소드의 인자로 전달해 준다. 
	@RequestMapping("/friends3")
	public ModelAndView friends3(ModelAndView mView) {
		//DB 에서 얻어온 친구 목록이라고 가정하자 
		List<String> names=new ArrayList<String>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		/*
		 *  Model (Data) 와  view page 의 정보를 모두 가지고 있는 객체를
		 *  생성해서 정보를 담고 
		 *  컨트롤러의 메소드에서 리턴해주면 알아서 동작하다. 
		 */
		mView.addObject("names", names);
		mView.setViewName("friends");
		
		return mView;
	}
	
	//친구 정보를 삭제하는 요청 처리 
	@RequestMapping("/delete")
	public String delete() {
		System.out.println("친구 정보를 삭제 했습니다.");
		
		/*
		 * spring 에서 forward 이동이 아닌 redirect 이동을 하려면 ...
		 * 
		 *  "redirect: context path 를 제외한 절대경로" 를 리턴하면 된다. 
		 */
		return "redirect:/friends.do";
	}
	//친구 정보를 삭제하는 요청 처리 
	@RequestMapping("/delete2")
	public ModelAndView delete2(ModelAndView mView) {
		System.out.println("친구 정보를 삭제 했습니다.");
		
		// ModelAndView 객체를 이용해서 redirect 이동을 할수도 있다. 
		mView.setViewName("redirect:/friends.do");
		
		return mView;
	}
}







