package Al;

import java.util.Arrays;

public class DevMatching_1 {
	public String solution(String[] registered_list, String new_id) {
		String answer = new_id;
		int[] list = new int[registered_list.length];

		while (!Arrays.asList(registered_list).contains(new_id)) {
			for (int i = 0; i < registered_list.length; i++) {
				String regNum = registered_list[i].replaceAll("[^0-9]", "");
				if (regNum.length() > 0) {
					int rNum = Integer.parseInt(regNum);
					list[i] = rNum;
				}
			}
			String newId = new_id.replaceAll("[a-z]", "");
			String newNum = new_id.replaceAll("[^0-9]", "");
			if (newNum.length() > 0) {
				int nNum = Integer.parseInt(newNum);
				if (!Arrays.asList(list).contains(nNum)) {
					nNum++;
					newNum = String.valueOf(nNum);
				}
			}

			answer = newId + "" + newNum;
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] reg = { "apple1", "orange", "banana3" };
		System.out.println(new DevMatching_1().solution(reg, "apple"));
	}
}
