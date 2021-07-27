package test.main3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.auto.Car;
import test.auto.Sedan;

public class MainClass {
	public static void main(String[] args) {
		// init.xml 문서를 로딩해서 
		ApplicationContext context=
	            new ClassPathXmlApplicationContext("test/main3/init.xml");
		// Car type 의 참조값을 얻어와서
		Car car=context.getBean(Car.class);
		// drive() 메소드를 호출해 보세요.
		car.drive();
		
		Sedan sedan=context.getBean(Sedan.class);
		sedan.showInfo();
	}
}





