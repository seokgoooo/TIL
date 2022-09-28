package a0x03;

import java.io.*;

//	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//	2 초	256 MB	6663	2786	2172	40.454%
//	문제
//	strfry 함수는 입력된 문자열을 무작위로 재배열하여 새로운 문자열을 만들어낸다. (역자 주 : 여기에서 입력된 문자열과 새로 재배열된 문자열이 다를 필요는 없다.)
//	두 개의 문자열에 대해, 2번째 문자열이 1번째 문자열에 strfry 함수를 적용하여 얻어질 수 있는지 판단하라.
//
//	입력
//	입력의 첫 번째 줄은 테스트 케이스의 수 0 < N < 1001 이다.
//	각각의 테스트 케이스는 하나의 줄에 영어 소문자들로만 이루어진 두 개의 문자열이 한 개의 공백으로 구분되어 주어진다. 각각의 문자열의 길이는 최대 1000 이다.
//	출력
//	각각의 테스트 케이스에 대해, 2번째 문자열이 1번째 문자열에 strfry 함수를 적용하여 얻어질 수 있는지의 여부를 "Impossible"(불가능) 또는 "Possible"(가능)으로 나타내시오. (따옴표는 제외하고 출력한다.)
//
//	예제 입력 1 
//	4
//	a a
//	ab ba
//	ring gnir
//	newt twan
//	예제 출력 1 
//	Possible
//	Possible
//	Possible
//	Impossible

public class Q11328_Strfry {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());

		for (int i = 0; i < count; i++) {
			String[] input = br.readLine().split(" ");
			String first = input[0];
			String second = input[1];

//			각 문자의 개수를 저장하는 배열
			int[] alpha = new int[26];
			boolean isPossible = true;

//			첫 번째 문자열의 각 문자는 개수 +1
			for (int j = 0; j < first.length(); j++) {
				alpha[first.charAt(j) - 'a']++;
			}

//			두 번째 문자열의 각 문자는 개수 -1
			for (int j = 0; j < second.length(); j++) {
				alpha[second.charAt(j) - 'a']--;
			}

//			중간에 0이 아닌 값이 있으면 다른 문자가 존재하기 때문에 false
			for (int j : alpha) {
				if (j != 0) {
					isPossible = false;
				}
			}

			if (isPossible) {
				bw.write("Possible");
			} else {
				bw.write("Impossible");
			}
			bw.write("\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
