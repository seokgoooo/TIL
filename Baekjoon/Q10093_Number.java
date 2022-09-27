import java.util.*;

public class Q10093_Number {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		long start = sc.nextLong();
		long end = sc.nextLong();

		if (start > end) {
			long temp = end;
			end = start;
			start = temp;
		}

		if (start == end) {
			System.out.println(0);
		} else {
			System.out.println(end - start - 1);
			start++;
			for (; start < end; start++) {
				System.out.print(start + " ");
			}
		}
	}
}