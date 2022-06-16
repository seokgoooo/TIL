import java.util.Arrays;
	// Staff class (�ʵ� + �޼ҵ�) : ������ ���¿� ������ ����
public class Staff {
	// ���� ��� (���û�, �濵 ��)
	private String job;
	// ���� �̸�
	private String name;
	// ���û�� �������� ���
	private Animal animal;

	public Staff() {
	}

	public Staff(String job, String name, Animal animal) {
		super();
		this.job = job;
		this.name = name;
		this.animal = animal;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal getAnimals() {
		return animal;
	}
	
	public void setAnimals(Animal animal) {
		this.animal = animal;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Staff))
			return false;
		Staff other = (Staff) obj;
		if (animal == null) {
			if (other.animal != null)
				return false;
		} else if (!animal.equals(other.animal))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (animal == null) {
			return "���� : ��� =" + job + ", �̸�= " + name + ", ��� ���� = ����";
		} else 
		return "���� : ���= " + job + ", �̸�= " + name + ", ��� ����= " + animal;
	}
}