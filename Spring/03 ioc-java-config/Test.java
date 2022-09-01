package kr.co.greenart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		MyDataRepository repo = context.getBean("myset", MyDataRepository.class);
		System.out.println(repo.getMyNumbers());

		MyService service = context.getBean(MyService.class);
		System.out.println(service.numberService());

//		메소드를 Bean으로 저장하고 ""안에 메소드명을 써주면 된다.
//		메소드도 똑같이 @Autowired를 통해서 같은 타입을 자동으로 찾아준다.
		System.out.println(context.getBean("myList"));
		System.out.println(context.getBean("mySet"));
	}
}