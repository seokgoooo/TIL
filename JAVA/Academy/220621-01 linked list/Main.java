import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		// (모든 원소를 순환할 때, 빠르게 접근할 때) (Fruit 자료구조 Queue : FIFO (First In First Out))
		// ArrayList는 index끼리 밀어내고 댕겨오고 한다면
		// (추가 삭제가 자주 일어날 때) LinkedList는 index끼리 선으로 연결되어있는 개념. 밀어내고 댕겨오는 대신에 연결된 선을
		// 끊어버리고 index 번호를 새로 부여한다.
		// 각자 클래스의 구현 특징을 생각해서 필요한 클래스를 사용하면 된다.
		List<String> list = new LinkedList<>();

		list.add("문자열1");

		System.out.println(list);

		List<String> listRemove = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
		listRemove.remove(0);
		listRemove.remove("C");
		System.out.println(listRemove);

		// List로 선언하고 downCasting 으로 LinkedList 형으로 변환하면 LinkedList만의 메소드를 사용할 수 있다.
		LinkedList<String> down = new LinkedList<String>(list);
		down.addFirst("AA");
		down.removeFirst();
		down.getFirst();

		// interface Queue : FIFO (First In First Out) 자료구조를 활용하기 위해 사용
		Queue<String> queue = new LinkedList<String>();
		queue.add("원소1");
		queue.offer("원소2");
		System.out.println(queue);

		String elem1 = queue.poll(); // 원소값이 비어있다면 null return
		String elem2 = queue.remove(); // 원소값이 비어있다면 NoSuchElement 에러 return
		System.out.println(elem1);
		System.out.println(elem2);
		System.out.println(queue.size());

		// interface Deque : LIFO (Last In First Out) 자료구조 활용하기 위해 사용
		Deque<String> stack = new LinkedList<>();
		stack.push("10");
		stack.push("20");
		stack.push("30");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}