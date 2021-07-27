package com.gura.spring03;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 *  xml 을 응답하기 위한 클래스 설계 하기 
 */

@XmlRootElement(name = "data")
public class Data {
	private int num;
	private String name;
	
	public int getNum() {
		return num;
	}
	
	@XmlElement
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
}
