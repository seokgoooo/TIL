package Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class LinkedHashSetMain {
	public static void main(String[] args) {
// HashSet은 순서가 없는 class. 순서가 있는 class는 LinkedHashSet (하지만 index는 없다. only 순서 기억)
		Set<String> set = new LinkedHashSet<>();
		set.add("banana");
		set.add("carrot");
		set.add("apple");
		set.add("apple");
		System.out.println(set);

		System.out.println("-----------------------------------------------------------");
//		LinkedHashSet과 HashSet 어떤 class에 addAll을 하냐에 따라 결과가 달라진다.
		Set<String> set2 = new HashSet<>(Arrays.asList("apple", "donut", "egg", "fanta"));
		set.addAll(set2);
		System.out.println("set, LinkedHashSet");
		System.out.println(set);

		System.out.println("set2, HashSet");
		set2.addAll(set);
		System.out.println(set2);
		
		System.out.println("-----------------------------------------------------------");
//		TreeSet : 나무가지처럼 큰지 작은지 판단해서 원소를 추가하기 때문에 TreeSet. 크기대로 정렬해준다 String 은 알파벳 순
		Set<Integer> setTree = new TreeSet<>();
		setTree.add(50);
		setTree.add(17);
		setTree.add(2);
		setTree.add(50);
		setTree.add(22);
		setTree.add(17);
		setTree.add(30);
		
		System.out.println(setTree);
	}
}
