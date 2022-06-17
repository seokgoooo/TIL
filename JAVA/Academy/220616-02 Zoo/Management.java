import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Management class : 프로그램 설계도
public class Management {
	// 메인 프로그램
	public void run(Scanner scan, Management main, List<Animal> animals, List<Staff> staffs, int animalIndex) {
		printMainMenu();
		boolean on = true;
		while (on) {
			int button = scan.nextInt();
			switch (button) {
			case 1:
				// 동물 추가 메소드
				System.out.println("====1.동 물 === 추 가====");
				inputAnimal(main, animals);
				break;
			case 2:
				// 직원 추가 메소드
				// 직원 입력부터 받는다
				System.out.println("====2.직 원 === 추 가====");
				staffs.add(new Staff(main.inputStaffJob(), main.inputStaffName(), null));

				// 입력 받은 staff 객체에 조련사가 포함되어 있으면 동물을 담당해야 한다.
				// staffs 배열의 마지막 index의 담당이 조련사라면 담당할 수 있는 동물이 남아있는지 체크한다.
				if (staffs.get(staffs.size() - 1).getJob().equals("조련사")) {
					// animals 배열의 인덱스 번호가 animals 배열의 최대값 보다 작으면
					// ---> 즉, 배정받지 못한 동물이 남아 있으면
					// 방금 입력 받은 staffs 배열의 마지막 index의 staff 객체의 animal 필드에 남은 동물을 추가해준다.
					// 그리고 animals 배열의 인덱스번호를 늘려준다.
					if (animalIndex < animals.size()) {
						staffs.get(staffs.size() - 1).setAnimals(animals.get(animalIndex));
						animalIndex++;
						System.out.println("직원 추가 완료");
					} else {
						// 동물 전부가 배정 받아 있으면 조련사가 담당할 동물이 없기 때문에 조련사 추가가 불가능하다.
						// 방금 입력 받은 staff 객체는 삭제한다.
						System.out.println("담당할 수 있는 동물이 없습니다");
						staffs.remove(staffs.size() - 1);
					}
				} else {
					System.out.println("직원 추가 완료");
				}
				break;
			case 3:
				// ArrayList 출력법 ( 더 있는데 다른 interface 사용하는 2가지는 일단 뺌 지금은 2가지 )
				// for-each 문 사용법
				// 전체 동물 출력
				System.out.println("====3.전 체 동 물 보 기====");
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
				System.out.println("====4.육 식 동 물 보 기====");
				printTrueAnimal(animals);
				break;
			case 5:
				// 초식 (false)인 조건에 맞는 동물 출력
				System.out.println("====5.초 식 동 물 보 기====");
				printFalseAnimal(animals);
				break;
			case 6:
				// 전체 직원 출력 for-each 문
				System.out.println("====6.전 체 직 원 출 력====");
				printAllStaff(staffs);
				break;
			case 7:
				// 조련사 담당에 따라 직원 출력
				// staffs 배열이 정렬할 기준을 정해줌
				// 담당 동물이 없으면 null 이기 때문에 NullPointerException 에러가 뜬다
				// 갈 곳을 잃은 null 상황일 때 어떻게 해야할지를 정해주면 해결된다.
				// 여기서는 null 값을 앞으로 보내도록 기준을 잡았다.
				System.out.println("====7.담 당 동 물 정 렬====");
				Comparator<Staff> species = new Comparator<Staff>() {
					@Override
					public int compare(Staff o1, Staff o2) {
						if (o1.getAnimals() == null) {
							return (o2.getAnimals() == null) ? 0 : -1;
						}

						if (o2.getAnimals() == null) {
							return 1;
						}

						else {
							return o1.getAnimals().getSpecies().compareTo(o2.getAnimals().getSpecies());
						}
					}
				};

				// 기준인 species에 따라 staffs 배열을 정렬
				staffs.sort(species);
				printAllStaff(staffs);
				break;
			case 0:
				// 프로그램 종료
				System.out.println("BYE BYE");
				on = false;
				break;
			default:
				break;
			}
		}
	}

	public void inputAnimal(Management main, List<Animal> animals) {
		animals.add(new Animal(main.inputAnimalBoolean(), main.inputAnimalSpecies(), main.inputAnimalAge(),
				main.inputAnimalWeight()));
		System.out.println("동물 추가 완료");
	}

	public void printAllStaff(List<Staff> staffs) {
		for (Staff print : staffs)
			System.out.println(print.toString());
		System.out.println();
	}

	public void printTrueAnimal(List<Animal> animals) {
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).isWhatToEat() == true) {
				System.out.println(animals.get(i));
			}
		}
		System.out.println();
	}

	public void printFalseAnimal(List<Animal> animals) {
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).isWhatToEat() == false) {
				System.out.println(animals.get(i));
			}
		}
		System.out.println();
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
		System.out.print("직원 이름 입력: ");
		return inputString();
	}

	public String inputStaffJob() {
		System.out.print("직원 담당 입력: ");
		return inputString();
	}

	public double inputAnimalWeight() {
		System.out.print("동물 무게 입력: ");
		Scanner scan = new Scanner(System.in);
		double weight = scan.nextDouble();
		scan.nextLine();
		return weight;
	}

	public int inputAnimalAge() {
		System.out.print("동물 나이 입력: ");
		Scanner scan = new Scanner(System.in);
		int age = scan.nextInt();
		scan.nextLine();
		return age;
	}

	public String inputAnimalSpecies() {
		System.out.print("동물 종 입력: ");
		return inputString();
	}

	public boolean inputAnimalBoolean() {
		System.out.print("1. 육식 === 2. 초식");
		Scanner scan = new Scanner(System.in);
		if (scan.nextInt() == 1) {
			return true;
		} else {
			return false;
		}
	}
}