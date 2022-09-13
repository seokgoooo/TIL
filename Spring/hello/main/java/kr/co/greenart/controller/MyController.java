package kr.co.greenart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);

	@GetMapping
	public String myView() {
		logger.info("������� ��û�� �α��մϴ�");
		return "myview";
	}

	@GetMapping("/{var}")
	public String myPathVar(@PathVariable String var) {
		logger.info("������� ��û�� �α��մϴ�");
		return "myview";
	}

	@GetMapping("/burn")
	public String burnAttr(HttpSession session) {
		logger.info("������� ��û�� �α��մϴ�");
		session.setAttribute("burn", "�а� �����Ͻÿ�");
		return "myview";
	}

	@GetMapping("/null")
	public String nullExcep() {
		throw new NullPointerException("���Ƿ� �߻���Ų �� ����");
	}
}