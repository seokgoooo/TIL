import java.sql.SQLException;

import javax.swing.UIManager;

import firstFrame.FirstFrame;

// Main 프로그램 클래스
// GUI 사이즈 setSize(1180, 820)
public class Main {
	public static void main(String[] args) throws SQLException {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		}
		new FirstFrame();
	}
}