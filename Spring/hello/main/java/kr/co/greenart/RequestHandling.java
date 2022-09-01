package kr.co.greenart;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestHandling {
	private final static Logger logger = LoggerFactory.getLogger(RequestHandling.class);

//	@RequestMapping(value = "/req", method = RequestMethod.GET)
//	public String req(HttpServletRequest request) {
//		String param = request.getParameter("param");
//		String param2 = request.getParameter("param2");
//		logger.info(param);
//		logger.info(param2);
//
//		return "뷰이름";
//	}

//	위의 과정을 아래처럼 바로 바로 parameter로 받아서 간단하게 만들어줄 수 있다.
	@RequestMapping(value = "/req", method = RequestMethod.GET)
	public String req(@RequestParam int param, @RequestParam int param2, Model model) {
		logger.info(String.valueOf(param + param2));
		model.addAttribute("result", param + param2);
		return "plusresult";
	}
}