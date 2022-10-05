package kr.co.greenart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;

	@GetMapping
	public String boardMain(Model model) {
		model.addAttribute("dto", service.getAll());
		return "board";
	}

	@GetMapping("/write")
	public String writeForm() {
		return "writeForm";
	}

	@PostMapping("/write")
	public String write(Article a) {
		service.write(a);
		return "redirect:/";
	}
}