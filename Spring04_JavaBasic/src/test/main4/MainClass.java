package test.main4;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.util.WritingUtil;

public class MainClass {
	public static void main(String[] args) {
		
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main4/init.xml");
		
		//만일 편지를 쓰고 싶다면?
		//WritingUtil util= new WritingUtil() ;
		WritingUtil util=context.getBean(WritingUtil.class) ;
		
		util.write1();
		util.write2();
		util.write3();
	}
}





