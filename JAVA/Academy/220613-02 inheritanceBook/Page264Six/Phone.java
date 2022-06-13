package Page264Six;

class Phone {
	private String maker;
	private int price;
	private String type;

	public Phone(String maker, int price, String type) {
		this.maker = maker;
		this.price = price;
		this.type = type;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return maker + price + "" + type;
	}
}
