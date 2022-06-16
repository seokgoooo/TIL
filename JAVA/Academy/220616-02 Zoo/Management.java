import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Management {
	// 메인 프로그램
	public void run(Scanner scan, Management main, List<Animal> animals, List<Staff> staffs, int animalIndex) {
		boolean on = true;
		while (on) {
			printMainMenu();
			int button = scan.nextInt();
			switch (button) {
			case 1:
				animals.add(new Animal(main.inputAnimalBoolean(), main.inputAnimalSpecies(), main.inputAnimalAge(),
						main.inputAnimalWeight()));
				break;
			case 2:
				++animalIndex;
				staffs.add(new Staff(main.inputStaffJob(), main.inputStaffName(), animals.get(animalIndex)));
				break;
			case 3:
				// ArrayList 출력법 ( 더 있는데 다른 interface 사용하는 2가지는 일단 뺌 지금은 2가지 )
				// for-each 문 사용법
				// 전체 동물 출력
				for (Animal print : animals)
					System.out.println(print);
				System.out.println();

//		        // for loop
//		        for (int i = 0; i < animals.size(); ++i) {
//		            System.out.print(animals.get(i) + "  ");
//		        }
				break;
			case 4:
				// 육식 (true)인 조건에 맞는 동물 출력
				printTrueAnimal(animals);
				break;
			case 5:
				// 초식 (false)인 조건에 맞는 동물 출력
				printFalseAnimal(animals);
				break;
			case 6:
				// 전체 직원 출력 for-each 문
				printAllStaff(staffs);
				break;
			case 7:
				// 조련사 담당에 따라 직원 출력
				// staffs 배열이 정렬할 기준을 정해줌
				Comparator<Staff> species = new Comparator<Staff>() {
					@Override
					public int compare(Staff o1, Staff o2) {
						return o1.getAnimals().getSpecies().compareTo(o2.getAnimals().getSpecies());
					}
				};

				// 기준인 species에 따라 staffs 배열을 정렬
				staffs.sort(species);
				printAllStaff(staffs);
				break;
			case 0:
				System.out.println("BYE BYE");
				on = false;
				break;
			default:
				break;
			}
		}
	}

	public void printAllStaff(List<Staff> staffs) {
		for (Staff print : staffs)
			System.out.println(print);
	}

	public void printFalseAnimal(List<Animal> animals) {
		System.out.println("=====초식 동물=====");
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).isWhatToEat() == false) {
				System.out.println(animals.get(i));
			}
		}
	}

	public void printTrueAnimal(List<Animal> animals) {
		System.out.println("=====육식 동물=====");
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).isWhatToEat() == true) {
				System.out.println(animals.get(i));
			}
		}
	}

	public static void printMainMenu() {
		System.out.println("======================");
		System.out.println("====동물원 관리 프로그램====");
		System.out.println("====1.동 물 === 추 가====");
		System.out.println("====2.직 원 === 추 가====");
		System.out.println("====3.전 체 동 물 보 기====");
		System.out.println("====4.육 식 동 물 보 기====");
		System.out.println("====5.초 식 동 물 보 기====");
		System.out.println("====6.전 체 직 원 출 력====");
		System.out.println("====7.담 당 동 물 정 렬====");
		System.out.println("====0.프 로 그 램 종 료====");
		System.out.println("======================");
	}
	
	public String inputString() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	public String inputStaffName() {
		System.out.println("직원 이름 입력: ");
		return inputString();
	}

	public String inputStaffJob() {
		System.out.println("직원 담당 입력: ");
		return inputString();
	}

	public double inputAnimalWeight() {
		System.out.println("동물 무게 입력: ");
		Scanner scan = new Scanner(System.in);
		double weight = scan.nextDouble();
		scan.nextLine();
		return weight;
	}

	public int inputAnimalAge() {
		System.out.println("동물 나이 입력: ");
		Scanner scan = new Scanner(System.in);
		int age = scan.nextInt();
		scan.nextLine();
		return age;
	}

	public String inputAnimalSpecies() {
		System.out.println("동물 이릅 입력: ");
		return inputString();
	}

	public boolean inputAnimalBoolean() {
		System.out.println("1. 육식 === 2. 초식");
		Scanner scan = new Scanner(System.in);
		if (scan.nextInt() == 1) {
			return true;
		} else {
			return false;
		}
	}
}