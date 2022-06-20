import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FruitExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("사과", "포도", "오렌지", "배", "수박"));
		Scanner scan = new Scanner(System.in);
		boolean on = true;
		int button = 0;

		while (on) {
			// 예외 반복문 처리하기
			while (true) {
				try {
					System.out.print("===1. 과일 목록===2. 과일 주기===3. 과일 추가===0. 종료===");
					button = scan.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("숫자 입력하세요");
					// 버퍼를 제거해줘야 남아있는 입력이 없어져서 에러가 계속 뜨지 않는다.
					scan.nextLine();
					continue;
				}
				// 예외가 아니면 break
				break;
			}

			// 콘솔 입출력
			switch (button) {

			case 1:
				// 과일 목록 보여주기
				System.out.println(list);
				break;

			case 2:
				// 고객에게 과일 주기(제일 앞에거부터 줌)
				Iterator<String> iterator = list.iterator();
				if (list.size() > 0) {
					System.out.println(list.get(0) + " 줘");
					while (iterator.hasNext()) {
						String str = iterator.next();
						iterator.remove();
						break;
					}
					System.out.println(list);
				} else {
					System.out.println("매진");
				}
				break;

			case 3:
				// 재고 과일 추가하기 (제일 마지막에 추가) - 진열대가 최대 10개
				if (list.size() < 10) {
					scan.nextLine();
					list.add(scan.nextLine());
				} else {
					System.out.println("진열대 꽉 찼어요");
				}
				System.out.println(list);
				break;

			case 0:
				on = false;
				break;

			default:
				break;
			}
		}
	}
}