package student;
public class Main {
	public static void main(String[] args) {
//		Student s = new Student("둘리", "95123", "마술학", 2, 14);
//		UnderGraduate s = new UnderGraduate
//				("둘리", "95123", "마술학", 2, 14, "마술동아리");
		Graduate s = new Graduate
				("둘리", "95123", "마술학", 2, 14, "교육조교", 0.9);
		System.out.println(s.toString());
	}
}
