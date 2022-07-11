import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Book644_2 {
	public static void main(String[] args) {
		BufferedReader br = null;
		List<Integer> list = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader("d:\\filetest\\page644_2.txt"));

			String line;
			while ((line = br.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					list.add((int) line.charAt(i));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(list);

		List<Character> charList = new ArrayList<Character>();
		for (int i = 0; i < list.size(); i++) {
			if (97 <= list.get(i) && list.get(i) <= 119) {
				charList.add((char) (list.get(i) - 29));
			} else if (list.get(i) == 120) {
				charList.add((char) (65));
			} else if (list.get(i) == 121) {
				charList.add((char) (66));
			} else if (list.get(i) == 122) {
				charList.add((char) (67));
			} else if (list.get(i) == 32) {
				charList.add((char) (32));
			}
		}
		System.out.println(charList);

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("d:\\filetest\\page644_2.txt"));
			for (int i = 0; i < charList.size(); i++) {
				pw.print(charList.get(i));
			}
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
}
