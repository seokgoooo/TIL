package phone;
import java.time.LocalDate;

public class TestPhone {
	public static void main(String[] args) {
		Phone p = new Phone("샘송", 100, "5g");
		System.out.println(p.getProduction());
		System.out.println(p.getPrice());
		System.out.println(p.getCommType());
		
//		SmartPhone s = new SmartPhone("사과", 120, "5g", "IOS", 15.0, 64, true, true);
		
		SmartPhone s = SmartPhoneFactory.iphoneSE3();
		System.out.println(s.getProduction());
		System.out.println(s.getPrice());
		System.out.println(s.getCommType());
		System.out.println(s.getOsType());
		System.out.println(s.getOsVersion());
		System.out.println(s.getMemorySize());
		System.out.println(s.isHasCamera());
		System.out.println(s.isSupportBluetooth());
	}
}
