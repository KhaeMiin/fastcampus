package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

//����ó���ϱ�
@Controller
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)//�����(Exception.class) �߻��� �� �޼��带 ȣ���ϰڴ�.(��Ʈ�ѷ����� ���ܰ� �߻��ϸ� �갡 �޴´�.)
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);//��ü�� �𵨿� ��Ƽ� ��� �����ϱ�
		return "error";//�� ��ȯ
	}
	@ExceptionHandler(Exception.class)//�����(Exception.class) �߻��� �� �޼��带 ȣ���ϰڴ�.(��Ʈ�ѷ����� ���ܰ� �߻��ϸ� �갡 �޴´�.)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//200 -> 500error
	public String catcher(Exception ex, Model m) {//FileNotFoundException�� ó���� �̼����� ������ �ְ������� Exception�� ȣ���
		System.out.println("m=" + m);
		System.out.println("catcher() in ExceptionController - Exception");
//		m.addAttribute("ex", ex);//��ü�� �𵨿� ��Ƽ� ��� �����ϱ�(error.jsp���Ͽ� isErrorPage="true"�� �س��� ������ ���� ���ؼ� ��ü�� �������� �ʾƵ� �ȴ�.
		return "error";//�� ��ȯ
	}
	
	//GlobalCatcher.java���� ���ܸ� ó���ϴ� �޼��尡 ������ �Ʒ� �޼��忡�� ����ó�� ȣ�� �� ����� �޼��尡 ���ܸ� ó����(���������� �ٸ� ���ܸ� ó���ϰ� ���� �� ����մϴ�)
	
	
	@RequestMapping("/ex")//URL���� view�̸��� ã�´�.
	public String main(Model m) throws Exception {//���� @ExceptionHandler��Model���� �ٸ� ��ü
		m.addAttribute("msg", "meddage from ExceptionController.main()");
		throw new Exception("���ܰ� �߻��߽��ϴ�.");
	}
	
	@RequestMapping("/ex2")//URL���� view�̸��� ã�´�.
	public String main2() throws Exception {
		throw new FileNotFoundException("���ܰ� �߻��߽��ϴ�.");
	}
}
