package kr.co.greenart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/flash")
// 	���� : Request << Model << Session
public class FlashAttributeController {

	@GetMapping("/1")
	public String forward(Model model) {
		model.addAttribute("fowardtest", "������ �׽�Ʈ");
		return "flashview";
	}

	@GetMapping("/2")
	public String view() {
		return "flashview";
	}

	@GetMapping("/3")
	public String redirect(Model model) {
		model.addAttribute("redirecttest", "�����̷�Ʈ �׽�Ʈ");
		return "redirect:2";
	}

	@GetMapping("/4")
	public String flash(RedirectAttributes ra) {
		ra.addFlashAttribute("redirecttest", "�÷��� ��Ʈ����Ʈ�� �𵨰�");
		return "redirect:2";
	}
}