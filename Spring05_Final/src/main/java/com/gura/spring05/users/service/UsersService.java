package com.gura.spring05.users.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.users.dto.UsersDto;

public interface UsersService {
	
	public Map<String, Object> isExistId(String inputId);
	public void addUser(UsersDto dto);
	public void loginProcess(UsersDto dto, HttpSession session);
	public void getInfo(HttpSession session, ModelAndView mView);
	public void updateUserPwd(HttpSession session, UsersDto dto, ModelAndView mView);
	public Map<String, Object> saveProfileImage(HttpServletRequest request, 
			MultipartFile mFile);
	public void updateUser(UsersDto dto, HttpSession session);
	public void deleteUser(HttpSession session, ModelAndView mView);
}








