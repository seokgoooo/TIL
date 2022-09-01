package kr.co.greenart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "kr.co.greenart")
public class MyConfig {

	@Bean
	public List<Integer> myList() {
		return new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
	}

	@Bean
	public Set<Integer> mySet() {
		return new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
	}
}