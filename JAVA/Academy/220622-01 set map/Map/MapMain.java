package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// map : 사전과 같은 자료구조. key - 단어, value - 단어에 대한 설명. key value 가 짝을 이루어 자료구조를 이룬다.
// map은 중복된 키를 가질 수 없다. 각 키는 only 하나의 value만 가질 수 있다.
// HashMap TreeMap LinkedHashMap 3가지 class
// 없는 key를 get하면 null이 return. 같은 key에 put을 새로 하면 value가 새로운 값으로 바뀐다.
public class MapMain {
	public static void main(String[] args) {
		HashMap map = new HashMap<>();
		map.put("일", 1);
		map.put("이", 2);
		map.put("삼", 3);
		map.put("사", 4);

		System.out.println(map.size());

		System.out.println(map.get("이"));
		System.out.println(map.get("삼"));
		System.out.println(map.get("오"));

		System.out.println(map.containsKey("이"));
		if (!map.containsKey("이")) {
			map.put("이", 2222);
		}
		System.out.println(map.get("이"));

		System.out.println("------------------------------------------------------");
//		map의 key 값을 알면 원하는 value를 찾을 수 있다. map의 keySet는 map의 전체 key값을 Set으로 return하는 메소드
//		Set은 Iterator에 넣을 수 있다. for-each로도 가능하다.
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("둘리", 100);
		map2.put("홍길동", 90);
		map2.put("도우너", 150);

		Set<String> keySet = map2.keySet();
		System.out.println(keySet);

		for (String key : keySet)
			System.out.println(key + "=" + map2.get(key));

		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Integer value = map2.get(key);
			System.out.println(key + "=" + value);
		}

		System.out.println("------------------------------------------------------");
//		entrySet key와 매칭된 value 값을 Set으로 return
//		Entry : key - value를 묶어서 사용하는 interface (다른 언어에서는 pair라고도 함)
		Set<Entry<String, Integer>> entrySet = map2.entrySet();
		for (Entry<String, Integer> e : entrySet) {
			System.out.println(e.getKey() + e.getValue());
		}
		System.out.println(entrySet);
	}
}