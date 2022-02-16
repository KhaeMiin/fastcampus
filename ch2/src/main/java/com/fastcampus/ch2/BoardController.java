package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		if(!loginCheck(request)) {//false일 경우(!느낌표는 false를 뜻하기도 한다-잘 안써서 계속 헷갈려하네)
			return "redirect:/login/login?toURL=" + request.getRequestURL();
		}
		return "boardList"; //true 즉 로그인 했으면 게시판으로
	}

	private boolean loginCheck(HttpServletRequest request) {
		//1.세션을 얻어서
		HttpSession session = request.getSession();
		//2. 세션에 id가 있는지 확인
//		if(session.getAttribute("id") != null) {
//			return true;
//		}else {
//			return false;
//		}
		//세션에 id가 있는지 확인, 있으면 trun반환
		return session.getAttribute("id") != null;//위에 조건문을 이렇게 간단하게 줄일 수 있다.
	}
	


}
