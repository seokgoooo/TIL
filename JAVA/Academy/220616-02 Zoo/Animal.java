	// Animal class (필드 + 메소드) : 동물의 상태와 동작을 정의
public class Animal {
	// 육식 true, 초식 false
	private boolean whatToEat;
	// 동물 종류
	private String species;
	// 동물 나이
	private int age;
	// 동물 무게
	private double weight;

	public Animal() {
	}

	public Animal(boolean whatToEat, String species, int age, double weight) {
		super();
		this.whatToEat = whatToEat;
		this.species = species;
		this.age = age;
		this.weight = weight;
	}

	public boolean isWhatToEat() {
		return whatToEat;
	}

	public void setWhatToEat(boolean whatToEat) {
		this.whatToEat = whatToEat;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Animal))
			return false;
		Animal other = (Animal) obj;
		if (age != other.age)
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		if (whatToEat != other.whatToEat)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (whatToEat == true) {
			return "[주식= 육식" + ", 종류= " + species + ", 나이= " + age + ", 무게= " + weight + "]";
		} else {
			return "[주식= 초식" + ", 종류= " + species + ", 나이= " + age + ", 무게= " + weight + "]";
		}
	}
}