import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test3 {
	public static void main(String[] args) {
//		객체를 내보내주는 클래스
//		이 클래스를 쓸 때는 사용할 클래스에 implements Serializable (직렬화) 만 해주면 된다
//		why? 클래스의 필드 값이 순서대로 되어있는 것이 아니고 각각 주소마다 따로 참조를 하고 있기 때문에 순서대로 만들어주는 과정이 필요하다
//		(파편화되어 있는 정보들을 직렬화)
//		필드에 transient 키워드를 써주면 이 필드는 직렬화에서 제외됨
		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File("d:\\filetest\\s1.set")));
			oos.writeObject(new Student("학생1", 33, 3.0));
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("finish");

		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream("d:\\filetest\\s1.set"));

//			얘는 기본적으로 Object 형으로 읽기 때문에 down casting 해줘야함
			Student s = (Student) ois.readObject();

			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
