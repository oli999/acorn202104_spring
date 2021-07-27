package test.auto;

public class Car {
	//필드
	private Engine engine;
	//생성자
	public Car(Engine engine) {
		this.engine=engine;
	}
	
	//메소드 
	public void drive() {
		System.out.println("달려요");
	}
}
