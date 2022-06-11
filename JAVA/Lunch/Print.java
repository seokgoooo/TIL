public class Print {
	String[] strArr = new String[10];
	int[] count = new int[10];
	int count1 = 0;
	int count2 = 0;
	int count3 = 0;
	int count4 = 0;
	int count5 = 0;
	int count6 = 0;
	int count7 = 0;
	int count8 = 0;
	int count9 = 0;
	int count10 = 0;

	public void first() {
		System.out.println("오늘의 점심 메뉴는??????????");
	}

	public void printAll() {
		for (int i = 0; i < count.length; i++) {
			strArr = new String[] {"파스타", "곱도리탕", "쌀국수", "일식돈가스", };
			String randomValue = strArr[(int) Math.floor(Math.random() * strArr.length)];
			System.out.println(randomValue);

			if (randomValue == "파스타") {
				count1++;
			} else if (randomValue == "곱도리탕") {
				count2++;
			} else if (randomValue == "쌀국수") {
				count3++;
			} else if (randomValue == "일식돈가스") {
				count4++;
			}
		}
		System.out.println("**************************");
		System.out.println(strArr[0] + " : " + count1);
		System.out.println(strArr[1] + " : " + count2);
		System.out.println(strArr[2] + " : " + count3);
		System.out.println(strArr[3] + " : " + count4);
		System.out.println("**************************");
	}
}