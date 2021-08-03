package com.gura.spring05.exception;

public class NotDeleteException extends RuntimeException{
	
	//생성자
	public NotDeleteException(String message) {
		//생성자의 인자로 전달받은 예외 메세지를 부모 생성자에 전달해 준다.
		super(message);
	}
}
