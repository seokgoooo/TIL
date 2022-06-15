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

class Member {
	private boolean membership;
	private String name;
	private double height;
	private double weight;

	public Member(String name, double height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public boolean isMember() {
		return membership;
	}

	public void setMember(boolean member) {
		this.membership = member;
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
		return weight / (height * height);
	}

	@Override
	public boolean equals(Object obj) {
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
		return "Member [name= " + name + ", height= " + height + ", weight= " + weight + ", BMI= "
				+ getBmi(height, weight) + "]";
	}
}