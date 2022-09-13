package kr.co.greenart.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
// @ExceptionHandler, @InitBinder, or @ModelAttribute ���
// Controller ������ ���ؼ� �ݺ������� �Ͼ�� �ϵ��� ������ �� �ִ� Component 
public class ErrorHandler {
	@ExceptionHandler(value = NullPointerException.class)
	public String nullExcep(Model model, NullPointerException ex) {
		model.addAttribute("error", "�������� ������ �߻��߽��ϴ�" + ex.getMessage());
		return "errorpage";
	}
}
