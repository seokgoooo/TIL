package ranking;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainRank extends JFrame {
	private JTabbedPane tabbedPane = null;

	private MyRankPanel musicsPnl = new MyRankPanel("music");
	private MyRankPanel fourlettersPnl = new MyRankPanel("fourletters");
	private MyRankPanel capitalsPnl = new MyRankPanel("capitals");
	private MyRankPanel totalPnl = new MyRankPanel("age");

	public MainRank() throws SQLException {
		super();
		setTitle("랭킹 & 통계");
		setSize(1180, 820);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		tabbedPane.setBounds(0, 0, 1180, 800);
		tabbedPane.addTab("음악", null, musicsPnl.getPnl(), null);
		tabbedPane.addTab("사자성어", null, fourlettersPnl.getPnl(), null);
		tabbedPane.addTab("국가수도", null, capitalsPnl.getPnl(), null);
		tabbedPane.addTab("종합", null, totalPnl.getPnl(), null);
	}

	public MyRankPanel getMusicsPnl() {
		return musicsPnl;
	}

	public MyRankPanel getFourlettersPnl() {
		return fourlettersPnl;
	}

	public MyRankPanel getCapitalsPnl() {
		return capitalsPnl;
	}

	public MyRankPanel totalPnl() {
		return totalPnl;
	}
}