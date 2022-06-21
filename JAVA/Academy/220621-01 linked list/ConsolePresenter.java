import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsolePresenter {
	// 4번
	private WeatherManage manager;

	public ConsolePresenter() {
		manager = new WeatherManageImp();
	}

	public void start() {
		while (true) {
			menu();
			Scanner scan = new Scanner(System.in);
			int button = scan.nextInt();
			switch (button) {
			case 1:
				add();
				break;
			case 2:
				list();
				break;
			case 3:
				edit();
				break;
			case 4:
				delete();
				break;
			default:
				System.out.println("없는 메뉴");
			}
		}
	}

	public void menu() {
		System.out.print(
				"===1. 일기 목록===2. 일기 목록 정렬 (날짜 순)===3. 일기 목록 정렬 (내용 길이 순)===4. 일기 등록===5. 일기 수정===6. 일기 삭제===0. 종료===");
		System.out.println();
	}

	public void add() {
		Scanner scan = new Scanner(System.in);
		System.out.print("날짜? yyyy-mm-dd 예)2022-06-21");
		String day = scan.nextLine();
		System.out.print("제목? ");
		String title = scan.nextLine();
		System.out.print("날씨? ");
		String weather = scan.nextLine();
		System.out.print("내용? ");
		String content = scan.nextLine();

		LocalDate dayTransform = LocalDate.parse(day);
		manager.add(new Weather(dayTransform, title, weather, content));
	}

	public void list() {
		System.out.println("===일기 목록===");
		List<Weather> list = manager.list();
		for (Weather w : list) {
			System.out.println(w);
		}
	}

	public void edit() {
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 날짜? ");
		String day = scan.nextLine();
		LocalDate dayTransform = LocalDate.parse(day);

		System.out.print("내용? ");
		String content = scan.nextLine();

		boolean result = manager.edit(dayTransform, content);
		System.out.println(result + " ");
		
	}

	public void delete() {
		manager.deleteFirst();
		System.out.println("삭제 완료");
	}
}