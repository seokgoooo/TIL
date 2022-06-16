import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
		// ArrayList클래스를 쓴다(import). <Animal> : Animal 타입만(Animal 객체만) 사용 가능하다. 이 걸
		// animals 라는 이름에 저장한다.
		List<Animal> animals = new ArrayList<Animal>();

		// (테스트 & 설명용) 생성자에 넣어줄 매개변수 이름 정의
		boolean one = ran.nextBoolean();
		String two = Double.toString(Math.random() * 10);
		int three = (int) (Math.random() * 10);
		double four = (int) (Math.random() * 30);

		// (테스트 & 설명용) animals에 기본 동물 추가 메소드
		basicAnimal(ran, animals, one, two, three, four);

		// 직원 객체를 생성하고 담을 배열 staffs
		List<Staff> staffs = new ArrayList<Staff>();

		// (테스트 & 설명용) 기본 직원 추가 메소드
		basicStaff(animals, staffs);

		// 새로운 staff 생성에 필요한 동물 인덱스 번호를 저장하는 변수
		int animalIndex = 1;

		main.run(scan, main, animals, staffs, animalIndex);
	}

	public static void basicStaff(List<Animal> animals, List<Staff> staffs) {
		staffs.add(new Staff("경영", "이름", animals.get(0)));
		staffs.add(new Staff("조련사", "이름", animals.get(1)));
	}

	public static void basicAnimal(Random ran, List<Animal> animals, boolean one, String two, int three, double four) {
		animals.add(new Animal(one, two, three, four));
		animals.add(new Animal(ran.nextBoolean(), Double.toString(Math.random() * 10), (int) (Math.random() * 10),
				(int) (Math.random() * 30)));
	}
}