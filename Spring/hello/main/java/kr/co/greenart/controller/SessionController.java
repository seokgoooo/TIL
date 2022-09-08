package kr.co.greenart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "/session", produces = "text/plain; charset=utf-8")
@ResponseBody
@SessionAttributes("modelname")
// 	���� : Request << Model << Session
public class SessionController {
	@GetMapping("/add")
	public String addSessionValue(HttpSession session) {
		session.setAttribute("myname", "myvalue");
		return "���ǿ� �� ����";
	}

	@GetMapping("/check")
	public String getSessionValue(HttpSession session) {
		return (String) session.getAttribute("myname");
	}

	@GetMapping("/model")
	public String addModelValue(Model model) {
		model.addAttribute("modelname", "modelvalue");
		return "�𵨿� �� ����";
	}

	@GetMapping("/modelcheck")
	public String getModelValue(Model model) {
		return (String) model.getAttribute("modelname");
	}

	@GetMapping("/status")
	public String complete(SessionStatus status) {
		status.setComplete();
		return "���� ��Ʈ����Ʈ ������";
	}
}
