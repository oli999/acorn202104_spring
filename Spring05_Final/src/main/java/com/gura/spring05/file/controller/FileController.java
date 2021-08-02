package com.gura.spring05.file.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.file.dto.FileDto;
import com.gura.spring05.file.service.FileService;

@Controller
public class FileController {
	@Autowired
	private FileService service;
	
	@RequestMapping("/file/list")
	public String list(HttpServletRequest request) {
		
		service.getList(request);
		
		return "file/list";
	}
	
	@RequestMapping("/file/private/upload_form")
	public String uploadForm() {
		
		return "file/upload_form";
	}
	
	//파일 업로드 요청처리
	@RequestMapping("/file/private/upload")
	public ModelAndView upload(FileDto dto, ModelAndView mView,
			HttpServletRequest request) {
		
		service.saveFile(dto, mView, request);
		mView.setViewName("file/upload");
		
		return mView;
	}
	
	@RequestMapping("/file/download")
	public ModelAndView download(@RequestParam int num, ModelAndView mView) {
		service.getFileData(num, mView);
		// 응답을 할 bean 의 이름을 설정 
		mView.setViewName("fileDownView");
		return mView;
	}
	
}











