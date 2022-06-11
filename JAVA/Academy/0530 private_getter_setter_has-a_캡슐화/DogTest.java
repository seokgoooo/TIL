public class DogTest {
	public static void main(String[] args) {
		Dog d = new Dog("이름", "종", 1);
			
		d.setName("야호");
		System.out.println(d.getName());
		
		d.setBreed("포메");
		System.out.println(d.getBreed());
		
		d.setAge(2);
		System.out.println(d.getAge());
	}
}