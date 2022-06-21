import java.time.LocalDate;

interface LeafletHandler {
	String give();
}

// 위의 인터페이스를 구현하는 클래스를 작성. 추상메소드를 오버라이드 해야 합니다. 구현 바디는 (전화번호 문자열 반환)
// class 일수 광고 전단지 제공자
// 일수 광고는 전화번호가 포함되어야함.
class MoneyAdImp implements LeafletHandler {
	String phoneNumber;

	public MoneyAdImp(String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String give() {
		return phoneNumber;
	}
}

// class 선거 광고 전단지 제공자
// 선거 광고는 선거 날짜가 포함되어야 함.
class ElectionAdImp implements LeafletHandler {
	LocalDate electionDate;

	public ElectionAdImp(LocalDate electionDate) {
		super();
		this.electionDate = electionDate;
	}

	@Override
	public String give() {
		return "투표날짜 : " + electionDate.toString();
	}
}

// --------------------------
// class 광고 대행사
// 일수 광고 or 선거 광고를 할 수 있음
class AdCompany {
	private LeafletHandler ad;

	public AdCompany(LeafletHandler ad) {
		super();
		this.ad = ad;
	}

	public LeafletHandler getAd() {
		return ad;
	}

	public void setLeaf(LeafletHandler leaf) {
		this.ad = leaf;
	}

	public void consoleAd() {
		System.out.println(ad.give());
	}
}

public class Leaflet {
	public static void main(String[] args) {
		LeafletHandler h1 = new MoneyAdImp("828-4304");
		String moneyAd = h1.give();
		System.out.println(moneyAd);

		LeafletHandler h2 = new ElectionAdImp(LocalDate.now());
		String electionAd = h2.give();
		System.out.println(electionAd);

		AdCompany p = new AdCompany(h1);
		p.consoleAd();
		
		p.setLeaf(h2);
		p.consoleAd();
		
//		광고대행사 p = new 광고대행사(일수광고);
//		p.광고() <<< 일수광고
//		
//		p.set고객(선거광고);
//		p.광고() <<< 선거광고

	}
}