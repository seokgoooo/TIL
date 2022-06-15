package animal;
public class Main {
	public static void main(String[] args) {
//		interface도 추상화만 담고있어서 객체 생성 불가능
//		Flyable f = new Flyable();
		
		Penguin penguin = new Penguin();
//		Flyable test = penguin;
		
		Eagle e = new Eagle();
		Bird b = e;
		Animal a = e;
		Flyable f = e;
		
//		instanceof 를 downCasting 할 때 써줘야 안전~
//		왜 why? 형변환 컴파일 에러 발생가능성 있다~
		Eagle downCasting = (Eagle) f;
		downCasting.fly();
		
//		추상클래스는 참조를 할 뿐이고 자식클래스에 구현되어있는 메소드가 실행된다.
		f.fly();
		
		Flyable p = new Plane();
		
		// 비행기는 독수리가 아니다.
//		Eagle test = (Eagle) p;
		
		Flyable fish = new FlyingFish();
		
		p.fly();
		fish.fly();
	}
}