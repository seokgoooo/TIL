package sec04.exam05;
import java.util.Scanner;
public class ScannerExample {
	
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String inputData;

		while(true) {
			inputData = scanner.nextLine();
			System.out.println("�Էµ� ���ڿ�: \"" + inputData + "\"");
			if(inputData.equals("q")) {
				break;
			}
		}
		
		System.out.println("����");
	}
}