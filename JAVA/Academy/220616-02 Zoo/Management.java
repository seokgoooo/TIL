import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Management class : ���α׷� ���赵
public class Management {
	// ���� ���α׷�
	public void run(Scanner scan, Management main, List<Animal> animals, List<Staff> staffs, int animalIndex) {
		boolean on = true;
		while (on) {
			printMainMenu();
			int button = scan.nextInt();
			switch (button) {
			case 1:
				// ���� �߰� �޼ҵ�
				inputAnimal(main, animals);
				break;
			case 2:
				// ���� �߰� �޼ҵ�
				// ���� �Էº��� �޴´�
				staffs.add(new Staff(main.inputStaffJob(), main.inputStaffName(), null));

				// �Է� ���� staff ��ü�� ���û簡 ���ԵǾ� ������ ������ ����ؾ� �Ѵ�.
				// staffs �迭�� ������ index�� ����� ���û��� ����� �� �ִ� ������ �����ִ��� üũ�Ѵ�.
				if (staffs.get(staffs.size() - 1).getJob().equals("���û�")) {
					// animals �迭�� �ε��� ��ȣ�� animals �迭�� �ִ밪 ���� ������
					// ---> ��, �������� ���� ������ ���� ������
					// ��� �Է� ���� staffs �迭�� ������ index�� staff ��ü�� animal �ʵ忡 ���� ������ �߰����ش�.
					// �׸��� animals �迭�� �ε�����ȣ�� �÷��ش�.
					if (animalIndex < animals.size()) {
						staffs.get(staffs.size() - 1).setAnimals(animals.get(animalIndex));
						animalIndex++;
						System.out.println("���� �߰� �Ϸ�");
					} else {
						// ���� ���ΰ� ���� �޾� ������ ���û簡 ����� ������ ���� ������ ���û� �߰��� �Ұ����ϴ�.
						// ��� �Է� ���� staff ��ü�� �����Ѵ�.
						System.out.println("����� �� �ִ� ������ �����ϴ�");
						staffs.remove(staffs.size() - 1);
					}
				} else {
					System.out.println("���� �߰� �Ϸ�");
				}
				break;
			case 3:
				// ArrayList ��¹� ( �� �ִµ� �ٸ� interface ����ϴ� 2������ �ϴ� �� ������ 2���� )
				// for-each �� ����
				// ��ü ���� ���
				for (Animal print : animals)
					System.out.println(print);
				System.out.println();

//		        // for loop
//		        for (int i = 0; i < animals.size(); ++i) {
//		            System.out.print(animals.get(i) + "  ");
//		        }
				break;
			case 4:
				// ���� (true)�� ���ǿ� �´� ���� ���
				printTrueAnimal(animals);
				break;
			case 5:
				// �ʽ� (false)�� ���ǿ� �´� ���� ���
				printFalseAnimal(animals);
				break;
			case 6:
				// ��ü ���� ��� for-each ��
				printAllStaff(staffs);
				break;
			case 7:
				// ���û� ��翡 ���� ���� ���
				// staffs �迭�� ������ ������ ������
				// ��� ������ ������ null �̱� ������ NullPointerException ������ ���
				// �� ���� ���� null ��Ȳ�� �� ��� �ؾ������� �����ָ� �ذ�ȴ�.
				// ���⼭�� null ���� ������ �������� ������ ��Ҵ�.

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

				// ������ species�� ���� staffs �迭�� ����
				staffs.sort(species);
				printAllStaff(staffs);
				break;
			case 0:
				// ���α׷� ����
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
		System.out.println("���� �߰� �Ϸ�");
	}

	public void printAllStaff(List<Staff> staffs) {
		System.out.println("======================");
		for (Staff print : staffs)
			System.out.println(print.toString());
		System.out.println();
	}

	public void printTrueAnimal(List<Animal> animals) {
		System.out.println("========���� ����========");
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).isWhatToEat() == true) {
				System.out.println(animals.get(i));
			}
		}
		System.out.println();
	}

	public void printFalseAnimal(List<Animal> animals) {
		System.out.println("========�ʽ� ����========");
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).isWhatToEat() == false) {
				System.out.println(animals.get(i));
			}
		}
		System.out.println();
	}

	public static void printMainMenu() {
		System.out.println("======================");
		System.out.println("====������ ���� ���α׷�====");
		System.out.println("====1.�� �� === �� ��====");
		System.out.println("====2.�� �� === �� ��====");
		System.out.println("====3.�� ü �� �� �� ��====");
		System.out.println("====4.�� �� �� �� �� ��====");
		System.out.println("====5.�� �� �� �� �� ��====");
		System.out.println("====6.�� ü �� �� �� ��====");
		System.out.println("====7.�� �� �� �� �� ��====");
		System.out.println("====0.�� �� �� �� �� ��====");
		System.out.println("======================");
	}

	public String inputString() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	public String inputStaffName() {
		System.out.print("���� �̸� �Է�: ");
		return inputString();
	}

	public String inputStaffJob() {
		System.out.print("���� ��� �Է�: ");
		return inputString();
	}

	public double inputAnimalWeight() {
		System.out.print("���� ���� �Է�: ");
		Scanner scan = new Scanner(System.in);
		double weight = scan.nextDouble();
		scan.nextLine();
		return weight;
	}

	public int inputAnimalAge() {
		System.out.print("���� ���� �Է�: ");
		Scanner scan = new Scanner(System.in);
		int age = scan.nextInt();
		scan.nextLine();
		return age;
	}

	public String inputAnimalSpecies() {
		System.out.print("���� �� �Է�: ");
		return inputString();
	}

	public boolean inputAnimalBoolean() {
		System.out.print("1. ���� === 2. �ʽ�");
		Scanner scan = new Scanner(System.in);
		if (scan.nextInt() == 1) {
			return true;
		} else {
			return false;
		}
	}
}