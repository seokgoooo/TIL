// 강아지 Dog 클래스
// name : 이름
// breed : 종
// age : 나이

// 강아지 3개의 모든 필드를 초기화 할 수 있는 생성자

// 강아지 이름, 종을 전달받은 값으로 초기화하고 나이는 1살로 초기화 할 수 있는 생성자

// 모든 필드를 private 접근 제한자로 정보은닉(캡슐화)하고 각 필드의 public한 getter/setter를 작성해보세용

public class Dog {
	private String name;
	private String breed;
	private int age;
	
	public Dog(String n, String b, int a) {
		name = n;
		breed = b;
		age = a;
		
		// this.name = name;			매개변수가 name 이면 ( 이름 똑같을 때 ) this 활용
		// this.breed = breed;
		// this.age = age;
	}
	
	public Dog(String n, String b) {
		this(n, b, 1);
		System.out.println("초기화 과정 중~~");
	}

	public String getName() {
		return name;
	}

	public boolean setName(String n) {
		if (n != null) {
			name = n;
			return true;
		}
		return false;
	}
	
	public String getBreed() {
		return breed;
	}

	public boolean setBreed(String b) {
		if (b != null) {
			breed = b;
			return true;
		}
		return false;
	}
	
	// 접근(나이)
	public int getAge() {
		return age;
	}
	
	// 설정(나이)
	public void setAge(int a) {
		age = a;
	}
	
	// get set 등으로 생성자 쓰는 이유 : 객체 지향이라는 것은 객체의 행동으로 이루어 지는것으로 생각하기 때문이다.
}