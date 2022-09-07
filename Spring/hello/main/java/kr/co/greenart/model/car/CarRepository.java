package kr.co.greenart.model.car;

import java.util.List;

public interface CarRepository {
	// ��ü �� ��� ��ȸ
	public List<Car> getAll();

	// ���̵�� �˻��Ͽ� �ϳ��� �� ��ȸ
	public Car getById(int id);

	// �ϳ��� �� �߰�
	public int add(Car car);

	// �ڵ��� ��� �߰� �ϱ�
	public int[] batchInsert(List<Car> list);

	// �ϳ��� �� ����
	public int update(Car car);

	// �ϳ��� �� ����
	public int delete(int id);

}