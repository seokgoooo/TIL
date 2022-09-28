package a0x03;

import java.io.*;
import java.util.*;

//	두 수의 합 다국어
//	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//	1 초	128 MB	25359	8974	6870	35.469%

//	문제
//	n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다.
//	ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다.
//	자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.

//	입력
//	첫째 줄에 수열의 크기 n이 주어진다. 다음 줄에는 수열에 포함되는 수가 주어진다. 셋째 줄에는 x가 주어진다. (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)
//	출력
//	문제의 조건을 만족하는 쌍의 개수를 출력한다.

//	예제 입력 1 
//	9
//	5 12 7 10 9 1 2 3 11
//	13
//	예제 출력 1 
//	3

//	다시 풀자
//	오름차순 정렬 -> 투 포인터 활용
public class Q3273_Sum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		수열의 크기 n
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
//		수열에 포함되는 수
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}

//		오름차순 정렬
		Arrays.sort(arr);

//		ai + aj = x 자연수 x	( ai, aj ) 가 몇 세트?
		int x = Integer.parseInt(br.readLine());

		int count = 0;
		int start = 0;
		int end = n - 1;
		int sum = 0;

//		투 포인터 ( 양 끝에서 포인터를 좁혀가는 방법 )
		while (start < end) {
			sum = arr[start] + arr[end];
			if (sum == x) {
				count++;
			}

			if (sum <= x) {
				start++;
			} else {
				end--;
			}
		}

		System.out.println(count);
	}
}
//	반복문 밖에 생각을 못함
//	새로운 풀이 방법 배웠다
//0	1	2	3	4	5	6	7	8		
//5	12	7	10	9	1	2	3	11		
//	5	5	5	5	5	5	5	5		0
//		12	12	12	12					1
//			7	7	7	7	7	7		2
//				10	10	10	10			3
//					9	9	9	9		4
//						1	1	1		5
//							2	2		6
//								3		7
