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

//		parameter를 id로 적으면 Object 타입을 반환하기 때문에 다운캐스팅.
		MyBean b2 = (MyBean) context.getBean("first");
		b2.hello();

		System.out.println(b == b2);

		MyLogic logic = context.getBean(MyLogic.class);
		logic.someMethod();

		System.out.println("=============================================================");
//		스프링은 객체 하나만 만든다. (싱글톤) 같은 참조를 가리킨다.
//		scope = 프로토타입으로 설정하면 객체를 요청할 때 마다 새롭게 인스턴스를 만들어서 준다.
//		프로토타입은 ioc의 관리 대상이 아니다. (개발자가 관리 해줘야함)
//		NoUniqueBeanDefinitionException : bean에 같은 타입이 2개라서 생기는 에러
//		id를 지정해주거나 primary로 true 설정을 해주면 primary 설정된 bean을 반환한다.

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
