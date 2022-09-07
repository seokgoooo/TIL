package kr.co.greenart.model.car;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CarRepositoryListImpl implements CarRepository {
	private List<Car> list = new ArrayList<Car>();

	@Override
	public List<Car> getAll() {
		return list;
	}

	@Override
	public Car getById(int id) {
		return list.get(id);
	}

	@Override
	public int add(Car car) {
		return list.add(car) ? 1 : 0;
	}

	@Override
	public int update(Car car) {
		return list.set(car.getId(), car) != null ? 1 : 0;
	}

	@Override
	public int delete(int id) {
		return list.remove(id) != null ? 1 : 0;
	}

	@Override
	public int[] batchInsert(List<Car> list) {
		return null;
	}
}
