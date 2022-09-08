package kr.co.greenart.model.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {
	@Autowired
	private CarRepository repo;

	public List<Car> list() {
		return repo.getAll();
	}

	public Car getById(int id) {
		return repo.getById(id);
	}

	public int add(Car car) {
		return repo.add(car);
	}

	public int update(Car car) {
		return repo.update(car);
	}

	// 자동차 목록을 전달받아 추가
	@Transactional
	public int[] bulkInsert(List<Car> list) {
//		int[] results = new int[list.size()];
//		for (int i = 0; i < list.size(); i++) {
//			results[i] = repo.add(list.get(i));
//		}
		int[] results = repo.batchInsert(list);
		return results;
	}

	@Transactional
	public int delete(int id) {
		return repo.delete(id);
	}
}