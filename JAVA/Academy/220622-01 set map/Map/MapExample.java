package Map;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//중국집 주문 가격 계산기

//짜장면 : 2500
//짬봉 : 4000
//볶음밥 : 4000

//메뉴를 '추가'

//계산 결과 출력 기능
public class MapExample {
	private static final int EXIT = 0;
	private static final int ADDMENU = 1;
	private static final int CALCULATION = 2;
	private static final int PRINTMENU = 3;

	public static void main(String[] args) {
		Restaurant run = new Restaurant();
		Scanner scan = new Scanner(System.in);
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();

		// 기본 세팅
		map.put("짜장면", 2500);
		map.put("짬뽕", 4000);
		map.put("볶음밥", 4000);
		boolean on = true;
		int num = 0;

		// 프로그램
		while (on) {
			List<Integer> count = new ArrayList<>();
			Set<String> keySet = map.keySet();
			Iterator<String> iter = keySet.iterator();
			Iterator<String> iterCal = keySet.iterator();

			// 메인 메뉴
			int choice = run.printMainMenu(scan, num);
			switch (choice) {
			case ADDMENU:
				// 메뉴 추가
				run.addMenu(scan, map);
				break;

			case CALCULATION:
				int j = 0;
				int total = 0;
				// 전체 메뉴 보기
				run.printMenu(map, iter);

				// 메뉴 개수 입력받기
				run.inputCal(scan, map, count);

				// 계산 결과 출력
				run.printCal(map, count, iterCal, j, total);
				break;

			case PRINTMENU:
				run.printMenu(map, iter);
				break;

			case EXIT:
				on = false;
				break;

			default:
				break;
			}
		}
	}
}

class Restaurant {
	// 메인 메뉴
	public int printMainMenu(Scanner scan, int num) {
		while (true) {
			try {
				System.out.print("===1. 메뉴 추가===2. 계산 하기===3. 전체 메뉴===0. 종료===");
				System.out.println();
				num = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("숫자 입력하세요");
				System.out.println();
				scan.nextLine();
				continue;
			}
			break;
		}
		return num;
	}

	// 메뉴 추가
	public void addMenu(Scanner scan, Map<String, Integer> map) {
		scan.nextLine();
		String menu = scan.nextLine();
		int price = scan.nextInt();
		if (!map.containsKey(menu)) {
			map.put(menu, price);
			System.out.println("===추가 완료===");
			System.out.println();
		} else {
			System.out.println("있는 메뉴 에요");
			System.out.println();
		}
	}

	// 전체 메뉴 보기
	public void printMenu(Map<String, Integer> map, Iterator<String> iter) {
		System.out.println("=====전체 메뉴=====");
		while (iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
			System.out.println(key + " : " + value + "원");
		}
		System.out.println();
	}

	// 메뉴 개수 입력받기
	public void inputCal(Scanner scan, Map<String, Integer> map, List<Integer> count) {
		while (true) {
			try {
				for (int i = 0; i < map.size(); i++) {
					System.out.print("메뉴 순서대로 몇 그릇? ");
					count.add(scan.nextInt());
				}
			} catch (InputMismatchException e) {
				System.out.println("숫자 입력하세요");
				System.out.println();
				scan.nextLine();
				continue;
			}
			break;
		}
	}

	// 계산 결과 출력
	public void printCal(Map<String, Integer> map, List<Integer> count, Iterator<String> iterCal, int j, int total) {
		while (iterCal.hasNext()) {
			String key = iterCal.next();
			Integer value = map.get(key);
			int calMoney = value * count.get(j);
			total += calMoney;
			System.out.println(key + " : " + calMoney + "원");
			j++;
		}
		System.out.println("총 : " + total + "원");
		System.out.println();
	}
}
