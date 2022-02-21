package com.fastcampus.ch2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice//(모든 패키지 적용)모든 컨트롤러에서 발생하는 예외를 처리하게 됨
@ControllerAdvice("com.fastcampus.ch3")//(괄호안에 지정해둔 패키지만 적용)모든 컨트롤러에서 발생하는 예외를 처리하게 됨
public class GlobalCatcher {

	//예외 처리하는 메서드들
	
	@ExceptionHandler(NullPointerException.class)//어떤예외(Exception.class) 발생시 이 메서드를 호출하겠다.(컨트롤러에서 예외가 발생하면 얘가 받는다.)
	public String catcher2(Exception ex, Model m) {
		System.out.println("catcher() in GlobalController - NullPointException");
		m.addAttribute("ex", ex);//객체를 모델에 담아서 뷰로 전달하기
		return "error";//뷰 반환
	}
	@ExceptionHandler(Exception.class)//어떤예외(Exception.class) 발생시 이 메서드를 호출하겠다.(컨트롤러에서 예외가 발생하면 얘가 받는다.)
	public String catcher(Exception ex, Model m) {//FileNotFoundException를 처리할 이셉션이 없으면 최고조상인 Exception이 호출됨
		System.out.println("catcher() in GlobalController - Exception");
		m.addAttribute("ex", ex);//객체를 모델에 담아서 뷰로 전달하기
		return "error";//뷰 반환
	}
}
