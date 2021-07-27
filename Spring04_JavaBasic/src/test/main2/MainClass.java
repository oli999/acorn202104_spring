package test.main2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;

public class MainClass {
	public static void main(String[] args) {
		//무언가를 공격해야 한다면 어떤 코딩이 필요할까?
		
		// init.xml 문서를 해석해서 spring bean container 의 개념을 만든다. 
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main2/init.xml");
		// spring bean container 에서 Weapon type 의 참조값을 얻어온다.
		Weapon w=context.getBean(Weapon.class);
		
		//목적 달성!
		w.attack();
	}
}








