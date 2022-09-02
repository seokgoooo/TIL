package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// "/print" GET 요청 -> text 입력 가능 (view)form.jsp으로 foward
// form.jsp submit시 "/print" POST 요청 -> 입력한 text 그대로를 볼 수 있는 (view)print.jsp로 forward

@Controller
@RequestMapping(value = "/print")
public class PrintController {
//	value = "/print" 같은 값을 써줄 경우는 Controller 위에 써줘도 상관없다.
	@GetMapping
//	@RequestMapping(method = RequestMethod.GET) Spring 4.3 버전 이후부터는 더 줄여서 만들어놨다.
	public String printForm() {
		return "form";
	}

	@PostMapping
//	@RequestMapping(method = RequestMethod.POST)
	public String printView(@RequestParam String text, Model model) {

//		이렇게해도 안 된다 왜? why? 스프링에서 관리하는 Request에서 Encoding이 되지 않아서 그렇다.
//		자바에서 만든 인코딩필터를 사용하자
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}

		model.addAttribute("result", text);
		return "print";
	}

	@GetMapping("/sub")
	public @ResponseBody String sub() {
		return "/print/sub";
	}
}