package equals;

public class Car {
	private String model;

	public Car(String model) {
		this.model = model;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Car) {
			Car otherCar = (Car) obj;
			return model.equals(otherCar.model);
		} else {
			return false;
		}
	}
}
