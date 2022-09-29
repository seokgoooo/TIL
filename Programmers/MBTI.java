//		입출력 예
//		survey	choices	result
//		["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
//		["TR", "RT", "TR"]	[7, 1, 3]	"RCJA"

//		survey={"RT","TR","FC","CF","MJ","JM","AN","NA"};
//		choice[1 ~ 7];
//	1번 지표 - RT 라튜	TR
//	2번 지표 - CF 콘프	FC
//	3번 지표 - JM 제무	MJ
//	4번 지표 - AN 어네	NA

//AN의 경우 : 5 -> N1
//1   2    3    4     5    6    7
//매우 비동의 약간 모르겠음 약간 동의 매우
//A+3 A+2 A+1 0 N+1 N+2 N+3
//CF : 3 -> C1
//C3 C2 C1 0 F1 F2 F3
//MJ : 2 -> M2
//M3 M2 M1 0 J1 J2 J3
//RT : 7 -> T3
//R3 R2 R1 0 T1 T2 T3
//NA : 5 -> A1
//N3 N2 N1 0 A1 A2 A3
//	choices - MIDDLE > 0 ? 뒤에거 : 앞에거
//
//더 높은 점수를 받은 성격 유형 -> 성격 유형
//점수가 같으면 -> 사전 순으로 빠른 성격 유형

class Solution {
	private final static int MIDDLE = 4;

	public String solution(String[] survey, int[] choices) {
		String answer = "";

//		초기값 전부 0이면 사전순이기 때문에 앞글자를 다 써준다.
		String[] mbti = { "R", "C", "J", "A" };
		String[] mbtiSecond = { "T", "F", "M", "N" };
//		해당 자리마다 점수 기록해줄 배열
		int[] score = new int[4];
		for (int i = 0; i < survey.length; i++) {
			switch (survey[i]) {
			case "RT":
				score[0] += choices[i] - MIDDLE;
				break;
			case "TR":
				score[0] += MIDDLE - choices[i];
				break;
			case "CF":
				score[1] += choices[i] - MIDDLE;
				break;
			case "FC":
				score[1] += MIDDLE - choices[i];
				break;
			case "JM":
				score[2] += choices[i] - MIDDLE;
				break;
			case "MJ":
				score[2] += MIDDLE - choices[i];
				break;
			case "AN":
				score[3] += choices[i] - MIDDLE;
				break;
			case "NA":
				score[3] += MIDDLE - choices[i];
				break;
			default:
				break;
			}
		}

		for (int i = 0; i < score.length; i++) {
			if (score[i] > 0) {
				mbti[i] = mbtiSecond[i];
			}
			answer += mbti[i];
		}

		return answer;
	}
}

public class MBTI {
	public static void main(String[] args) {
		String[] testS = { "AN", "CF", "MJ", "RT", "NA" };
		int[] testC = { 5, 3, 2, 7, 5 };
		System.out.println(new Solution().solution(testS, testC));
	}
}

//	깔끔한 Jin Sangjin Choi님 풀이 ( Map 이용 )
//import java.util.HashMap;
//
//class Solution {
//    public String solution(String[] survey, int[] choices) {
//        String answer = "";
//        HashMap<Character, Integer> map = new HashMap<>();
//        map.put('R', 0);map.put('T', 0);
//        map.put('C', 0);map.put('F', 0);
//        map.put('J', 0);map.put('M', 0);
//        map.put('A', 0);map.put('N', 0);
//
//        for (int i = 0; i < survey.length; i++) {
//            if (choices[i] > 4)
//                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + choices[i] - 4);
//            else if (choices[i] < 4) {
//                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 4 - choices[i]);
//            }
//        }
//
//
//        if (map.get('R') >= map.get('T'))
//            answer = "R";
//        else
//            answer = "T";
//
//        if (map.get('C') >= map.get('F'))
//            answer += "C";
//        else
//            answer += "F";
//
//        if (map.get('J') >= map.get('M'))
//            answer += "J";
//        else
//            answer += "M";
//
//        if (map.get('A') >= map.get('N'))
//            answer += "A";
//        else
//            answer += "N";
//
//        return answer;
//    }
//}