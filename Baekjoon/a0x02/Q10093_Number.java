package a0x02;

import java.util.*;

//문제
//두 양의 정수가 주어졌을 때, 두 수 사이에 있는 정수를 모두 출력하는 프로그램을 작성하시오.
//입력
//두 정수 A와 B가 주어진다.
//
//출력
//첫째 줄에 두 수 사이에 있는 수의 개수를 출력한다.
//둘째 줄에는 두 수 사이에 있는 수를 오름차순으로 출력한다.

public class Q10093_Number {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		long start = sc.nextLong();
		long end = sc.nextLong();

		if (start > end) {
			long temp = end;
			end = start;
			start = temp;
		}

		if (start == end) {
			System.out.println(0);
		} else {
			System.out.println(end - start - 1);
			start++;
			for (; start < end; start++) {
				System.out.print(start + " ");
			}
		}
	}
}