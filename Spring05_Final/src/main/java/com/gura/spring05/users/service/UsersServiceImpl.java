package com.gura.spring05.users.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.users.dao.UsersDao;
import com.gura.spring05.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDao dao;

	@Override
	public Map<String, Object> isExistId(String inputId) {
		//Map 객체를 생성해서 
		Map<String, Object> map=new HashMap<String, Object>();
		//isExist 라는 키값으로 아이디가 존재하는지 여부를 담고 
		map.put("isExist", dao.isExist(inputId));
		//Map 객체를 리턴해 준다. 
		return map;
	}

	@Override
	public void addUser(UsersDto dto) {
		//사용자가 입력한 비밀 번호를 읽어와서 
		String pwd=dto.getPwd();
		//암호화 한 후에 
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPwd=encoder.encode(pwd);
		//dto 에 다시 넣어준다.
		dto.setPwd(encodedPwd);
		
		dao.insert(dto);
	}

	@Override
	public void loginProcess(UsersDto dto, HttpSession session) {
		//입력한 정보가 맞는여부
		boolean isValid=false;
		
		//1. 로그인 폼에 입력한 아이디를 이용해서 해당 정보를 select 해 본다. 
		UsersDto result=dao.getData(dto.getId());
		if(result != null) {//만일 존재하는 아이디 라면
			//비밀번호가 일치하는지 확인한다.
			String encodedPwd=result.getPwd(); //DB 에 저장된 암호화된 비밀번호 
			String inputPwd=dto.getPwd(); //로그인폼에 입력한 비밀번호
			//Bcrypt 클래스의 static 메소드를 이용해서 일치 여부를 얻어낸다.
			isValid=BCrypt.checkpw(inputPwd, encodedPwd);
		}
		
		if(isValid) {//만일 유효한 정보이면 
			//로그인 처리를 한다.
			session.setAttribute("id", dto.getId());
		}
	}

	@Override
	public void getInfo(HttpSession session, ModelAndView mView) {
		//로그인된 아이디를 읽어온다. 
		String id=(String)session.getAttribute("id");
		//DB 에서 회원 정보를 얻어와서 
		UsersDto dto=dao.getData(id);
		//ModelAndView 객체에 담아준다.
		mView.addObject("dto", dto);
	}
	
}














