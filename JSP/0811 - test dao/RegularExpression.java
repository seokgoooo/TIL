// Regular Expression

// - 특정한 규칙을 가진 문자열의 집합을 표현하는데 사용되는 언어. 텍스트 편집기나 스크립트 언어에서 문자열의 검색과 치환을 위해 지원하고 있다.
// regex : java의 정규 표현식을 사용해보자. 주로 Pattern Matcher 클래스를 사용한다.

// https://regexr.com/ 여기서 테스트하기 제일 좋다.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
	public static void main(String[] args) {
//		String에서 is만 찾아보는 방법
		String line = "This is a book.";
		Pattern p = Pattern.compile("is");
		Matcher m = p.matcher(line);

		// lookingAt = 시작하는 부분이 일치할 때 true
		System.out.println(m.lookingAt());

		// find 일치하면 true . start 일치하는 부분의 시작 index . end 끝나는 부분의 index + 1
		// 또 반복하면 그 다음에 있는 부분을 찾는다
		if (m.find()) {
			System.out.println(m.start());
			System.out.println(m.end());
		}

		if (m.find()) {
			System.out.println(m.start());
			System.out.println(m.end());
		}

		System.out.println("--------------------------------------------------------");

		String nLine = "1 He2llo. 3 Wor4ld! 5";
//		정규표현식의 형태 = [0-9]를 사용해서 숫자 범위를 표현해줄 수 있다. 안에 있는 숫자 바꾸면 범위가 바꿔진다.
		Pattern nP = Pattern.compile("[0-9]");
		Matcher nM = nP.matcher(nLine);

		nM.find();
		System.out.println(nM.start());

		nM.find();
		System.out.println(nM.start());

		nM.find();
		System.out.println(nM.start());

		nM.find();
		System.out.println(nM.start());

		nM.find();
		System.out.println(nM.start());

		System.out.println("--------------------------------------------------------");

		String nLine2 = "123 He234llo. 39 Wor48ld! 57";
//		정규표현식의 형태 = [0-9]{2} [] 옆에 {}를 사용해 숫자 자리수를 정해줄 수 있다. {2, 3}으로 2 ~ 3 자리수 이렇게 범위 지정도 가능
		Pattern nP2 = Pattern.compile("[0-9]{2,3}");
		Matcher nM2 = nP2.matcher(nLine2);

		nM2.find();
		System.out.println(nM2.start());
		System.out.println(nM2.end());

		nM2.find();
		System.out.println(nM2.start());
		System.out.println(nM2.end());

		nM2.find();
		System.out.println(nM2.start());
		System.out.println(nM2.end());

		nM2.find();
		System.out.println(nM2.start());
		System.out.println(nM2.end());

		nM2.find();
		System.out.println(nM2.start());
		System.out.println(nM2.end());

		System.out.println("--------------------------------------------------------");

		String sLine1 = "lowercase";
		String sLine2 = "UPPERCASE";
		String sLine3 = "1q2w3e";
//		정규표현식의 형태 = [a-z]를 통해 소문자 {9} 왼쪽에 있는 정규 표현식 범위의 길이값
		Pattern sP = Pattern.compile("[a-z]{9}");
		Matcher sM = sP.matcher(sLine1);
//		matches : 찾으면 true, 없으면 false
		System.out.println(sM.matches());

//		정규표현식의 형태 = [0-9a-z]를 통해 숫자와 소문자를 동시에 범위 설정해버리기
		Pattern sP2 = Pattern.compile("[0-9a-z]{6}");
		Matcher sM2 = sP2.matcher(sLine3);
		System.out.println(sM2.matches());

		System.out.println("--------------------------------------------------------");

//		아이디는 영소문자와 숫자로 이루어져야하고 최소 6글자 최대 10글자 (영문자로 시작해야합니다.)
		String idStr = "ddddddd";
		Pattern id = Pattern.compile("[a-z][0-9a-z]{5,9}");
		Matcher idM = id.matcher(idStr);
//		id는 영소문자와 숫자로 이루어지는가?
//		id는 6 ~ 10 글자 사이인가?
		if (idM.matches()) {
			System.out.println("유효한 id");
		} else {
			System.out.println("틀렸음");
		}

//		올바른 전화번호 (010-####-####)
		String idPhone = "010-0100-1111";
		Pattern idP = Pattern.compile("010-[0-9]{4}-[0-9]{4}");
		Matcher idMp = idP.matcher(idPhone);

		if (idMp.matches()) {
			System.out.println("유효한 전화번호");
		} else {
			System.out.println("틀림");
		}

		System.out.println("--------------------------------------------------------");
//		정규표현식의 줄임말
//		[a-zA-Z] = \\w (Java에서는 백슬러시 하나 더 써줘야함) 문자
//		[0-9] = \\d (Java에서는 백슬러시 하나 더 써줘야함) 숫자
//		\\s 공백
//		+ = {1, } 1글자 이상
//		? = 0 or 1
//		* = 0글자 이상
		String str = "010-0100-1111";
		Pattern strP = Pattern.compile("\\w+");
		Matcher strM = strP.matcher(str);

		System.out.println("--------------------------------------------------------");

		String test = "(abc, 123) | (de, 6) | (qwer, 15)";
//		Pattern testP = Pattern.compile("\\(\\w+,\\s?\\d+\\)");
//		(abc, 123) 여기서 abc || 123 등 원하는 값만 가지고 오고 싶으면 ( ) 괄호를 쳐서 Group을 만들어 주자 
		Pattern testP = Pattern.compile("\\((\\w+),\\s?(\\d+)\\)");
		Matcher testM = testP.matcher(test);

		while (testM.find()) {
//			System.out.println(testM.start());
//			System.out.println(testM.end());

			System.out.println(testM.group(1));
			System.out.println(testM.group(2));
		}
	}
}