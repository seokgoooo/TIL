package Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//  set : 집합 개념. 중복에 대해 집중하는 interface, index 번호 개념, 순서 개념이 없다.
//	HashSet의 객체가 같은지 판별 기준은 객체마다 가지고 있는 숫자값인 HashCode다.
//	객체를 add하고자 할 땐 hashCode() 메소드 재정의 해줘야 한다.
//	중복 판별 기준은 1차로 hashCode() 판별. 2차로 equals() 판별

public class HashSetMain {
	public static void main(String[] args) {
//		Hashset : 중복을 알아서 걸러준다
		HashSet set = new HashSet();
		boolean b1 = set.add("qwer");
		boolean b2 = set.add(Integer.valueOf(10));
		boolean b3 = set.add("qwer");

		System.out.println(set.size());
		System.out.println(set.toString());

//		for each 출력법
//		for (Object o : set) {
//			System.out.println(o);
//		}
//	
//		iterator 출력법
//		Iterator<Object> iter = set.iterator();
//		while (iter.hasNext())
//			System.out.println(iter.next());

		System.out.println("-----------------------------------------------------------------");
//		문자열 Set
		Set<String> setString = new HashSet<>();
		setString.add("apple");
		setString.add("banana");
		setString.add("carrot");
		setString.add("banana");

		System.out.println(setString.size());

		Iterator<String> iterString = setString.iterator();
		while (iterString.hasNext())
			System.out.println(iterString.next());

		System.out.println(setString.contains("banana"));
		System.out.println(setString.contains("donut"));

		System.out.println("-----------------------------------------------------------------");
//		Hashset의 생성자 활용
		List<String> list = new ArrayList<>(Arrays.asList("가", "나", "다", "라", "마", "가", "라"));
		Set<String> setList = new HashSet<>(list);

//		반복문에 add 하는 방법이 있지만 HashSet 생성자에 넣어도 똑같이 된다.
//		for (int i = 0; i < list.size(); i++)
//			setList.add(list.get(i));

		System.out.println(setList);

		System.out.println("-----------------------------------------------------------------");
//		합집함
		Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> setB = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));

		Set<Integer> setUnion = new HashSet<>();
		setUnion.addAll(setA);
		setUnion.addAll(setB);
		System.out.println(setUnion);

		System.out.println("-----------------------------------------------------------------");
//		교집합 : retainAll, 중복되는 원소만 남기고 지워준다.
		Set<Integer> setDuplicate = new HashSet<>();
		setDuplicate.addAll(setA);
		setDuplicate.retainAll(setB);
		System.out.println(setDuplicate);

		System.out.println("-----------------------------------------------------------------");
//		차집합 : removeAll, 합집합에서 교집합을 빼고 only 한 집합에만 있는 원소 구할 때  
		Set<Integer> setLeft = new HashSet<>();
		setLeft.addAll(setA);
		setLeft.removeAll(setB);
		System.out.println(setLeft);

		System.out.println("-----------------------------------------------------------------");
//		equals로 원소가 다 있는지 확인
		Set<Integer> setSame = new HashSet<>(Arrays.asList(7, 6, 5, 4, 3, 2, 1));
		System.out.println(setSame.equals(setUnion));
		
		System.out.println("-----------------------------------------------------------------");
		
	}
}