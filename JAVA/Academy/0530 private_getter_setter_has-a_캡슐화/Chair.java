public class Chair {
	String manufacturer;
	String date;
	int price;
	String model;
	
	public Chair(String m, String d, int p, String n){
		manufacturer = m;
		date = d;
		price = p;
		model = n;
	}
	
	void printAll() {
		System.out.println(manufacturer);
		System.out.println(date);
		System.out.println(price);
		System.out.println(model);		
	}

	public static void main(String[] args) {
		Chair c = new Chair("제조사", "2022-09-05", 75000, "모델");
		c.printAll();
	}
}