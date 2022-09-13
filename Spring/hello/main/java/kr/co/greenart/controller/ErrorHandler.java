package kr.co.greenart.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
// @ExceptionHandler, @InitBinder, or @ModelAttribute 등등
// Controller 전역에 대해서 반복적으로 일어나는 일들을 정의할 수 있는 Component 
public class ErrorHandler {
	@ExceptionHandler(value = NullPointerException.class)
	public String nullExcep(Model model, NullPointerException ex) {
		model.addAttribute("error", "서버에서 오류가 발생했습니다" + ex.getMessage());
		return "errorpage";
	}
}
