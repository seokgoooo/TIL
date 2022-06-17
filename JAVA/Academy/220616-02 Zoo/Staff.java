import java.util.Arrays;
	// Staff class (필드 + 메소드) : 직원의 상태와 동작을 정의
public class Staff {
	// 직원 담당 (조련사, 경영 등)
	private String job;
	// 직원 이름
	private String name;
	// 조련사는 동물들을 담당
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
			return "직원 : 담당 =" + job + ", 이름= " + name + ", 담당 동물 = 없음";
		} else 
		return "직원 : 담당= " + job + ", 이름= " + name + ", 담당 동물= " + animal;
	}
}