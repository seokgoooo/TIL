package sec02.exam02;

public class VehicleExample {
	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		
		vehicle.run();
//		vehicle.checkFare();
		
		Bus bus = (Bus) vehicle;	// ���� Ÿ�� ��ȯ
		
		bus.run();
		bus.checkFare();
	}
}
