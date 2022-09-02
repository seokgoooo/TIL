package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mapping")
public class MappingController {
//	Filter�� �ȸԴ°� ResponseBody�� ������ �����༭ �׷���. ������� HttpServletResponse parameter �־
//	�ű�ٰ� text/plain; charset=utf-8 ����� �ϴµ� Spring�� �׳� �ؿ�ó�� ���� �ȴ�.
	@GetMapping(value = "/??.two", produces = "text/plain; charset=utf-8")
	public @ResponseBody String two() {
		return "�α��� ����";
	}

	@GetMapping("/*.do")
	public @ResponseBody String doURI() {
		return "do�� ������ ����";
	}

	@GetMapping(value = "/ppp", params = "com")
	public @ResponseBody String ppp(@RequestParam(defaultValue = "deafult") String com) {
		return com;
	}
}