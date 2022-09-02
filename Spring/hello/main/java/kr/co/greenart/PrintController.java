package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// "/print" GET ��û -> text �Է� ���� (view)form.jsp���� foward
// form.jsp submit�� "/print" POST ��û -> �Է��� text �״�θ� �� �� �ִ� (view)print.jsp�� forward

@Controller
@RequestMapping(value = "/print")
public class PrintController {
//	value = "/print" ���� ���� ���� ���� Controller ���� ���൵ �������.
	@GetMapping
//	@RequestMapping(method = RequestMethod.GET) Spring 4.3 ���� ���ĺ��ʹ� �� �ٿ��� ��������.
	public String printForm() {
		return "form";
	}

	@PostMapping
//	@RequestMapping(method = RequestMethod.POST)
	public String printView(@RequestParam String text, Model model) {

//		�̷����ص� �� �ȴ� ��? why? ���������� �����ϴ� Request���� Encoding�� ���� �ʾƼ� �׷���.
//		�ڹٿ��� ���� ���ڵ����͸� �������
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