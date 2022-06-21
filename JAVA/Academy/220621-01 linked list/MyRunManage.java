import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyRunManage {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Weather> list = new LinkedList<Weather>();
		list.add(new Weather(LocalDate.now(), "제목1", "날씨1", "1내1용1"));
		list.add(new Weather(LocalDate.of(2022, 06, 20), "ㅁ", "ㄴ", "ㅇ"));

		boolean on = true;
		int button = 0;

		while (on) {
			// 예외 반복문 처리하기
			while (true) {
				try {
					System.out.print(
							"===1. 일기 목록===2. 일기 목록 정렬 (날짜 순)===3. 일기 목록 정렬 (내용 길이 순)===4. 일기 등록===5. 일기 수정===6. 일기 삭제===0. 종료===");
					System.out.println();
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
			// case의 상수 같은 경우는 따로 interface를 만들어서 final 상수로 적용시켜보자
			case 1:
//					일기 목록 출력
				System.out.println("=====일기 목록=====");
				for (Weather print : list) {
					System.out.println(print);
				}
				System.out.println();
				break;

			case 2:
//	 				정렬 날짜 순
				Comparator<Weather> comparator = new Comparator<Weather>() {
					@Override
					public int compare(Weather o1, Weather o2) {
						return o1.getDay().compareTo(o2.getDay());
					}
				};
				Collections.sort(list, comparator);

				System.out.println("=====일기 목록 정렬 (날짜 순)=====");
				for (Weather print : list) {
					System.out.println(print);
				}
				System.out.println();
				break;

			case 3:
//	 				정렬 내용 길이 순
				Collections.sort(list);

				System.out.println("=====일기 목록 정렬 (내용 순)=====");
				for (Weather print : list) {
					System.out.println(print);
				}
				System.out.println();
				break;

			case 4:
//	 				일기 등록 (같은 날짜에는 일기 중복 X)

				System.out.print("연도 입력 (숫자): ");
				int year = scan.nextInt();
				System.out.print("월 입력 (숫자): ");
				int month = scan.nextInt();
				System.out.print("일 입력 (숫자): ");
				int date = scan.nextInt();

				scan.nextLine();
				System.out.print("제목 입력: ");
				String title = scan.nextLine();
				System.out.print("날씨 입력: ");
				String weatherType = scan.nextLine();
				System.out.print("내용 입력: ");
				String content = scan.nextLine();

				Weather input = new Weather(LocalDate.of(year, month, date), title, weatherType, content);

				int check = 0;
				for (int i = 0; i < list.size(); i++) {
					if (input.equals(list.get(i))) {
						check++;
					}
				}

				if (check == 0) {
					list.add(input);
					System.out.println("=====추가 완료=====");
					System.out.println();
				} else {
					System.out.println("=====날짜 중복=====");
					System.out.println();
				}

				break;

			case 5:
//	 				날짜를 선택해서 해당 일기 내용을 수정 가능
				System.out.print("연도 입력 (숫자): ");
				int correctYear = scan.nextInt();
				System.out.print("월 입력 (숫자): ");
				int correctMonth = scan.nextInt();
				System.out.print("일 입력 (숫자): ");
				int correctDate = scan.nextInt();

				scan.nextLine();
				System.out.print("내용 입력: ");
				String correctContent = scan.nextLine();

				int i = 0;

				Weather correct = new Weather(LocalDate.of(correctYear, correctMonth, correctDate),
						list.get(i).getTitle(), list.get(i).getWeatherType(), correctContent);

				for (i = 0; i < list.size(); i++) {
					if (list.get(i).equals(correct)) {
						list.set(i, correct);
					} else {
						System.out.println("입력된 날짜가 없습니다");
					}
				}

				break;

			case 6:
//	 				삭제 - 가장 오래된 일기가 삭제됨.
				if (list.size() > 0) {
					((LinkedList<Weather>) list).removeLast();
					System.out.println("=====일기 삭제=====");
					for (Weather print : list) {
						System.out.println(print);
					}
					System.out.println();					
				} else {
					System.out.println("남은 목록 없음");
				}
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