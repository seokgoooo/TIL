import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//동물원 관리

//동물 - 종, 나이, 무게

//직원 - 역할(조련사, 경영 등등), 이름
//조련사는 동물들을 담당합니다.

//동물은 육식/초식으로 나누어서 관리됩니다. 
//주식으로 분류하여 동물 목록을 볼 수 있음.
//조련사 담당에 따라 동물 목록을 볼 수 있음. (담당자가 없는 동물도 볼 수 있어야 함)

// Run class : main 설계도
public class Run {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		Management main = new Management();

//		동물 객체 1개 ( dog ) 생성하는 방법
//		Animal dog = new Animal();
//		dog.setWhatToEat(ran.nextBoolean());
//	    dog.setAge((int) (Math.random() * 10));
//		dog.setSpecies(Double.toString(Math.random() * 10));
//		dog.setWeight(Math.random() * 20);

		// 생성한 동물 객체를 담을 배열 ArrayList 는 size가 가변적이라서 사용
		// ArrayList 클래스를 쓴다(import). <Animal> : Animal 타입만(Animal 객체만) 사용 가능하다.
		// 이 ArrayList 객체를 animals 라는 이름에 저장한다.
		// animals 는 Animal 객체들을 담을 객체 배열
		
//		Animal[] animals = new Animal[10];
		// 이 표현이 불편한지 잘 익숙하지 않아서 그런지 사용
		// List는 인터페이스 ArrayList는 List 인터페이스를 구현한 클래스
//		ArrayList<Animal> animals = new ArrayList<Animal>();
		// 이 문장이랑 같은 의미로 봐도 되는데 DownCasting UpCasting 이 부분에서 차이가 난다. 
		// List 인터페이스를 구현한 다른 클래스들이 있다. 
		// List 인터페이스를 타입으로 쓰면 형변환할 때 조금 더 유연하게 사용 가능하다
		List<Animal> animals = new ArrayList<Animal>();

		// (테스트 & 설명용) 생성자에 넣어줄 매개변수 이름 정의
		boolean one = ran.nextBoolean();
		String two = Double.toString(Math.random() * 10);
		int three = (int) (Math.random() * 10);
		double four = (int) (Math.random() * 30);

		// (테스트 & 설명용) animals에 기본 동물 추가 메소드
		basicAnimal(ran, animals, one, two, three, four);

		// Staff 객체만 담을 배열 staffs
		List<Staff> staffs = new ArrayList<Staff>();

		// (테스트 & 설명용) 기본 직원 추가 메소드
		basicStaff(animals, staffs);

		// 새로운 staff 생성에 필요한 동물 배열의 마지막 인덱스 번호를 저장하는 변수
		// 여기서는 테스트 용으로 동물 2마리가 생성되어 있다.
		int animalIndex = animals.size();
		
		main.run(scan, main, animals, staffs, animalIndex);
	}

	public static void basicStaff(List<Animal> animals, List<Staff> staffs) {
		staffs.add(new Staff("경영", "이정재", null));
		staffs.add(new Staff("조련사", "강형욱", animals.get(0)));
		staffs.add(new Staff("조련사", "아이유", animals.get(1)));
		staffs.add(new Staff("인사", "황정민", null));
		staffs.add(new Staff("홍보", "김다미", null));
	}

	public static void basicAnimal(Random ran, List<Animal> animals, boolean one, String two, int three, double four) {
//		animals.add(new Animal(one, two, three, four));
//		animals.add(new Animal(ran.nextBoolean(), Double.toString(Math.random() * 10), (int) (Math.random() * 10),
//				(int) (Math.random() * 30)));
		animals.add(new Animal(true, "강아지", 2, 8.8));
		animals.add(new Animal(false, "기린", 20, 550.88));
	}
}