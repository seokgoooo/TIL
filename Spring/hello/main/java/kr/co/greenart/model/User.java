package kr.co.greenart.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;

public class User {
	private int id;
//	 hibernate-validator �� maven�� �߰��� ��ȿ���˻絵 annotation���� �ذ� �����ϴ�.
	@NotBlank(message = "�̸��� �Է����ּ���")
	@Size(min = 1, max = 4, message = "�̸��� 1 ~ 4�� ���̿����մϴ�.")
	private String name;
	@Positive(message = "����� �Է����ּ���")
	@Max(value = 100, message = "�ִ밪(100)�� �ʰ��߽��ϴ�.")
	private int age;

	public User() {

	}

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public User(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}