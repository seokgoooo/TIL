class Can {
	private String name;

	public Can(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public void cola(int i) {
		// TODO Auto-generated method stub
		
	}
}

public class Main2 {
	// 자판기 메소드
	// 정수형 -> 반환Type : Can
	// 1 -> field "콜라"
	// 2 -> field "사이다"

	// 문자열 -> 반환Type : Can
	// "Cola" -> field "콜라"
	public final int COLA = 1;
	public final int SPRITE = 2;
	public final int FANTA = 3;
	
	public Can cola(int input) {
		if (input == 1) {
			System.out.println("콜라객체");
			return new Can("콜라");
		}

		if (input == 2) {
			System.out.println("사이다객체");
			return new Can("사이다");
		} else {
			return null;
		}
	}

	public Can cola(String input) {
		if (input.equals("Cola")) {
			System.out.println("콜라객체");
			return new Can("콜라");
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		Main2 one = new Main2();
		one.cola(1);
		one.cola(2);
		one.cola("Cola");
	}
}