package a0x03;

import java.io.*;
import java.util.*;

//	방 번호
//	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//	2 초	128 MB	47761	21794	15720	44.300%

//	문제
//	다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.
//	다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다.
//	다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)

//	입력
//	첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수이다.
//	출력
//	첫째 줄에 필요한 세트의 개수를 출력한다.

//예제 입력 1		예제 출력 1 
//9999			2
//예제 입력 2		예제 출력 2 
//122			2
//예제 입력 3		예제 출력 3 
//12635			1
//예제 입력 4		예제 출력 4 
//888888		6 

// 다시 풀어보자
// 그냥 숫자 수를 세면 된다 ㅡㅡ;.. 6 = 9 같게 두고 일일히 반복문을 돌릴 필요가 없음
public class Q1475_RoomNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int[] numberSet = new int[10];

		for (char c : N.toCharArray()) {
//			char 를 int 로 변환시키려면 아스키코드 값으로 변환이 된다. 그래서 아스키코드 값 48인 '0'을 전부 빼준다.
			int num = c - '0';
			if (num == 9) {
				num = 6;
			}
			numberSet[num]++;
		}

		// 6과 9는 바꿀 수 있으므로 2로 나눔
		numberSet[6] = numberSet[6] / 2 + numberSet[6] % 2;
		Arrays.sort(numberSet);
		// 오름차순 정렬이므로 마지막 요소 출력
		System.out.println(numberSet[9]);
	}
}

//내 풀이
//0 1 2 3 4 5 6 7 8 9
//int[] set = new int[10]
//세트?
//
//input >
//split?
//or
//999999
//
//int[] number = new int[6]
//int / 100000		9	number[0]
//% 100000 -> 10000	9
//% 10000 -> 1000		9
//% 1000 -> 100		9
//% 100 -> 10		9
//% 10 -> 0		9
//
//6 = 9
//
//	for (int i = 0; i < set.length(); i++) {
//  	set[i] = i;
//	}
//
//  for (int j = 0; j < number.length(); j++) {
//    if (번호가 체크되면 어떻게 확인하지?) {
//    number[0] - 0번째 set[0~10] = 
//    number[1] - set[0~10] = 
//    number[2] - set[0~10] = 
//    number[3] - set[0~10] = 
//    number[4] - set[0~10] = 
//    number[5] - set[0~10] = 