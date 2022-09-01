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

//		�޼ҵ带 Bean���� �����ϰ� ""�ȿ� �޼ҵ���� ���ָ� �ȴ�.
//		�޼ҵ嵵 �Ȱ��� @Autowired�� ���ؼ� ���� Ÿ���� �ڵ����� ã���ش�.
		System.out.println(context.getBean("myList"));
		System.out.println(context.getBean("mySet"));
	}
}