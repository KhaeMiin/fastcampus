package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1.원격 호출 가능한 프로그램으로 등록
@Controller
public class Hello {
	int iv = 10; // 인스턴스 변수
	static int cv = 20; //static변수
	
	//2.URL과 메서드를 연결
	@RequestMapping("/hello")
	public void main() { //인스턴스 메서드 - iv,cv모두 사용가능
	//private일 경우: 작동된다. private:같은 패키지 url로 메서드를 연결했다는건 접근제어자 상관없이 외부에서 호출가능하게
		//static을 안넣어도 되는 이유 얘는 지금 인스턴스메서드(객체생성 후 호출가능 > url로 원격프로그램을 호출하면 톰캣에서 객체생성을 해줌 (Reflection API)> 메서드 호출됨)
		System.out.println("Hello");//이건 톰캣콘솔에 출력이 됨
		System.out.println(cv);//ok
		System.out.println(iv);//ok
	}
	
	public static void main2() {//static메서드 = cv만 사용가능
		System.out.println(cv);//ok
//		System.out.println(iv);//에러
		
	}
}
