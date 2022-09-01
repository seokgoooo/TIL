package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// "/print" GET ��û -> text �Է� ���� (view)form.jsp���� foward
// form.jsp submit�� "/print" POST ��û -> �Է��� text �״�θ� �� �� �ִ� (view)print.jsp�� forward

@Controller
public class PrintController {
	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public String req() {
		return "form";
	}

	@RequestMapping(value = "/print", method = RequestMethod.POST)
	public String req(@RequestBody String text, Model model) {
		model.addAttribute("result", text);
		return "print";
	}
}
