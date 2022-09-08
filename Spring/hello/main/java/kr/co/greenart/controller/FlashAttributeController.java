package kr.co.greenart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flash")
// 	범위 : Request << Model << Session
public class FlashAttributeController {

	@GetMapping("/1")
	public String forward(Model model) {
		model.addAttribute("fowardtest", "포워드 테스트");
		return "flashview";
	}

	@GetMapping("/2")
	public String view() {
		return "flashview";
	}

	@GetMapping("/3")
	public String redirect(Model model) {
		model.addAttribute("redirecttest", "리다이렉트 테스트");
		return "redirect:2";
	}
}