package com.fastcampus.ch2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice//(��� ��Ű�� ����)��� ��Ʈ�ѷ����� �߻��ϴ� ���ܸ� ó���ϰ� ��
@ControllerAdvice("com.fastcampus.ch3")//(��ȣ�ȿ� �����ص� ��Ű���� ����)��� ��Ʈ�ѷ����� �߻��ϴ� ���ܸ� ó���ϰ� ��
public class GlobalCatcher {

	//���� ó���ϴ� �޼����
	
	@ExceptionHandler(NullPointerException.class)//�����(Exception.class) �߻��� �� �޼��带 ȣ���ϰڴ�.(��Ʈ�ѷ����� ���ܰ� �߻��ϸ� �갡 �޴´�.)
	public String catcher2(Exception ex, Model m) {
		System.out.println("catcher() in GlobalController - NullPointException");
		m.addAttribute("ex", ex);//��ü�� �𵨿� ��Ƽ� ��� �����ϱ�
		return "error";//�� ��ȯ
	}
	@ExceptionHandler(Exception.class)//�����(Exception.class) �߻��� �� �޼��带 ȣ���ϰڴ�.(��Ʈ�ѷ����� ���ܰ� �߻��ϸ� �갡 �޴´�.)
	public String catcher(Exception ex, Model m) {//FileNotFoundException�� ó���� �̼����� ������ �ְ������� Exception�� ȣ���
		System.out.println("catcher() in GlobalController - Exception");
		m.addAttribute("ex", ex);//��ü�� �𵨿� ��Ƽ� ��� �����ϱ�
		return "error";//�� ��ȯ
	}
}
