import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		DataOutputStream dos = null;

		try {
			dos = new DataOutputStream(new FileOutputStream("d:\\filetest\\mydata.dat"));

			dos.writeInt(50);
			dos.writeDouble(123.123);
			dos.writeUTF("문자열");
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

//		byte 단위로 읽어 들이는 DataInputStream 얘의 메소드는 EOF를 예외로 알려준다
		DataInputStream dis = null;

		try {
			dis = new DataInputStream(new FileInputStream("d:\\filetest\\mydata.dat"));

			int valueInt = dis.readInt();
			double valueDouble = dis.readDouble();
			String valueString = dis.readUTF();

			System.out.println(valueInt);
			System.out.println(valueDouble);
			System.out.println(valueString);

			dis.readBoolean();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("파일 끝까지 다 읽음");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

//		DataOutputStream list 형태의 값을 밖으로 내보내기
		List<Student> list = new ArrayList<>(
				Arrays.asList(new Student("홍길동", 22, 2.5), new Student("둘리", 33, 3.3), new Student("도우너", 44, 4.4)));
		DataOutputStream dosList = null;
		try {
			dosList = new DataOutputStream(new FileOutputStream(new File("d:\\filetest\\student.dat")));
			for (int i = 0; i < list.size(); i++) {
				Student s = list.get(i);
				dosList.writeUTF(s.getName());
				dosList.writeInt(s.getAge());
				dosList.writeDouble(s.getScore());
			}
			dosList.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

//		DataInputStream 으로 다시 읽어들이기
		DataInputStream disList = null;
		List<Student> studentList = new ArrayList<Student>();

		try {
			disList = new DataInputStream(new FileInputStream(new File("d:\\filetest\\student.dat")));

			while (true) {
				String name = disList.readUTF();
				int age = disList.readInt();
				double score = disList.readDouble();

				Student s = new Student(name, age, score);
				studentList.add(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("학생 정보를 파일 끝까지 다 읽었습니다");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (disList != null) {
				try {
					disList.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(studentList);
	}
}
