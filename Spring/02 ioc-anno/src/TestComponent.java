
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybeans.FirstComponent;
import mybeans.SecondComponent;
import mybeans.ThirdComponent;

public class TestComponent {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
//		annotation으로 설정 연습
		FirstComponent comp = context.getBean(FirstComponent.class);
		comp.hello();

		FirstComponent byName = context.getBean("firstComp", FirstComponent.class);
		byName.hello();

		System.out.println(comp == byName);

		System.out.println("=========================================================");
//		의존성이 필요한 객체 연습
//		@Autowired를 생성자나 setter나 필드 위에 써주면 beans에 그 타입이 있으면 자동으로 넣어준다.
		SecondComponent second = context.getBean(SecondComponent.class);
		System.out.println(second);
		second.myServiceMethod();

		System.out.println("=========================================================");

		ThirdComponent third = context.getBean(ThirdComponent.class);
		third.printValue();
	}
}