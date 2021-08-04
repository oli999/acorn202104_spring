package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessengerAspect {
	/*
	 *  return type 은 String 이고
	 *  get 으로 시작은 메소드 이고
	 *  메소드에 전달되는 인자는 없다 
	 *  java.lang 페키지에 있는 type 은 페키지명 생략 가능
	 */
	@Around("execution(String get*())")
	public Object checkReturn(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// aspect 가 적용된 메소드를 수행하고 리턴되는 데이터 받아오기 
		Object obj=joinPoint.proceed();
		//원래 type 으로 casting 해서 조사해 볼수가 있다.
		String a = (String)obj;
		
		//조사후 아예 다른 값을 리턴해 줄수도 있다. 
		return "놀자놀자!";
	}
	
	// return type 은 void 이고 send 로 시작하는 모든 메소드가 point cut 이다.
	// @Around 로 aspect 를 적용하면 메소드의 인자로 ProceedingJoinPoint type 이 전달된다.
	@Around("execution(void send*(..))")
	public void checkGreeting(ProceedingJoinPoint joinPoint) throws Throwable {
		//메소드에 전달된 인자들 목록을 얻어내기
		Object[] args=joinPoint.getArgs();
		//반복문 돌면서 원하는 type 의 값을 찾아서 작업한다.
		for(Object tmp:args) {
			//만일 String type 이면
			if(tmp instanceof String) {
				//원래 type 으로 casting
				String msg=(String)tmp;
				System.out.println("aspect 에서 읽어낸 내용:"+msg);
				if(msg.contains("바보")) {
					System.out.println("바보는 금지된 단어 입니다.");
					return; // 메소드를 끝내기
				}
			}
		}
		
		//aspect 가 적용된 메소드가 호출 되기 직전에 할 작업은 여기서 한다. 
		
		joinPoint.proceed(); // aspect 가 적용된 메소드 수행하기 
		
		//aspect 가 적용된 메소드가  리턴된 직후에 할 작업은 여기서 한다. 
		System.out.println("aspect 가 적용된 메소드가 리턴 했습니다.");
	}
}















