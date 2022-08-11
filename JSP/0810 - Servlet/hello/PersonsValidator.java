package hello;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonsValidator {
//	정규표현식의 줄임말
//	[ㄱ-ㅎ][ㅏ-ㅣ][가-힣] = 한글 범위
//	[a-zA-Z] = \\w (Java에서는 백슬러시 하나 더 써줘야함) 문자
//	[0-9] = \\d (Java에서는 백슬러시 하나 더 써줘야함) 숫자
//	\\s 공백
//	+ = {1, } 1글자 이상
//	? = 0 or 1
//	* = 0글자 이상
// useful regex : 자주 쓰이는 타입 (email, ip 등등 은 이미 정규표현식이 만들어서 인터넷에 올라와있다.)

	// 이름, 성 10자
	public Map<String, String> isValidName(String name) {
		Map<String, String> map = new HashMap<String, String>();
		if (name != null) {
			int length = name.length();
			if (length == 0 || length > 10) {
				map.put("nameLength", "이름의 글자수는 1 ~ 10자 입니다.");
			}

			if (name.contains(" ")) {
				map.put("nameSpace", "이름에 공백을 포함할 수 없습니다.");
			}

			Pattern p = Pattern.compile("[a-zA-Z가-힣]+");
			Matcher m = p.matcher(name);

			if (!m.matches()) {
				map.put("nameChar", "이름은 한글 또는 영문자여야 합니다.");
			}
		} else {
			map.put("nameNull", "이름을 입력해주세요.");
		}
		return map;
	}

	// 나이 정수
	public Map<String, String> isValidAge(String age) {
		Map<String, String> map = new HashMap<String, String>();

		if (age != null) {
			Pattern p = Pattern.compile("\\d+");
			Matcher m = p.matcher(age);

			if (!m.matches()) {
				map.put("ageFormat", "나이는 숫자만 허용됩니다.");
			} else {
				try {
					int num = Integer.valueOf(age);
					if (num < 15 || num > 99) {
						map.put("ageRange", "나이의 범위는 15 - 99세입니다.");
					}
				} catch (NumberFormatException e) {
					map.put("ageRange", "나이의 범위는 15 - 99세입니다.");
				}
			}
		} else {
			map.put("ageNull", "나이를 입력해주세요.");
		}
		return map;
	}

	// 이메일 50자
	public Map<String, String> isValidEmail(String email) {
		Map<String, String> map = new HashMap<String, String>();
		if (email != null) {
			if (email.length() > 50) {
				map.put("emailLength", "이메일은 최대 50자 입니다.");
			}

			Pattern p = Pattern.compile("/^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\. [a-zA-Z0-9-]+)*$/.");
			Matcher m = p.matcher(email);

			if (!m.matches()) {
				map.put("emailFormat", "이메일 양식이 올바르지 않습니다.");
			}
		} else {
			map.put("emailNull", "이메일을 입력해주세요.");
		}
		return map;
	}
}
