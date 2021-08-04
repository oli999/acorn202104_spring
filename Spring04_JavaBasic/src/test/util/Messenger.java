package test.util;

import org.springframework.stereotype.Component;

@Component
public class Messenger {
	
	
	public void sendGreeting(String msg) {
		System.out.println("오늘의 인사:"+msg);
	}
	
	
	
	public String getMessage() {
		System.out.println("getMessage() 메소드가 수행됩니다.");
		return "열심히 공부 하자";
	}
	
}






