package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	
//	@RequestMapping(value= "/register/save", method={RequsetMethod.GET, RequestMethod.POST})//GET,POST��� ����Ѵ�.(Method�� �Ƚ��ָ�_GET)
//	@RequestMapping("/register/add")//�ű�ȸ�� ���� ȭ��
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";//WEB-INF/view/registerForm.jsp
//	}
	
//	@RequestMapping(value= "/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")//4.3����
	public String save(User user, Model m) throws Exception {
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
