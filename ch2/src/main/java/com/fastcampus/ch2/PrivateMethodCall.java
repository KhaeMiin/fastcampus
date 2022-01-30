package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); // private이라서 외부 호출 불가
		
		//Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능제공 그래서 호출이 가능
		//java.lang.reflect
		//Hello클래스의 Class객체(클래스의 정보를 담고 있는 객체)를 얻어온다.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		//ㄴ클래스 파일(*.class)이 메모리에 올라갈 떄, 클래스 파일마다 Class객체가 하나씩 생성된다.
		Hello hello = (Hello)helloClass.newInstance(); //Class객체가 가진 정보로 객체 생성 newInstance반환타입이 Object라서 Hello클래스타입으로 형변환해줘야함
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true);//private인 main()을 호출 가능하게 한다.
		
		main.invoke(hello); //hello.main()호출하는 것과 동일
	}

}
