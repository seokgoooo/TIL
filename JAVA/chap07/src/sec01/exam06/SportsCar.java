package sec01.exam06;

public class SportsCar extends Car {
	@Override
	public void speedUp() { speed += 10; }
	
	@Override
	public void stop() {
		System.out.println("������ī�� ����");
		speed = 0;
	}
}