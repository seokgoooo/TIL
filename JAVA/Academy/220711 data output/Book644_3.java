import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Info implements Serializable {
	private String number;
	private String name;
	private String phone;
	private String mail;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Info(String number, String name, String phone, String mail) {
		super();
		this.number = number;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Info [number=" + number + ", name=" + name + ", phone=" + phone + ", mail=" + mail + "]";
	}
}

public class Book644_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File("d:\\filetest\\book1.set")));
			oos.writeObject(new Info("1", "홍길동", "011-111-1111", "hong@hanmail.net"));
			oos.writeObject(new Info("2", "김유신", "010-222-2222", "kim@hanmail.net"));

			String number = sc.nextLine();
			String name = sc.nextLine();
			String phone = sc.nextLine();
			String mail = sc.nextLine();
			oos.writeObject(new Info(number, name, phone, mail));

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
		List<Info> list = new ArrayList<>();
		String inputNumber = sc.nextLine();

		try {
			ois = new ObjectInputStream(new FileInputStream("d:\\filetest\\book1.set"));
			while (true) {
				list.add((Info) ois.readObject());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
		} finally {
			if (ois != null) {
				try {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getNumber().equals(inputNumber)) {
							System.out.println(list.get(i).getPhone());
						}
					}
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
