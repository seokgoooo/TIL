package kr.co.greenart.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.greenart.model.User;
import kr.co.greenart.model.UserService;
import kr.co.greenart.model.UserValidator;

@Controller
public class UserController {
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserValidator validator;

	@Autowired
	private UserService service;

//	@GetMapping("/user")
//	public String userForm(Model model) {
//		model.addAttribute("user", new User("기본값", 1));
//		return "userForm";
//	}
//	위의 문장을 아래 문장으로 대체 가능

	@ModelAttribute("user")
	public User user() {
		return new User("기본값", 1);
	}

	@GetMapping("/user")
	public String userForm(@ModelAttribute("user") User user) {
		return "userForm";
	}

	@PostMapping("/user")
	public String submit(@ModelAttribute("user") @Valid User user, BindingResult errors) {
		logger.info("입력 정보: " + user.toString());

//		validator.validate(user, errors);

		if (errors.hasErrors()) {
			return "userForm";
		}

		service.add(user);

		return "redirect:/user/list";
	}

	@GetMapping("/user/list")
	public String list(Model model) {
		model.addAttribute("list", service.list());
		return "userlist";
	}
}