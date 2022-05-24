public class LoopBreak {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.println(i);
		}
				
		for (int i = 10; i < 20; i++) {
			if (i % 10 == 5) {
				continue;
			}
			System.out.println(i);
		}
		
		int i = 20;
		while (i < 30) {
			// if (i == 25) {
				// continue;
			// }
			if (i != 25) {
				System.out.println(i);	
			}
			i++;
		}
		System.out.println("프로그램 종료.");
	}
}