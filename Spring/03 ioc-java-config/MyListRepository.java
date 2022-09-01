package kr.co.greenart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component("mylist")

// @Service : Component 랑 똑같은데 Service (로직을 가지고 있는) 역할을 하는 Component
// @Repository : Component 랑 똑같은데 Repository (저장소) 역할을 하는 Component
// @Configuration : 설정을 가지고 있는 Component (LIKE xml)
public class MyListRepository implements MyDataRepository {
	@Autowired
	private List<Integer> list;

	@Override
	public Iterable<Integer> getMyNumbers() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		return list;
	}
}