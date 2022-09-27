import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> list;
		MyHolder<String> h1 = new MyHolder("��Ʈ���� ������ ��ü");
		MyHolder<Integer> h2 = new MyHolder(199);

		MyPair<String, Integer> p1 = new MyPair("Ű", 456);
		MyPair<String, String> p2 = new MyPair("��Ʈ��Ű", "��Ʈ�����");

		MyHolder h3 = new MyHolder();
	}
}

class MyHolder<T> {
	private T o;

	public MyHolder() {

	}

	public MyHolder(T o) {
		super();
		this.o = o;
	}

	public T getO() {
		return o;
	}

	public void setO(T o) {
		this.o = o;
	}
}

class MyPair<K, V> {
	private K key;
	private V value;

	public MyPair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}