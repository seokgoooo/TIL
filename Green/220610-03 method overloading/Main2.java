class Can {
	private String name;

	public Can(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
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

	public Can choice(int input) {
		if (input == COLA) {
			System.out.println("---------------");
			System.out.println("콜라객체 생성");
			return new Can("콜라");
		}
		if (input == SPRITE) {
			System.out.println("---------------");
			System.out.println("사이다객체 생성");
			return new Can("사이다");
		}
		if (input == FANTA) {
			System.out.println("---------------");
			System.out.println("환타객체 생성");
			return new Can("환타");
		} else {
			System.out.println("---------------");
			System.out.println("빈 객체 생성");
			System.out.print("---------------");
			return new Can("");
		}
	}

	public Can choice(String input) {
		String name;
		if (input.equals("Cola")) {
			System.out.println("---------------");
			System.out.println("콜라객체 생성");
			name = "콜라";
		} else {
			return new Can("");
		}
		return new Can(name);
	}

	public static void main(String[] args) {
		Main2 drinkMachine = new Main2();
		Can one = drinkMachine.choice(1);
		System.out.println(one.toString());

		Can two = drinkMachine.choice(2);
		System.out.println(two.toString());

		Can three = drinkMachine.choice(3);
		System.out.println(three.toString());

		Can str = drinkMachine.choice("Cola");
		System.out.println(str.toString());

		Can zero = drinkMachine.choice(0);
		System.out.println(zero.toString());
	}
}
