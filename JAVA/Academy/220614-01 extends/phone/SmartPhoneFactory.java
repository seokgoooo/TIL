package phone;
public class SmartPhoneFactory {
	public static SmartPhone iphoneSE3() {
		return new SmartPhone("사과", 80, "5g", "IOS", 15, 32, true, true);
	}
}
