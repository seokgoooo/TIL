// MVC 패턴이란

// 프로그램을 모델, 뷰, 컨트롤러 3가지 종류로 나누어서 개발하는 방법
// 모델: 데이터를 담는 틀
// 뷰: 화면에 출력을 담당하는 부분
// 컨트롤러: 뷰가 요청하면 모델을 만들어서 뷰로 보내주는 역할

// 모델의 경우, 필드와 게터/세터, 그리고 object 클래스의 메소드를 재정의하는 정도만
// 들어간다.
// 주로 뒤에 VO(Value Object) 혹은 DTO(Data Transfer Object)의 
// 접미사가 붙는다.
public class ParkVO {
	// 차량번호
	private String plateNumber;
	// 들어온 시간
	private int inTime;

	// 필드에 대한 게터/세터
	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	// equals() 메소드
	public boolean equals(Object obj) {
		if (obj instanceof ParkVO) {
			ParkVO parkVO = (ParkVO) obj;
			if (plateNumber.equals(parkVO.plateNumber)) {
				return true;
			}
		}

		return false;
	}

	// 생성자
	public ParkVO() {
		plateNumber = new String();
		inTime = 0;
	}

}