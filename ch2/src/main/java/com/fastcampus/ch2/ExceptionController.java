package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

//예외처리하기
@Controller
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)//어떤예외(Exception.class) 발생시 이 메서드를 호출하겠다.(컨트롤러에서 예외가 발생하면 얘가 받는다.)
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);//객체를 모델에 담아서 뷰로 전달하기
		return "error";//뷰 반환
	}
	@ExceptionHandler(Exception.class)//어떤예외(Exception.class) 발생시 이 메서드를 호출하겠다.(컨트롤러에서 예외가 발생하면 얘가 받는다.)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//200 -> 500error
	public String catcher(Exception ex, Model m) {//FileNotFoundException를 처리할 이셉션이 없으면 최고조상인 Exception이 호출됨
		System.out.println("m=" + m);
		System.out.println("catcher() in ExceptionController - Exception");
//		m.addAttribute("ex", ex);//객체를 모델에 담아서 뷰로 전달하기(error.jsp파일에 isErrorPage="true"를 해놨기 때문에 모델을 통해서 객체를 전달하지 않아도 된다.
		return "error";//뷰 반환
	}
	
	//GlobalCatcher.java에도 예외를 처리하는 메서드가 있지만 아래 메서드에서 예외처리 호출 시 가까운 메서드가 예외를 처리함(개별적으로 다른 예외를 처리하고 싶을 때 사용합니다)
	
	
	@RequestMapping("/ex")//URL에서 view이름을 찾는다.
	public String main(Model m) throws Exception {//위에 @ExceptionHandler의Model과는 다른 객체
		m.addAttribute("msg", "meddage from ExceptionController.main()");
		throw new Exception("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex2")//URL에서 view이름을 찾는다.
	public String main2() throws Exception {
		throw new FileNotFoundException("예외가 발생했습니다.");
	}
}
