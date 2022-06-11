// 화면에 출력되는 메시지를 담당하는 클래스

import java.util.Scanner;

public class ParkViewer {
	private Scanner scanner;
	private ParkController controller;
	private final int SIZE = 5;
	private final int UNIT_MINUTE = 10;
	private final int UNIT_PRICE = 1000;
	public ParkViewer() {
		scanner = new Scanner(System.in);
		controller = new ParkController();
	}
	
	//1. 메뉴를 무한루프를 통해 출력하는 메소드
	public void showMenu() {
		while(true) {
			System.out.println("주차장 관리 프로그램");
			System.out.println("\t1. 입차");
			System.out.println("\t2. 출차");
			System.out.println("\t3. 종료");
			System.out.print("> ");
			int choice = scanner.nextInt();
			if(choice == 1) {
				//입차 메소드 실행
				insert();
			}else if(choice == 2) {
				//출차 메소드 실행
				delete();
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				scanner.close();
				break;
			}
		}
	}
	
	//차량 출차를 실행하는 메소드 delete()
	private void delete() {
		//차량 출차시
		//1. 입고된 차량이 있는지 체크
		//2. 입고된 차량이 있으면 차량번호를 입력받되 리스트에 있는 번호만 입력하게 체크
		//3. 출차시간을 입력 받되 올바르지 않으면 다시 입력
		//4. 요금 계산
		//5. 리스트에서 삭제
		
		//먼저 차량이 입차되어있는지부터 체크한다.
		//만약 한대라도 입차되어있으면
		//controller.size() 가 0보다 클 것이다.
		if(controller.size() > 0) {
			//입차된 차량이 존재하므로 출차 시작
			
			//차량 정보를 담을 객체를 하나 만든다.
			ParkVO parkVO = new ParkVO();
			
			//1. 차량 번호 입력
			parkVO.setPlateNumber(validateDeleteNumber());
			
			//하지만 이 parkVO 객체는
			//우리가 아까 입력한 객체와 일치하는 정보를 가지고 있지 않다.
			//단지 이 parkVO의 plateNumber가 우리가 가지고 있는 리스트의 객체 중
			//하나와 일치하는 plateNumber를 가졌을 뿐이다.
			//그래서 inTime은 parkVO에서는 0이다.
			//하지만 우리가 아까 입력했던 inTime을 불러올려면
			//컨트롤러의 list에서 찾아와야 한다!!!
			
			//그럼 컨트롤러에 메소드를 만들어서 파라미터로 이 parkVO를 보내고
			//해당 메소드는 리스트에서 일치하는 객체를 찾아
			//리턴 시켜주면
			//여기선 그 메소드의 결과값을 parkVO에 덮어씌어버리는 식으로 하여
			//inTime을 넣어주자
			parkVO = controller.get(parkVO);
			
			//이제 parkVO 안에 inTime이 들어가있으므로
			//출차시간을 입력받아서 유효한 시간인지 확인한다.
			int outTime = validateOutTime(parkVO);
			
			//이제 올바른 출차시간이 있으므로
			//요금 계산이 가능해진다.
			calculateRate(outTime, parkVO);
			
			//요금계산 후에 controller 안의 list에서
			//해당 객체를 삭제해준다.
			controller.remove(parkVO);
		}else {
			//입차된 차량이 없으므로 경고메시지만 출력
			System.out.println("입차된 차량이 없습니다!");
		}
	}
	
	private void calculateRate(int outTime, ParkVO p) {
		//시간의 차이를 계산
		int hourDiff = outTime / 100 - p.getInTime() / 100;
		int minDiff = outTime % 100 - p.getInTime() % 100;
		
		int totalDiff = hourDiff*60+minDiff;
		int rate = totalDiff / UNIT_MINUTE * UNIT_PRICE;
		System.out.println(p.getPlateNumber()+" 번 차량의 주차 요금은 "+rate+"원입니다.");
		
	}
	
	private int validateOutTime(ParkVO p) {
		System.out.print("출차 시간을 입력해주세요: ");
		int outTime = scanner.nextInt();
		while(!controller.validateTime(outTime) ||
				p.getInTime() > outTime) {
			System.out.println("잘못입력하셨습니다.");
			System.out.print("출차 시간을 입력해주세요: ");
			outTime = scanner.nextInt();
		}
		return outTime;
	}
	
	private String validateDeleteNumber() {
		scanner.nextLine();
		System.out.print("출차할 차량의 번호를 입력하세요: ");
		ParkVO p = new ParkVO();
		p.setPlateNumber(scanner.nextLine());
		while(!controller.contains(p)) {
			System.out.println("입차된 기록이 없습니다.");
			System.out.print("출차할 차량의 번호를 입력하세요: ");
			p.setPlateNumber(scanner.nextLine());
		}
		return p.getPlateNumber();
	}
	
	//차량 입차를 실행하는 메소드 insert()
	private void insert() {
		//차량 입차시 
		//1. 빈자리 있는지 체크
		//2. 빈자리가 존재시에는 차량번호를 입력 받되 이미 리스트에 존재하면 다시 입력
		//3. 입차시간을 입력 받되 올바르지 않으면 다시 입력
		//4. 리스트에 추가
		if(controller.size() < SIZE) {
			//빈자리가 있으므로 주차 시작
			
			//데이터를 담을 ParkVO 객체를 하나 만들어주자
			ParkVO p = new ParkVO();
			
			//1. 차량 번호를 입력 받아 리스트에 없을 때에만 p에 담는 메소드
			//   validateInsertNumber
			p.setPlateNumber(validateInsertNumber());
			
			//2. 시간을 입력받아 유효한 시간이면 p에 담는 메소드
			p.setInTime(validateInTime());
			
			//3. 준비된 ParkVO 객체 p를 controller안의 list에 담아준다.
			controller.add(p);
		}else {
			//빈자리가 없으므로 경고메시지만 출력
			System.out.println("빈 자리가 없습니다.");
		}
	}
	
	private int validateInTime() {
		System.out.print("입차 시간을 입력해주세요: ");
		int inTime = scanner.nextInt();
		while(!controller.validateTime(inTime)) {
			System.out.println("잘못된 시간 형식입니다.");
			System.out.print("입차 시간을 입력해주세요: ");
			inTime = scanner.nextInt();
		}
		
		return inTime;
				
	}
	
	
	private String validateInsertNumber() {
		System.out.print("입차할 차량의 번호를 입력하세요: ");
		scanner.nextLine();
		String number = scanner.nextLine();
		ParkVO p = new ParkVO();
		p.setPlateNumber(number);
		while(controller.contains(p)) {
			System.out.println("이미 입차된 번호입니다.");
			System.out.print("입차할 차량의 번호를 입력하세요: ");
			number = scanner.nextLine();
			p.setPlateNumber(number);
		}
		
		return number;
	}	
}