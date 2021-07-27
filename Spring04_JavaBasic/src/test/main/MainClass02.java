package test.main;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass02 {
	public static void main(String[] args) {
		
		//비밀번호를 암호화 해주는 객체 생성
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		//입력한 "1234" 라는 비밀번호를 암호화 해서 DB에 저장된 비밀번호라고 가정하자  
		String savedPwd=encoder.encode("1234");
		
		//비밀번호를 입력 받아서 
		Scanner scan=new Scanner(System.in);
		System.out.print("비밀번호 입력:");
		String inputPwd=scan.nextLine();
		
		//DB 에 저장된 비밀번호와 일치하는지 확인 하기
		boolean isValid=BCrypt.checkpw(inputPwd, savedPwd);
		if(isValid) {
			System.out.println("비밀 번호가 일치 합니다.");
		}else {
			System.out.println("비밀 번호가 일치하지 않습니다.");
		}
	}
}





