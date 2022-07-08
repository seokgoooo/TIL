import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Example {
	public static void main(String[] args) {
//		파일 생성 (직접 손으로) persons.txt
		File file = new File("d:\\filetest\\persons.txt");
		PrintWriter pw = null;
		BufferedReader br = null;
		int sum = 0;
		int count = 0;

		try {
			pw = new PrintWriter(new FileWriter(file));

			pw.println("홍길동,22");
			pw.println("둘리,33");
			pw.println("도우너,44");
			pw.flush();

			br = new BufferedReader(new FileReader(file));
			String line;
//		파일 정보를 한 줄 씩 읽어서 1-1. 콘솔 출력
			while ((line = br.readLine()) != null) {
				System.out.println(line);

				int index = line.indexOf(',');
				System.out.println("인덱스 : " + index);
				String strAge = line.substring(index + 1);
				System.out.println("strAge : " + strAge);
				Integer age = Integer.valueOf(strAge);

				System.out.println("문장에서 숫자 뽑기 : " + age);
				System.out.println();
				sum += age;
				count++;
			}
//		1-2. 사람 평균 나이 구해서 콘솔 출력
			System.out.println("평균 나이 : " + sum / count);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

//		2. lotto.txt 출력
//		1000 : [1, 2, 3, 4, 5, 6]
//		1001 : [7, 8, 9, 10, 11, 12]
//		1002 : [13, 14, 15, 16, 17, 18]

		Map<Integer, Set<Integer>> lotto = new LinkedHashMap<>();
		lotto.put(1000, new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lotto.put(1001, new HashSet<Integer>(Arrays.asList(7, 8, 9, 10, 11, 12)));
		lotto.put(1002, new HashSet<Integer>(Arrays.asList(13, 14, 15, 16, 17, 18)));

//		먼저 콘솔
		Set<Integer> keySet = lotto.keySet();
		for (Integer i : keySet) {
			System.out.println(i + " : " + lotto.get(i));
		}

//		파일에 쓰기
		File lottoFile = new File("d:\\filetest\\lotto.txt");
		try {

			pw = new PrintWriter(lottoFile);
			Set<Integer> keySetText = lotto.keySet();
			for (Integer i : keySetText) {
				pw.println(i + " : " + lotto.get(i));
			}
			pw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

		PrintWriter pw2 = null;
		try {
			pw2 = new PrintWriter(new FileWriter(lottoFile, true));
			pw2.println("새 번호: 20,22,24,26,28,30");
		} catch (IOException e) {

		} finally {
			pw2.close();
		}
	}
}