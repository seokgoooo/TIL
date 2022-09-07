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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "�̸��� �Է��ϼ���");

		Car user = (Car) target;
		if (user.getModel().length() > 5) {
			errors.rejectValue("name", "name.toolong", "�̸��� �ʹ� ��ϴ�");
		}

		if (user.getPrice() > 200) {
			errors.rejectValue("age", "age.tooold", "���� ������ �ʰ��߽��ϴ�");
		}
	}
}