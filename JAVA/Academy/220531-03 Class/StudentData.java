class StudentData {
	/*
	 * 필드 타입 변수
	 * 객체 변수 = 인스턴스 변수 = 멤버 변수 = 속성
	 * 클래스에 의해 생성되는 것은 객체
	 * 그 클래스에 선언된 변수는 객체 변수
	 * 객체.객체변수 ---> 로 접근 가능
	 * 
	 * <<< 클래스에서 가장 중요한 부분 >>>
	 * 객체 변수의 값이 독립적으로 유지된다.
	 * 
	 */
	private int classNum;
	private String name;
	private int kor;
	private int eng;
	private int math;

	// 생성자
	public StudentData() {
		name = new String();
		classNum = 0;
		kor = 0;
		eng = 0;
		math = 0;
	}

	// 생성자 오버로딩
	public StudentData(int c, String n, int k, int e, int m) {
		classNum = c;
		name = n;
		kor = k;
		eng = e;
		math = m;
	}

	// 필드에 대한 게터/세터(캡슐화)
	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int c) {
		classNum = c;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int k) {
		kor = k;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int e) {
		eng = e;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int m) {
		math = m;
	}

	// 국어 영어 수학 성적의 합을 구하는 메소드
	public int getSum() {
		return kor + eng + math;
	}

	// 성적의 합을 이용해 평균을 구하는 메소드
	public double getAvg() {
		return (double) getSum() / 3;
	}

	// 평균값을 출력해주는 메소드
	public void getAvgPrint() {
		System.out.println((double) getSum() / 3);
	}
}