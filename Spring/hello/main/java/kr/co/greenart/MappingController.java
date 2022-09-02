package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mapping")
public class MappingController {
//	Filter가 안먹는건 ResponseBody에 설정을 안해줘서 그렇다. 원래라면 HttpServletResponse parameter 넣어서
//	거기다가 text/plain; charset=utf-8 해줘야 하는데 Spring은 그냥 밑에처럼 쓰면 된다.
	@GetMapping(value = "/??.two", produces = "text/plain; charset=utf-8")
	public @ResponseBody String two() {
		return "두글자 매핑";
	}

	@GetMapping("/*.do")
	public @ResponseBody String doURI() {
		return "do로 끝나는 매핑";
	}

	@GetMapping(value = "/ppp", params = "com")
	public @ResponseBody String ppp(@RequestParam(defaultValue = "deafult") String com) {
		return com;
	}
}