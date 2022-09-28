package a0x03;

import java.io.*;

//알파벳 개수
//문제
//알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
//입력
//첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
//출력
//단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력한다.
//예제 입력 1 
//baekjoon
//예제 출력 1 
//1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0
public class Q10808_AlphabetCount {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[26];
		String S = br.readLine();
//			a b c d e f 
		for (int j = 0; j < S.length(); j++) {
			char ch = S.charAt(j);
			int verse = 'a';
//		0 1 2 3 4 5 6 7
			for (int i = 0; i < arr.length; i++) {
				if (ch - verse == 0) {
					arr[i]++;
				}
				verse++;
			}
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}

		br.close();
	}
}

//	a b c d e f g h i j k l m n o p	  알파벳 배열 arr.length
//	0 1 2 3 4 5 6 7 8 9 10		  비교 배열 반복 arr.length
//	97 98 99 100 101
//	알파벳 배열을 만들 필요가 있나????
//
//	개수 배열에 바로 + 시켜주면?????
//	0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0   개수 배열++ arr.length
//
//	b a e k j o o n S.length
//	0 1 2 3 4 5 6 7 S.length
//	100 97 98 99 100 101
//
//	S.length만큼만 돌고 2중반복을 안하면 어떻게 해야할까