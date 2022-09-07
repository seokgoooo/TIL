package kr.co.greenart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.greenart.config.RootConfig;
import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
public class CarRepoTest {
	@Autowired
	private CarRepository repo;

	@Test
	public void initTest() {
		assertNotNull(repo);
	}

	@BeforeClass
//	초기 테스트 환경 세팅
//	테스트 클래스 수행전에 실행됩니다~~~ 스태틱하게 선언
	public static void addTestData() {

	}

	@Test
	public void create() {
		Random r = new Random();
		Car car = new Car();
		car.setModel("새 모델" + r.nextInt(10000));
		car.setPrice(1000);

		int result = repo.add(car);
		assertEquals(1, result);
	}

	@Test
	public void read() {
		List<Car> list = repo.getAll();

		assertNotNull(list);
	}

	@Test
	public void update() {
		int result = repo.update(new Car(1, "변경", 300));

		assertEquals(1, result);
	}
}