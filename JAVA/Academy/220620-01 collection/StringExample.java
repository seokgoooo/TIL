import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StringExample {
	public static boolean isNumberChar(char c) {
		return c >= '0' && c <= '9';
	}
	
	public static boolean isNumberStr(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!isNumberChar(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "carrot", "donut", "egg"));
				
		List<String> listFive = new ArrayList<>();
		// 위의 리스트에서 문자열 길이가 5글자인 문자열만을 원소로 가지는 리스트 생성
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() == 5)
				listFive.add(list.get(i));
		}
		System.out.println(listFive);

//		위의 리스트에서 문자열 길이가 5글자인 문자열만을 원소로 가지는 리스트 생성
//		복사부터하고 삭제하는 방법
		List<String> copy = new ArrayList<>(list);
		Iterator<String> iterator = copy.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			if (str.length() != 5) {
				iterator.remove();
			}
		}
		System.out.println(copy);

		List<String> listE = new ArrayList<>();
		// 문자열 중에 'e' 문자를 포함하는 문자열만을 원소로 가지는 리스트 생성
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains("e"))
				listE.add(list.get(i));
		}
		System.out.println(listE);

		List<String> list2 = new ArrayList<>(Arrays.asList("가", "1", "@", "3", "나"));
		// 위의 2번 리스트에서 '정수 형태의 값'을 가지는 문자열을 찾아
		// 해당 원소를 가지는 정수형 리스트 생성
		List<Integer> list2Int = new ArrayList<>();

		for (int i = 0; i < list2.size(); i++) {
			String str = list2.get(i);

			// 메소드 만들어서 아스키코드 처리법
			// 아스키코드는 10 이상 넘어가면 1, 0 따로 따로 계산해줘야한다.
			if (isNumberStr(str)) {
				list2Int.add(Integer.valueOf(str));
			}
			
			// try-catch로 예외처리
			// 예외처리도 반복문 안에 해주면 실행흐름 마다 처리를 해줄 수 있다.
//			try {
//				Integer value = Integer.valueOf(str);
//				list2Int.add(value);
//			} catch (NumberFormatException e) {
//				System.out.println("문자열을 정수형으로 변환하는데 실패하여 예외가 발생했으나 정상흐름으로 돌아가기를 원해 예외처리를 하였습니다.");
//			}
		}
		System.out.println(list2Int);

//		내 생각대로 한 방법 charAt
//		for (int i = 0; i < list2.size(); i++) {			
//			if (Integer.valueOf(list2.get(i).charAt(0)) < 60)
//				list2Int.add(Integer.valueOf(list2.get(i)));
//		}

		System.out.println(list2Int);

		// '정수 형태의 값'을 가지는 문자열을 -> Integer 형으로
//		Integer i = Integer.valueOf("1234"); // => 1234 Integer 반환
//		Integer exp = Integer.valueOf("숫자아니면?"); // => NumberFormatException 예외 발생
	}
}