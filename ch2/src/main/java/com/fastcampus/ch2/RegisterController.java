package com.fastcampus.ch2;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
		System.out.println("conversionService = " + conversionService);
		//user.Class에서 	@DateTimeFormat(pattern = "yyyy-MM-dd")를 붙였기때문에 아래 두줄 생략가능
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));//false: 빈 값을 허용할 것인지
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
//		binder.setValidator(new UserValidator());//UserValidator를 WebDataBinder의 로컬 validator로 등록
//		binder.addValidators(new UserValidator());//UserValidator를 WebDataBinder의 로컬 validator로 등록
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList = " + validatorList);
	}
	
//	@RequestMapping(value= "/register/save", method={RequsetMethod.GET, RequestMethod.POST})//GET,POST모두 허용한다.(Method를 안써주면_GET)
//	@RequestMapping("/register/add")//신규회원 가입 화면
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";//WEB-INF/view/registerForm.jsp
//	}
	
//	@RequestMapping(value= "/save", method=RequestMethod.POST)
	@PostMapping("/save")//4.3부터
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {//BindingResult result: 우리가 바인딩할 객체 바로 뒤에 와야함(위치조심)
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		
		//수동 검증 - Validator를 직접 생성하고, validator()를 직접호출
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result); //BindingResult는 Error의 자손
		
		//User객체를 검증한 결과 에러가 있으면, registerForm을 이용해서 에러를 보여줘야함.
		if(result.hasErrors()) {
			return "registerForm";
		}
		
//		//1.유효성 검사
//		if(!isValue(user)) {
//			String msg = URLEncoder.encode("id를 잘못 입력하였습니다", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			return "redirect:/register/add";//아래 return과 동일함(스프링이 자동으로 아래와 같이 바꿔줌)
//			
////			return "redirect:/register/add?msg=" + msg;//url재작성
//		}
		//2.DB에 신규회원 정보 저장
		return "registerInfo";
	}

	//유효성 검사 메서드
	private boolean isValue(User user) {
		
		return true;
	}

}
