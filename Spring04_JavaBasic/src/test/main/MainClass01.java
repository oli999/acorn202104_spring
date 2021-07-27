package test.main;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass01 {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.print("비밀번호 입력:");
		String inputPwd=scan.nextLine();
		//비밀번호를 암호화 해주는 객체 생성
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		//암호화 하기 
		String result=encoder.encode(inputPwd);
		//결과 확인
		System.out.println("암호화된 비밀번호:"+result);
	}
}





