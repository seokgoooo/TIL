package kr.co.greenart;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.greenart.config.RootConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
public class JdbcTemplateTest {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void test() {
		int result = jdbcTemplate.queryForObject("SELECT 1", int.class);

		assertEquals(1, result);
	}
}
