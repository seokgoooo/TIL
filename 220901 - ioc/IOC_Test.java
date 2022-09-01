import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybeans.MyBean;
import mybeans.MyLogic;
import mybeans.MyStatefulObj;

public class IOC_Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
		MyBean b = context.getBean(MyBean.class);

		b.hello();

		System.out.println("=============================================================");

//		parameter�� id�� ������ Object Ÿ���� ��ȯ�ϱ� ������ �ٿ�ĳ����.
		MyBean b2 = (MyBean) context.getBean("first");
		b2.hello();

		System.out.println(b == b2);

		MyLogic logic = context.getBean(MyLogic.class);
		logic.someMethod();

		System.out.println("=============================================================");
//		�������� ��ü �ϳ��� �����. (�̱���) ���� ������ ����Ų��.
//		scope = ������Ÿ������ �����ϸ� ��ü�� ��û�� �� ���� ���Ӱ� �ν��Ͻ��� ���� �ش�.
//		������Ÿ���� ioc�� ���� ����� �ƴϴ�. (�����ڰ� ���� �������)
//		NoUniqueBeanDefinitionException : bean�� ���� Ÿ���� 2���� ����� ����
//		id�� �������ְų� primary�� true ������ ���ָ� primary ������ bean�� ��ȯ�Ѵ�.

		MyStatefulObj third = context.getBean(MyStatefulObj.class);
		System.out.println(third.toString());
		third.setName("new-name");
		third.setNumber(200);

		MyStatefulObj oneMoretime = context.getBean(MyStatefulObj.class);
		System.out.println(oneMoretime.toString());
		System.out.println(third == oneMoretime);

		System.out.println("=============================================================");

		MyStatefulObj fourth = context.getBean("fourth", MyStatefulObj.class);
		System.out.println(fourth.toString());
	}
}