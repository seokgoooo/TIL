import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Run class : main ���赵
public class Run {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		Management main = new Management();

//		���� ��ü 1�� ( dog ) �����ϴ� ���
//		Animal dog = new Animal();
//		dog.setWhatToEat(ran.nextBoolean());
//	    dog.setAge((int) (Math.random() * 10));
//		dog.setSpecies(Double.toString(Math.random() * 10));
//		dog.setWeight(Math.random() * 20);

		// ������ ���� ��ü�� ���� �迭 ArrayList �� size�� �������̶� ���
		// ArrayListŬ������ ����(import). <Animal> : Animal Ÿ�Ը�(Animal ��ü��) ��� �����ϴ�.
		// �� ArrayList ��ü�� animals ��� �̸��� �����Ѵ�.
		// animals �� Animal ��ü���� ���� ��ü �迭
		List<Animal> animals = new ArrayList<Animal>();

		// (�׽�Ʈ & �����) �����ڿ� �־��� �Ű����� �̸� ����
		boolean one = ran.nextBoolean();
		String two = Double.toString(Math.random() * 10);
		int three = (int) (Math.random() * 10);
		double four = (int) (Math.random() * 30);

		// (�׽�Ʈ & �����) animals�� �⺻ ���� �߰� �޼ҵ�
		basicAnimal(ran, animals, one, two, three, four);

		// Staff ��ü�� ���� �迭 staffs
		List<Staff> staffs = new ArrayList<Staff>();

		// (�׽�Ʈ & �����) �⺻ ���� �߰� �޼ҵ�
		basicStaff(animals, staffs);

		// ���ο� staff ������ �ʿ��� ���� �迭�� ������ �ε��� ��ȣ�� �����ϴ� ����
		// ���⼭�� �׽�Ʈ ������ ���� 2������ �����Ǿ� �ִ�.
		int animalIndex = animals.size();
		
		main.run(scan, main, animals, staffs, animalIndex);
	}

	public static void basicStaff(List<Animal> animals, List<Staff> staffs) {
		staffs.add(new Staff("�濵", "������", null));
		staffs.add(new Staff("���û�", "������", animals.get(0)));
		staffs.add(new Staff("���û�", "������", animals.get(1)));
		staffs.add(new Staff("�λ�", "Ȳ����", null));
		staffs.add(new Staff("ȫ��", "��ٹ�", null));
	}

	public static void basicAnimal(Random ran, List<Animal> animals, boolean one, String two, int three, double four) {
//		animals.add(new Animal(one, two, three, four));
//		animals.add(new Animal(ran.nextBoolean(), Double.toString(Math.random() * 10), (int) (Math.random() * 10),
//				(int) (Math.random() * 30)));
		animals.add(new Animal(true, "������", 2, 8.8));
		animals.add(new Animal(false, "�⸰", 20, 550.88));
	}
}