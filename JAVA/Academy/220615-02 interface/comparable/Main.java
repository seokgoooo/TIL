package comparable;

import java.util.Arrays;

//	제네릭 : <Type> 꼭 해야하는건 아니지만 이렇게하면 안전해진다.
class Member implements Comparable<Member> {
	String name; // 이름
	int height; // 키
	int weight; // 몸무게

	public Member(String name, int height, int weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	// 키 를 기준으로 비교
	public int compare(Member member) {
//		if (height > member.height) {
//			return 1;
//		} else if (height < member.height) {
//			return -1;
//		} else {
//			return 0;
//		}
//		비교 결과를 3가지로 나누려고 할 때
//		int 로 return 값 주면 위의 식이 아래 1줄로 설명 가능
		return height - member.height;
	}

//	비교할 때 자바에서 Comparable interface를 만들어놔서 이걸 활용하면 된다.
	@Override
	public int compareTo(Member member) {
		return this.height - member.height;
	}
}

public class Main {
	public static void main(String[] args) {
		Member[] members = { new Member("키큰", 190, 60),
				new Member("키작은", 130, 20),
				new Member("중간", 176, 65) };
		
//		System.out.println(members[0].compareTo(members[1]));
		Arrays.sort(members);
		System.out.println(members[0].height);
		System.out.println(members[1].height);
		System.out.println(members[2].height);
	}
}