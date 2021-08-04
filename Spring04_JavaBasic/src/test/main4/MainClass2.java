package test.main4;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.util.Messenger;
import test.util.WritingUtil;

public class MainClass2 {
	public static void main(String[] args) {
		
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main4/init.xml");
		
		//spring bean 컨테이너로 부터 Messenger type 의 참조값 얻어내기
		Messenger m=context.getBean(Messenger.class);
		m.sendGreeting("굿 앱터눈~");
		m.sendGreeting("원숭이 바보야~");
		
		String msg=m.getMessage();
		System.out.println("리턴된 msg:"+msg);
		
		System.out.println("main 메소드가 종료 됩니다.");
	}
}













