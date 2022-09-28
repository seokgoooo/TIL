package a0x05;

import java.io.*;

public class Q10828_Stack {
	final static int RANGE = 100005;
	Integer[] data = new Integer[RANGE];
//	pos = size (정수의 개수)
	int pos = 0;

	void push(Integer x) {
//		push X: 정수 X를 스택에 넣는 연산이다.
		data[pos++] = x;
	}

	int pop() {
//		pop : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다.
//		만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

		if (empty() == 1) {
			return -1;
		} else {
//			여기서 pos가 0인 경우는 안 들어온다.
			int temp = data[pos - 1];
			data[--pos] = null;
			return temp;
		}
	}

	int size() {
//		size: 스택에 들어있는 정수의 개수를 출력한다.
		return pos;
	}

	int empty() {
//		empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
		if (size() == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	int top() {
//		top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		if (empty() == 1) {
			return -1;
		} else {
			return data[pos - 1];
		}
	}

	public static void main(String[] args) throws IOException {
//		입력
//		첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
//		둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
//		주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
//		문제에 나와있지 않은 명령이 주어지는 경우는 없다.
//		출력
//		출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
		Q10828_Stack main = new Q10828_Stack();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int loop = Integer.parseInt(br.readLine());

		for (int i = 0; i < loop; i++) {
			String func = br.readLine();
			switch (func) {
			case "top":
				bw.write(main.top() + "\n");
				bw.flush();
				break;

			case "size":
				bw.write(main.size() + "\n");
				bw.flush();
				break;

			case "empty":
				bw.write(main.empty() + "\n");
				bw.flush();
				break;

			case "pop":
				bw.write(main.pop() + "\n");
				bw.flush();
				break;

			default:
				String[] number = func.split(" ");
				Integer input = Integer.parseInt(number[1]);
				main.push(input);
				break;
			}
		}

		br.close();
		bw.close();
	}
}