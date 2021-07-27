package com.gura.spring03;

import org.springframework.web.multipart.MultipartFile;

public class FileDto {
	private int num;
	private String title;
	//업로드되는 파일의 정보를 담을 MultipartFile type 도 필드에 선언한다.
	//필드명을 <input type="file" name="myFile" /> 에서 name 속성의 value 와 일치 시킨다.
	private MultipartFile myFile;
	
	public FileDto() {}

	public FileDto(int num, String title, MultipartFile myFile) {
		super();
		this.num = num;
		this.title = title;
		this.myFile = myFile;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getMyFile() {
		return myFile;
	}

	public void setMyFile(MultipartFile myFile) {
		this.myFile = myFile;
	}
	
	
	
}
