package bmi;
//ȸ�� ���� ���α׷�

//ȸ���� �ܼ��Է����� ����� �� �ְ�. �ִ� 10��
//�ߺ� ��� X
//�ߺ� : �̸�, Ű , ������ ������ ��
//���ؿ� ���� ���踦 �ؼ� ����� ��������մϴ�.

//ȸ��
//�̸�
//Ű
//������

//BMI ����
//BMI = ������(kg) / Ű^2(m)

//�� �� : 35 �̻�
//��(��)�� �� (2�ܰ� ��) : 30 �̻� - 35 �̸�
//�浵 �� (1�ܰ� ��) : 25 �̻� - 30 �̸�
//��ü�� : 23 �̻� - 25 �̸�
//���� : 18.5 �̻� - 23 �̸�
//��ü�� : 18.5 �̸�

//��� ���� ���α׷�
//Ű ��(��������)���� ����� ��ȸ�ϱ�
//----------------------------
//������ ��(��������)���� ����� ��ȸ�ϱ� << �����Ŷ� ������ �� �ϰ� �� ��~~

class Member implements Comparable {
	private boolean membership;
	private String name;
	private double height;
	private double weight;

	public Member() {
	}

	public Member(String name, double height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public boolean isMember() {
		return membership;
	}

	public void setMember(boolean member) {
		this.membership = member;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	// BMI ���� ���
	public double getBmi(double height, double weight) {
		return (weight / ((height / 100) * (height / 100)));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Member))
			return false;
		Member other = (Member) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[�̸�= " + name + ", Ű= " + height + ", ������= " + weight + ", BMI= " + getBmi(height, weight) + "]";
	}
	
	@Override
	public int compareTo(Object member) {
		Member other = (Member) member;
		return (int) (this.height - other.height);
	}
	
	public int compareToWeight(Object member) {
		Member other = (Member) member;
		return (int) (this.weight - other.weight);
	}
}