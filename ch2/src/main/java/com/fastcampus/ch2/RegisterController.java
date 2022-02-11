package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	
//	@RequestMapping(value= "/register/save", method={RequsetMethod.GET, RequestMethod.POST})//GET,POST모두 허용한다.(Method를 안써주면_GET)
//	@RequestMapping("/register/add")//신규회원 가입 화면
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";//WEB-INF/view/registerForm.jsp
//	}
	
//	@RequestMapping(value= "/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")//4.3부터
	public String save(User user, Model m) throws Exception {
		//1.유효성 검사
		if(!isValue(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하였습니다", "utf-8");
			
			m.addAttribute("msg", msg);
			return "redirect:/register/add";//아래 return과 동일함(스프링이 자동으로 아래와 같이 바꿔줌)
			
//			return "redirect:/register/add?msg=" + msg;//url재작성
		}
		//2.DB에 신규회원 정보 저장
		return "registerInfo";
	}

	//유효성 검사 메서드
	private boolean isValue(User user) {
		
		return true;
	}

}
