package animal;
// 인터페이스는 추상화만 담아놓은 아이
// 추상적인 동작을 적어주면 된다

public interface Flyable {
//	public abstract void fly();
// 	인터페이스는 추상화만 담는거라 abstract를 따로 안적어줘도 된다
// 	무조건 public 이라 접근 제한자도 생략
//	interface를 implements (구현하다) 하는 클래스들은 메소드를 구현해야하는 책임이 따른다
	void fly();
}

class Animal {
}

// 새는 동물이다
class Bird extends Animal {
}

// 독수리는 날 수 있는 새다
class Eagle extends Bird implements Flyable {
	@Override
	public void fly() {
		System.out.println("독수리가 납니다");
	}
}

// 펭귄은 새다
class Penguin extends Bird {
}

class FlyingFish implements Flyable {
	@Override
	public void fly() {
		System.out.println("날치가 물위로 난다");
	}
}

class Plane implements Flyable {
	@Override
	public void fly() {
		System.out.println("비행기가 난다");
	}
}