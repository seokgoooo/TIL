
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybeans.FirstComponent;
import mybeans.SecondComponent;
import mybeans.ThirdComponent;

public class TestComponent {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
//		annotation���� ���� ����
		FirstComponent comp = context.getBean(FirstComponent.class);
		comp.hello();

		FirstComponent byName = context.getBean("firstComp", FirstComponent.class);
		byName.hello();

		System.out.println(comp == byName);

		System.out.println("=========================================================");
//		�������� �ʿ��� ��ü ����
//		@Autowired�� �����ڳ� setter�� �ʵ� ���� ���ָ� beans�� �� Ÿ���� ������ �ڵ����� �־��ش�.
		SecondComponent second = context.getBean(SecondComponent.class);
		System.out.println(second);
		second.myServiceMethod();

		System.out.println("=========================================================");

		ThirdComponent third = context.getBean(ThirdComponent.class);
		third.printValue();
	}
}