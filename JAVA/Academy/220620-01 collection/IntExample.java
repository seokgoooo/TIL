import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntExample {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(7, 3, 2, 8, 9, 1));
		
		Collections.sort(list);
		System.out.println(list);
		
		// binarySearch 는 이진검색. 선 정렬 후 사용하자
		int index = Collections.binarySearch(list, 0);
		System.out.println("0의 인덱스: " + index);
		
		Collections.reverse(list);
		System.out.println(list);
		
		Collections.shuffle(list);
		System.out.println(list);
		
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		
		// 값 전부 바꾸는 것
		Collections.fill(list, 33);
		System.out.println(list);
		
		// 원하는 값 찾아서 바꾸는 것
		Collections.replaceAll(list, 33, 77);
		System.out.println(list);
		
//		list.clear();
		// 배열 칸이 있어야 적용됨
		List<Integer> target = new ArrayList<>(Arrays.asList(90, 80, 70));
		Collections.copy(list, target);
		System.out.println(list);
	}
}