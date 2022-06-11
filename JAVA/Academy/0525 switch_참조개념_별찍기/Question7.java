// 2 ~ 100 사이 모든 소수 출력하기
public class Question7 {
	public static void main(String[] args) {
		int i = 3;
		int prime = 0;
		
		System.out.print(2 + " ");
		while (i < 101) {
			
			for (int j = 2; j < 100; j++) {
				
				if (i % j == 0) {
					
					break;
					
				} else {
				
					prime = i;
					System.out.print(prime + " ");
					break;
					
				}
			}
		
			i++;
			
		}
	}
}