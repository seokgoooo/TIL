package kr.co.greenart.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestModelSession {
	@GetMapping("/testModel")
	public @ResponseBody String testModel(Model model) {
		return new HashMap<>(model.asMap()).toString();
	}
}
