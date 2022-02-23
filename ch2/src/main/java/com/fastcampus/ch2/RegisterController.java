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
		//user.Class���� 	@DateTimeFormat(pattern = "yyyy-MM-dd")�� �ٿ��⶧���� �Ʒ� ���� ��������
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
	}
	
//	@RequestMapping(value= "/register/save", method={RequsetMethod.GET, RequestMethod.POST})//GET,POST��� ����Ѵ�.(Method�� �Ƚ��ָ�_GET)
//	@RequestMapping("/register/add")//�ű�ȸ�� ���� ȭ��
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";//WEB-INF/view/registerForm.jsp
//	}
	
//	@RequestMapping(value= "/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")//4.3����
	public String save(User user, BindingResult result, Model m) throws Exception {//BindingResult result: �츮�� ���ε��� ��ü �ٷ� �ڿ� �;���(��ġ����)
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		//1.��ȿ�� �˻�
		if(!isValue(user)) {
			String msg = URLEncoder.encode("id�� �߸� �Է��Ͽ����ϴ�", "utf-8");
			
			m.addAttribute("msg", msg);
			return "redirect:/register/add";//�Ʒ� return�� ������(�������� �ڵ����� �Ʒ��� ���� �ٲ���)
			
//			return "redirect:/register/add?msg=" + msg;//url���ۼ�
		}
		//2.DB�� �ű�ȸ�� ���� ����
		return "registerInfo";
	}

	//��ȿ�� �˻� �޼���
	private boolean isValue(User user) {
		
		return true;
	}

}
