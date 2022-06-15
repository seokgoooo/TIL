package equals;

public class CupNoodle {
	private String maker;
	private String name;
	private int price;

	public CupNoodle(String maker, String name, int price) {
		this.maker = maker;
		this.name = name;
		this.price = price;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "cupNoodle [maker=" + maker + ", name=" + name + ", price=" + price + "]";
	}

//	hashCode() 		// 객체를 나타내는 숫자표현 ( 문자표현은 toString )
	
	@Override
	public boolean equals(Object obj) {		// 어떤 기준으로 equals 를 만들건지만 생각하자
		if (this == obj)
			return true;
		
		if (!(obj instanceof CupNoodle))
			return false;
		
		CupNoodle other = (CupNoodle) obj;		// down casting
		
		if (maker == null) {
			if (other.maker != null)			// if if 들어가면 or
				return false;
		} else if (!maker.equals(other.maker))	// 여기서 또 else if 써주면 and
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		return true;
	}
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof CupNoodle) {
//			CupNoodle other = (CupNoodle) obj;
//			return maker.equals(other.maker) && name.equals(other.name);
//		} else {
//			return false;
//		}
//	}	
}