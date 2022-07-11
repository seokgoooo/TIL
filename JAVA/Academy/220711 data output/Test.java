import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Student implements Serializable {
	private String name;
	private int age;
	private transient double score;

	public Student(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
}

public class Test {
	public static void main(String[] args) {
		// 학생
		// 이름: 문자열
		// 나이: 정수
		// 학점: 실수

//		------------------------------(형변환) Parsing Test 2-----------------------------------
		BufferedReader br = null;
		List<Student> list = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(new File("d:\\filetest\\students.txt")));

			while (true) {
				String name = br.readLine();
				int age = Integer.valueOf(br.readLine());
				double score = Double.valueOf(br.readLine());

				Student s = new Student(name, age, score);
				list.add(s);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(list);

//		-----------------------list 타입의 데이터 저장해보는 Test 1--------------------------------
//		List<Student> list = new ArrayList<>(
//				Arrays.asList(new Student("홍길동", 22, 2.5), new Student("둘리", 33, 3.3), new Student("도우너", 44, 4.4)));
//		PrintWriter pw = null;
//		try {
//			pw = new PrintWriter(new File("d:\\filetest\\students.txt"));
//			for (int i = 0; i < list.size(); i++) {
//				Student s = list.get(i);
//				pw.println(s.getName());
//				pw.println(s.getAge());
//				pw.println(s.getScore());
//			}
//			pw.flush();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			pw.close();
//		}

	}
}