package student;

public class Main {
	public static void main(String[] args) {
		Korean k = new Korean();
		k.hello();
		
		England e = new England();
		e.hello();
		
		American a = new American();
		a.hello();
		
//		Object 클래스가 최상위기 때문에 다른 타입의 객체들을 배열로 담을 수 있다.
//		UpCasting이 일어난다
//		Object 클래스에 hello() 메소드가 정의되지 않아서 쓸 수가 없다.
		
//		Helloable (interface) 도 배열로 담을 수 있다.
		Helloable[] arr = new Helloable[3];
		arr[0] = k;
		arr[1] = e;
		arr[2] = a;
		
		for (int i = 0; i < arr.length; i++) {
			 arr[i].hello();
		}
				
		Helloable p = k;
		p.hello();
		
		Helloable p1 = e;
		p1.hello();
		
		Helloable p2 = a;
		p2.hello();
		
		Helloable p3 = new Korean();
		p3.hello();
		
		Helloable p4 = new England();
		p4.hello();
		
		Helloable p5 = new American();
		p5.hello();
	}
}