package mybeans;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Primary
public class ThirdComponent {
	private String value;
	private int num;

	public ThirdComponent(@Value(value = "vvvv") String value, @Value("100") int num) {
		super();
		this.value = value;
		this.num = num;
	}

	public void printValue() {
		System.out.println(value);
		System.out.println(num);
	}
}