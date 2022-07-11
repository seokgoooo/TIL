import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Book644_2_1 {
	public static void main(String[] args) {
		BufferedReader br = null;
		List<Integer> list = new ArrayList<Integer>();

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

		List<Character> charList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (68 <= list.get(i) && list.get(i) <= 90) {
				charList.add((char) (list.get(i) + 29));
			} else if (list.get(i) == 65) {
				charList.add((char) (120));
			} else if (list.get(i) == 66) {
				charList.add((char) (121));
			} else if (list.get(i) == 67) {
				charList.add((char) (122));
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
