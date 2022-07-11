import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Book644_1 {
	public static void main(String[] args) {
		BufferedReader br = null;
		List<Double> list = new ArrayList<>();

		try {
			br = new BufferedReader(new FileReader(new File("d:\\filetest\\page644_1.txt")));

			while (true) {
				Double num = Double.valueOf(br.readLine());

				list.add(num);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		list.sort(null);
		System.out.println(list);

		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new File("d:\\filetest\\page644_1.txt"));
			for (int i = 0; i < list.size(); i++) {
				pw.println(list.get(i));
			}
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
}
