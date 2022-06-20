import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomList {
	public static void main(String[] args) {
		List<Integer> twoList = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			twoList.add(i * 2);
		}
		System.out.println(twoList);

		List<Integer> sevenList = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			sevenList.add(i * 7);
		}
		System.out.println(sevenList);

		List<Integer> twoSevenList = new ArrayList();
		twoSevenList.addAll(twoList);
		twoSevenList.addAll(sevenList);
		System.out.println(twoSevenList);

		List<Integer> sortList = new ArrayList<>();
		sortList.addAll(twoSevenList);
		Collections.sort(sortList);
		System.out.println(sortList);
		
		// 중복 제거한 0 ~ 10 까지의 6가지 정수 뽑기
		List<Integer> randomList = new ArrayList<>();
		Random ran = new Random();

		while (randomList.size() < 6) {
			int result = ran.nextInt(11);
			if (!randomList.contains(result)) {
				randomList.add(result);
			}
		}
		System.out.println(randomList);
	}
}