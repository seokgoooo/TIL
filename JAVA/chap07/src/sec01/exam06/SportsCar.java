package sec01.exam06;

public class SportsCar extends Car {
	@Override
	public void speedUp() { speed += 10; }
	
	@Override
	public void stop() {
		System.out.println("½ºÆ÷Ã÷Ä«¸¦ ¸ØÃã");
		speed = 0;
	}
}