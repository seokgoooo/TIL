// 은행 계좌
// 필드 : 잔고 (int)
// 메소드 : 	입금(int) : void
//			출금(int) : void	>> 출금액이 보유 잔고 이상일 때 예외 (부족한 금액이 얼마?)를 발생시켜서 throws...
//			getter() : int

class BankAccount {
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void deposit(int money) {
		this.balance += money;
	}

	public void withdraw(int money) throws MyBankBalanceMinusException {
		if (this.balance >= money) {
			this.balance -= money;
		} else {
			// 예외 상황에 보고서 (다른 클래스)로 던져버리자
			throw new MyBankBalanceMinusException("잔액 부족", (money - balance));
		}
	}
}

class MyBankBalanceMinusException extends RuntimeException {
	private int lack;
	
	public int getLack() {
		return lack;
	}
	
	public MyBankBalanceMinusException(String message, int lack) {
		super(message + " " + lack);
		this.lack = lack;
	}
}

public class Main6 {
	public static void main(String[] args) {

		// 은행 계좌 객체 생성
		BankAccount your = new BankAccount();

		// 입금 / 출금 / 게터 테스트
		your.deposit(10000);
		System.out.println(your.getBalance());
		your.withdraw(5000);
		System.out.println(your.getBalance());

		// 출금 // 예외 처리 (메시지만 콘솔창에 볼 수 있게)
		try {
			your.withdraw(50000);
			System.out.println(your.getBalance());
		} catch (MyBankBalanceMinusException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getLack());
		}
		
	}
}