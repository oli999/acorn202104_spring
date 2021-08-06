package com.gura.spring05.exception;

import org.springframework.dao.DataAccessException;

/*
 *  DB 관련된 작업을 하다가 Transaction 에 영향을 주는 custom Exception 을 만들고 싶으면
 *  extends DataAccessException 클래스를 상속 받아서 만들면 된다. 
 */
public class NotDeliveryException extends DataAccessException{

	public NotDeliveryException(String msg) {
		super(msg);
	}

}
