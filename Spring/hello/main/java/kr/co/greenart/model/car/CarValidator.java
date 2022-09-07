package kr.co.greenart.model.car;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CarValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Car.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "이름을 입력하세요");

		Car user = (Car) target;
		if (user.getModel().length() > 5) {
			errors.rejectValue("name", "name.toolong", "이름이 너무 깁니다");
		}

		if (user.getPrice() > 200) {
			errors.rejectValue("age", "age.tooold", "나이 범위를 초과했습니다");
		}
	}
}