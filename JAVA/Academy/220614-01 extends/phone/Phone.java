package phone;
public class Phone {
	private String production;
	private int price;
	private String commType;

	public Phone(String production, int price, String commType) {
		this.production = production;
		this.price = price;
		this.commType = commType;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCommType() {
		return commType;
	}
	public void setCommType(String commType) {
		this.commType = commType;
	}
	
	
}
