package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST)// 500 -> 400
class MyException extends RuntimeException {
	//생성자
	MyException(String msg) {
		super(msg);
	}
	
	//기본생성자
	MyException() { this(""); }
}

//예외처리하기
@Controller
public class ExceptionController2 {
	
	//GlobalCatcher.java가 예외처리함
	
	@RequestMapping("/ex3")//URL에서 view이름을 찾는다.
	public String main() throws Exception {
			throw new MyException("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex4")//URL에서 view이름을 찾는다.
	public String main2() throws Exception {
			throw new NullPointerException("예외가 발생했습니다.");
	}
}
