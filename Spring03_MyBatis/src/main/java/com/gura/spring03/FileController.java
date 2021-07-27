package com.gura.spring03;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {
	
	@RequestMapping("/upload_test")
	public String upload_test() {
		
		return "upload_test";
	}
	/*
	 *  [ 파일 업로드 처리 하는 방법 ]
	 *  
	 *  1. pom.xml 에  commons-io, commons-fileupload dependency 설정
	 *  2. servlet-context.xml 에  CommonsMultipartResolver  bean 설정
	 *  3. <input type="file" name="myFile" />  에서   name 속성의 value 를
	 *     MultipartFile  type 을 받을때 지역 변수명 혹은 필드명과 일치 시킨다.
	 *     ex)  MultipartFile  myFile 
	 */
	
	
	//파일 업로드 요청 처리 
	@RequestMapping("/upload")
	public ModelAndView upload(ModelAndView mView,
			@RequestParam String title,
			@RequestParam MultipartFile myFile,
			HttpServletRequest request) {
		//업로드된 파일에 대한 정보를 MultipartFile 객체를 이용해서 얻어낼수 있다.	
		
		//원본 파일명
		String orgFileName=myFile.getOriginalFilename();
		//upload 폴더에 저장할 파일명을 직접구성한다.
		// 1234123424343xxx.jpg
		String saveFileName=System.currentTimeMillis()+orgFileName;
		//파일의 크기
		long fileSize=myFile.getSize();
		// webapp/upload 폴더까지의 실제 경로 얻어내기 
		String realPath=request.getServletContext().getRealPath("/upload");
		// upload 폴더가 존재하지 않을경우 만들기 위한 File 객체 생성
		File upload=new File(realPath);
		if(!upload.exists()) {//만일 존재 하지 않으면
			upload.mkdir(); //만들어준다.
		}
		try {
			//파일을 저장할 전체 경로를 구성한다.  
			String savePath=realPath+File.separator+saveFileName;
			//임시폴더에 업로드된 파일을 원하는 파일을 저장할 경로에 전송한다.
			myFile.transferTo(new File(savePath));
			//테스트로 저장된 경로를 콘솔에 출력하기
			System.out.println("savePath:"+savePath);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mView.addObject("orgFileName", orgFileName);
		mView.addObject("saveFileName", saveFileName);
		mView.addObject("fileSize", fileSize);
		mView.addObject("title", title);
		
		mView.setViewName("upload");
		
		return mView;
	}
	
	//파일 업로드 요청 처리2 
	@RequestMapping("/upload2")
	public ModelAndView upload2(ModelAndView mView,
			FileDto dto,
			HttpServletRequest request) {
		//업로드된 파일에 대한 정보를 MultipartFile 객체를 이용해서 얻어낼수 있다.	
		
		MultipartFile myFile=dto.getMyFile();
		
		//원본 파일명
		String orgFileName=myFile.getOriginalFilename();
		//upload 폴더에 저장할 파일명을 직접구성한다.
		// 1234123424343xxx.jpg
		String saveFileName=System.currentTimeMillis()+orgFileName;
		//파일의 크기
		long fileSize=myFile.getSize();
		// webapp/upload 폴더까지의 실제 경로 얻어내기 
		String realPath=request.getServletContext().getRealPath("/upload");
		// upload 폴더가 존재하지 않을경우 만들기 위한 File 객체 생성
		File upload=new File(realPath);
		if(!upload.exists()) {//만일 존재 하지 않으면
			upload.mkdir(); //만들어준다.
		}
		try {
			//파일을 저장할 전체 경로를 구성한다.  
			String savePath=realPath+File.separator+saveFileName;
			//임시폴더에 업로드된 파일을 원하는 파일을 저장할 경로에 전송한다.
			myFile.transferTo(new File(savePath));
			//테스트로 저장된 경로를 콘솔에 출력하기
			System.out.println("savePath:"+savePath);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mView.addObject("orgFileName", orgFileName);
		mView.addObject("saveFileName", saveFileName);
		mView.addObject("fileSize", fileSize);
		mView.addObject("title", dto.getTitle());
		
		mView.setViewName("upload");
		
		return mView;
	}
}


















