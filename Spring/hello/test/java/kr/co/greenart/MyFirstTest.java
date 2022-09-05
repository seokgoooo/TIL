package kr.co.greenart;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.co.greenart.model.User;

public class MyFirstTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
		int a = 10;
		int b = 20;

		int sum = a + b;
//		같은 값일 때 통과
		assertEquals(30, sum);
	}

	@Test
	public void test2() {
		String abc = "abc";
		String abc2 = abc;

//		같은 참조일 때 통과
		assertSame(abc2, abc2);
	}

	@Test
	public void test3() {
		User u = new User();

		assertNotNull(u);
	}
}