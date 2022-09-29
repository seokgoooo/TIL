public class JadenCase {
	public String solution(String s) {
		String answer = "";
		String[] st = s.split(" ");
		for (int i = 0; i < st.length; i++) {
			if (st[i].length() == 0) {
				answer += " ";
			} else {
				String first = st[i].substring(0, 1).toUpperCase();
				String others = st[i].substring(1).toLowerCase();
				String result = first + others;
				answer += result;
				answer += " ";
			}
		}

		if (s.substring(s.length() - 1, s.length()).equals(" ")) {
			return answer;
		}
		return answer.substring(0, answer.length() - 1);
	}

	public static void main(String[] args) {
		System.out.print(new JadenCase().solution("3people unFollowed me       "));
	}
}