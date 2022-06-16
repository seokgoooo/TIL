// 회원 관리 프로그램
// 회원을 콘솔입력으로 등록할 수 있게. 최대 10명
// 중복 등록 X
// 중복 : 이름, 키 , 몸무게 동일할 때
// 기준에 따라 집계를 해서 목록을 보여줘야합니다.

// 회원
// 이름
// 키
// 몸무게

// BMI 지수
// BMI = 몸무게(kg) / 키^2(m)

// 고도 비만 : 35 이상
// 중(重)도 비만 (2단계 비만) : 30 이상 - 35 미만
// 경도 비만 (1단계 비만) : 25 이상 - 30 미만
// 과체중 : 23 이상 - 25 미만
// 정상 : 18.5 이상 - 23 미만
// 저체중 : 18.5 미만

// 멤버 관리 프로그램
// 키 순(오름차순)으로 멤버를 조회하기
//----------------------------
// 몸무게 순(오름차순)으로 멤버를 조회하기 << 어제거랑 위에거 다 하고 난 후~~

package bmiMembership;
// 인터페이스는 기본적인 '필수요소'들을 명시만 해놓은 것
// 클래스는 '필수요소'들을 구체적으로 구현 하는 것
import java.util.Comparator;

class Member implements Comparable<Member> {
	// 회원 등록 여부 true 면 등록, false 면 미등록
	private boolean membership;
	// 회원 이름
	private String name;
	// 회원 키
	private double height;
	// 회원 몸무게
	private double weight;

	public Member() {
	}

	public Member(boolean membership, String name, double height, double weight) {
		this.membership = membership;
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public boolean isMembership() {
		return membership;
	}

	public void setMembership(boolean membership) {
		this.membership = membership;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	// BMI 지수 계산
	public double getBmi(double height, double weight) {
		return (weight / ((height / 100) * (height / 100)));
	}

	@Override
	public boolean equals(Object obj) {
		// 이름, 키 , 몸무게 기준으로 중복 확인
		if (this == obj)
			return true;
		if (!(obj instanceof Member))
			return false;
		Member other = (Member) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[이름= " + name + ", 키= " + height + ", 몸무게= " + weight + ", BMI= " + getBmi(height, weight) + "]";
	}

	@Override
	public int compareTo(Member member) {
		// 키 비교		compareTo 는 기준을 하나 밖에 못 잡음
		// compareTo() 메소드 : 객체를 비교할 기준을 정의해주는 부분
		Member other = (Member) member;
		return (int) (this.height - other.height);
	}

//	public int compareToWeight(Object member) {
//		// 몸무게 비교하려고 메소드를 만들어 봤으나

//		'비교한다'는 의미는 같다. But, 비교 대상이 다르다.
//		Comparable : 자기 자신과 매개변수 객체를 비교 하는 것
//		lang 패키지에 있어서 import 필요 X
//		Comparator : 두 매개변수 객체를 비교 하는 것
//		util 패키지에 있어서 import 필요
	
//		!!!한계!!!
//		두 가지 사용할 때 한계 Overflow(상한선을 넘는 것), Underflow(하한선을 넘는 것) 발생할 가능성을 확인하고 사용해야 한다.
//		왜 why? int 값의 범위는 32비트 자료형. 해당 범위 밖으로 return 이 나오면 결과가 달라진다.
//		이런 예외를 확인하기 어렵다면 < > == 로 대소비교 해주는것이 안전하다.
	
//		Comparable interface의 compareTo 메소드는  기준을 하나 밖에 못 가진다
//		그래서 몸무게 정렬할 수 있게 기준을 새로 잡아주는 클래스를 따로 만들어준다
//		Comparator interface의 compare 메소드를 오버라이드 한다
//		compare 메소드는 객체 2개를 매개변수로 받을 수 가 있어서 메소드 오버라이드( 재정의 )를 원하는대로 해주면
//		객체만 집어넣어도 Arrays.sort로 정렬이 된다.
//		Member other = (Member) member;
//		return (int) (this.weight - other.weight);
//	}
}