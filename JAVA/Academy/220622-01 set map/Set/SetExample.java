package Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SetExample {
	public static void main(String[] args) {
//		중복되지 않는 1 ~ 45 사이의 정수 6개를 가지는 집합
		Random ran = new Random();
		Set<Integer> lotto = new HashSet<Integer>();
		
		while (lotto.size() < 6) {
			lotto.add(ran.nextInt(45) + 1);
		}
		System.out.println(lotto);
		
		List<Integer> list = new ArrayList<>(lotto);
		Collections.sort(list);
		System.out.println(list);
	}
}