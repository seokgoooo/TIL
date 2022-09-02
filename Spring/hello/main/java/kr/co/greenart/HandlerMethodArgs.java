package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/handle")
public class HandlerMethodArgs {
	@GetMapping("/cookie")
	public @ResponseBody String args(@CookieValue(name = "JSESSIONID", defaultValue = "oraclejava") String jsessionid) {
		return jsessionid;
	}

	@GetMapping("/header")
	public @ResponseBody String head(@RequestHeader("Accept") String contentType) {
		return contentType;
	}

	@GetMapping("/{path1}/{path2}")
	public @ResponseBody String paths(@PathVariable String path1, @PathVariable String path2) {
		return path1 + path2;
	}
}