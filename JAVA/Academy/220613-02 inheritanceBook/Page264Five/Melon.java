package Page264Five;

class Melon extends Food {
	private String farm;

	public Melon(int cal, int price, double weight, String farm) {
		super(cal, price, weight);
		this.farm = farm;
	}

	public String getFarm() {
		return farm;
	}

	public void setFarm(String farm) {
		this.farm = farm;
	}
	
	public String toString() {
		return super.toString() + " 경작농원: " + farm;
	}
}
