public class LunchMenu {	
	public static void main(String[] args) {
		System.out.println("오늘의 점심");
		String[] strArray = new String[6];
		strArray = new String[] {"도연정", "아지트", "중국집", "보쌈", "찌개", "국수", "국밥"};
		String randomValue = strArray[(int) Math.floor(Math.random() * strArray.length)];
		System.out.println(randomValue);
	}
}

