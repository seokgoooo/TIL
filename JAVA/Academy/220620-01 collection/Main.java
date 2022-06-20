import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("문자열 객체");
		list.add(new Object());
		list.add(Integer.valueOf(100));
		list.add(Double.valueOf(55.55));

		list.add(500); // auto-boxing
		list.add(123.123);

		int size = list.size();
		System.out.println(size);

		System.out.println(list.get(0));
		System.out.println(list.get(2));
		System.out.println(list.get(3));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.println(list.get(i));
		}

		for (Object o : list)
			System.out.println(o);

		// 총합 구하기
		ArrayList<Integer> listSum = new ArrayList<Integer>();
		listSum.add(10);
		listSum.add(20);
		listSum.add(30);
		listSum.add(40);

		int sumList = 0;
		for (int i = 0; i < listSum.size(); i++) {
			sumList += listSum.get(i);
		}
		System.out.println(sumList);

		// 메소드 활용
		List<Integer> listMethod = new ArrayList<>();

		for (int i = 1; i <= 4; i++) {
			listMethod.add(i * 10);
		}

		for (Object o : listMethod) {
			System.out.println(o);
		}

		listMethod.set(1, 15);
		System.out.println(listMethod.toString());

		System.out.println(listMethod.contains(20));
		System.out.println(listMethod.indexOf(20));

		listMethod.remove(2);
		System.out.println(listMethod);

		listMethod.add(0, 0);
		System.out.println(listMethod);

		listMethod.clear();

		// remove(index) 시 index 번호와 size 가 계속 바뀌기 때문에 주의

		System.out.println(listMethod.size() == 0);
		System.out.println(listMethod.isEmpty());

		// 문자열 배열과 Iterator 사용법
		List<String> listString = new ArrayList<>();

		listString.add("apple");
		listString.add("banana");
		listString.add("carrot");
		listString.add("donut");

		// 순환 중에 원소 삭제시 Iterator
		// for / for-each / 같이 반복
		Iterator<String> iterator = listString.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			if (str.length() == 5) {
				iterator.remove();
			}
		}
		System.out.println(listString);

		// Arrays.asList 와 subList
		List<Integer> listAsList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
		System.out.println(listAsList);

		// Arrays.asList 는 원소 추가 . 삭제가 안 된다
		List<Integer> test = Arrays.asList(10, 20, 30, 40, 50);
//		test.add(60);
		
		listAsList.addAll(Arrays.asList(60, 70, 80));
		System.out.println(listAsList);
		
		listAsList.removeAll(Arrays.asList(30, 40, 50));
		System.out.println(listAsList);
		
		System.out.println(listAsList.containsAll(Arrays.asList(10, 20)));
		
		List<Integer> subAsList = listAsList.subList(0, 3);
		System.out.println(subAsList);
		System.out.println(listAsList);

	}
}