package com.fastcampus.ch2;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		//user.Class에서 	@DateTimeFormat(pattern = "yyyy-MM-dd")를 붙였기때문에 아래 두줄 생략가능
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
	}
	
//	@RequestMapping(value= "/register/save", method={RequsetMethod.GET, RequestMethod.POST})//GET,POST모두 허용한다.(Method를 안써주면_GET)
//	@RequestMapping("/register/add")//신규회원 가입 화면
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";//WEB-INF/view/registerForm.jsp
//	}
	
//	@RequestMapping(value= "/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")//4.3부터
	public String save(User user, BindingResult result, Model m) throws Exception {//BindingResult result: 우리가 바인딩할 객체 바로 뒤에 와야함(위치조심)
		System.out.println("result = " + result);
		System.out.println("user = " + user);
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
