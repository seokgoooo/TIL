package a0x04;

import java.io.*;
import java.util.*;

//	요세푸스 문제

//	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//	2 초	256 MB	74360	36482	25795	48.151%

//	문제
//	요세푸스 문제는 다음과 같다.
//	1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
//	이제 순서대로 K번째 사람을 제거한다.
//	한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
//	이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
//	원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
//	예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
//	N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

//	입력
//	첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)
//	출력
//	예제와 같이 요세푸스 순열을 출력한다.

//	예제 입력 1 
//	7 3
//	예제 출력 1 
//	<3, 6, 2, 7, 5, 1, 4>
public class Q1158_Josephus {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		System.out.print("<");

		while (!list.isEmpty()) {
			for (int i = 0; i < K; i++) {
				if (i == K - 1) {
					int result = list.remove();
					if (list.size() == 0) {
						System.out.print(result);
					} else {
						System.out.print(result + ", ");
					}
				} else {
					list.add(list.remove());
				}
			}
		}

		System.out.print(">");
//		내 생각 : ListIterator를 이용해서 커서 이용 근데 안 풀림 
//		ListIterator<Integer> iter = list.listIterator();
//		List<Integer> result = new LinkedList<>();
//
//		int temp = 1;
//		while (result.size() < N) {
//			if (iter.nextIndex() == list.size()) {
//				while (iter.hasPrevious()) {
//					iter.previous();
//				}
//			}
//
//			if (temp % K == 0) {
//				result.add(iter.next());
//				iter.remove();
//			}
//
//			if (iter.hasNext())
//				iter.next();
//
//			temp++;
//		}
//		
//		for (int i = 0; i < result.size(); i++) {
//			System.out.print(result.get(i) + " ");
//		}

		br.close();
	}
}