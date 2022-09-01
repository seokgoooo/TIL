package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// "/print" GET 요청 -> text 입력 가능 (view)form.jsp으로 foward
// form.jsp submit시 "/print" POST 요청 -> 입력한 text 그대로를 볼 수 있는 (view)print.jsp로 forward

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
