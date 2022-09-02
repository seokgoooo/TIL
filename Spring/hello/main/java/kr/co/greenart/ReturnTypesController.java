package kr.co.greenart;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/returns")
public class ReturnTypesController {
	@GetMapping("/viewname")
	public String viewname() {
		return "hello";
	}

	@GetMapping("/respbody")
	public @ResponseBody String body() {
		return "body ����";
	}

//	parameter�� �������� �ְ� �޼ҵ� �ȿ��� �����ؼ� ����Ҽ��� �ִ�~~~
	@GetMapping("/mv")
	public ModelAndView mv(ModelAndView mv) {
		mv.addObject("result", "�𵨾غ� ��ü�� ����");
		mv.setViewName("plusresult");
		return mv;
	}

	@GetMapping("/respentity")
	public ResponseEntity<String> entity() {
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "text/plain; charset=utf-8").body("�ٵ� �����Դϴ�");

//		String body = "�ٵ� �����Դϴ�";
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "text/plain; charset=utf-8");
//		ResponseEntity<String> en = new ResponseEntity<String>(body, headers, HttpStatus.OK);
//		return en;
	}

	@GetMapping("/red")
	public String redirect() {
		return "redirect:/";
	}
}