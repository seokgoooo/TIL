package car;
public class Main {
	public static void main(String[] args) {
		SportsCar c = new SportsCar();
		c.color = "Red";
		c.speedUp(100);
		c.speedDown(30);
		c.setTurbo(true);
		
		Car normalCar = new Car();
		normalCar.color = "Green";
		normalCar.speedUp(30);
		normalCar.speedDown(20);
//		normalCar.setTurbo(true);
	}
}
