package music;

import java.io.File;
import java.sql.SQLException;
import java.util.Scanner;

public class TestDao {
	public static void main(String[] args) {
		MusicDao dao = new MusicDaoImpl();
		MusicPlayer mp = new MusicPlayer();
		Music result = null;
		String path = "src\\music\\resource\\";

		try {
			result = dao.read(3002);
		} catch (SQLException e) {
			System.out.println("파일 수정 실패");
			e.printStackTrace();
		}
		
		String title = result.getTitle();
		path += title + ".mp3";
		mp.play(new File(path));
		
		Scanner scan = new Scanner(System.in);
				
		while(true) {
			System.out.println("정답 입력");
			String answer = scan.nextLine();
			if(answer.equals(title)) {
				System.out.println("정답");
				mp.stop();
				break;
			} else {
				System.out.println("오답");
			}
		}		
		
	}
}
