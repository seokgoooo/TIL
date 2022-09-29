//	이진 변환 반복하기
//	문제 설명
//	0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
//
//	x의 모든 0을 제거합니다.
//	x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
//	예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.
//
//	0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
//
//	제한사항
//	s의 길이는 1 이상 150,000 이하입니다.
//	s에는 '1'이 최소 하나 이상 포함되어 있습니다.
//	입출력 예
//	s	result
//	"110010101001"	[3,8]
//	"01110"	[3,3]
//	"1111111"	[4,1]
//	입출력 예 설명
//	입출력 예 #1
//
//	"110010101001"이 "1"이 될 때까지 이진 변환을 가하는 과정은 다음과 같습니다.
//	회차	이진 변환 이전	제거할 0의 개수	0 제거 후 길이	이진 변환 결과
//	1	"110010101001"	6	6	"110"
//	2	"110"	1	2	"10"
//	3	"10"	1	1	"1"
//	3번의 이진 변환을 하는 동안 8개의 0을 제거했으므로, [3,8]을 return 해야 합니다.
public class BinaryTransform {
	public int[] solution(String s) {
		int[] answer = new int[2];

		while (s.length() > 1) {
			int countOne = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					answer[1]++;
				} else {
					countOne++;
				}
			}

			s = Integer.toBinaryString(countOne);
			answer[0]++;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.print(new BinaryTransform().solution("110010101001"));
		System.out.print(new BinaryTransform().solution("01110"));
		System.out.print(new BinaryTransform().solution("1111111"));
	}
}
//		내 풀이 : 너무 어렵게 생각한건지 돌고 돌아서 접근하는 방법을 생각했다.
//		-> 돌려서 가지말고 주어진 변수를 활용하는 방법으로 접근하자
//		int zeroCount = 0;
//		0을 제거한다 -> char[] 로 받아서 -> 
//		char[] arr = s.toCharArray();
//		하나씩 검사한다 ->
//		for (int i = 0; i < arr.length; i++) {
//		char[i]가 1이면 int[i] 로 옮긴다 
//			if (arr[i] == 1) {
//				answer[i] = 1;
//		else -> count++
//			} else {
//				zeroCount++;
//			}
//		}
//		int[].length를 2진수로 만든다
//		6 / 2 = 3, 0
//		3 / 2 = 1, 1
//		110
//		int temp = answer.length;
//		while (temp / 2 != 1) {
//			int a = temp % 2;
//			temp /= 2;
//		}
//		이러면 이진 변환 1번
//		또 110에서 0을 제거한다