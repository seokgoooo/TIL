package bmiMembership;

// 이렇게 클래스를 계속 따로 만들어주기 귀찮기도 하고
// 관리하기가 갈수록 힘들어 진다.
// 그래서 class 안에 지역 class 로 선언해서 사용해주자

import java.util.Comparator;

// 몸무게 정렬할 수 있게 기준을 잡는 클래스를 만들어준다
class WeightComparator implements Comparator<Member>{
	@Override
	public int compare(Member o1, Member o2) {
		return (int) (o1.getWeight() - o2.getWeight());
	}
}

// 이름을 정렬할 수 있게 기준을 잡는 클래스
public class NameComparator implements Comparator<Member>{
	@Override
	public int compare(Member o1, Member o2) {
		return o1.getName().compareTo(o2.getName());
	}
}