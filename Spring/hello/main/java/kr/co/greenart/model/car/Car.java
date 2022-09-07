package kr.co.greenart.model.car;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class Car {
	private int id;
	@NotBlank(message = "�̸��� �Է����ּ���")
	private String model;
	@Positive(message = "����� �Է����ּ���")
	private int price;

	public Car() {

	}

	public Car(int id, String model, int price) {
		super();
		this.id = id;
		this.model = model;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", price=" + price + "]";
	}
}