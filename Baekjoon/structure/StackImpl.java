package structure;
//	스택 구현
public class StackImpl {
	final static int MX = 1000005;
	int dat[] = new int[MX];
	int pos = 0;

	void push(int x) {
		dat[pos++] = x;
	}

	void pop() {
		pos--;
	}

	int top() {
		return dat[pos - 1];
	}

	void test() {
		push(5);
		push(4);
		push(3);
		System.out.println(top()); // 3
		pop();
		pop();
		System.out.println(top()); // 5
		push(10);
		push(12);
		System.out.println(top()); // 12
		pop();
		System.out.println(top()); // 10
	}

	public static void main(String[] args) {
		new StackImpl().test();
	}

}
