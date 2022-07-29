// 할일 : 버튼 누르면 기능 실행되게 연결
//       랭킹 기능 쪽 통계 활용, 표현 방법 고민
// 완료 : GUI 구현

package secondFrame;

import javax.swing.JFrame;
import javax.swing.UIManager;

import capitals.CrudFrame;
import capitals.QuizFrame;
import fourletters.Main;
import fourletters.ManagerMode;
import music.MusicManagerMode;
import music.MusicQuiz;
import ranking.MainRank;
import user.User;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;

public class SecondFrame extends JFrame implements ActionListener {
	private JButton[] btn = new JButton[4];
	private User user;

	MusicManagerMode musicManager = new MusicManagerMode();
	CrudFrame capitalsManager = new CrudFrame();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SecondFrame() {
		super();
		setTitle("선택");
		setSize(1180, 820);
		getContentPane().setBackground(UIManager.getColor("window"));
		getContentPane().setLayout(new GridLayout(2, 2, 0, 0));

		btn[0] = new JButton("사자성어 퀴즈");
		btn[1] = new JButton("국가-수도 퀴즈");
		btn[2] = new JButton("음악 퀴즈");
		btn[3] = new JButton("랭킹 & 통계");

		for (int i = 0; i < btn.length; i++) {
			getContentPane().add(btn[i]);
			btn[i].setBackground(new Color(255, 255, 255));
			btn[i].setForeground(new Color(0, 102, 102));
			btn[i].setFont(new Font("한컴산뜻돋움", Font.PLAIN, 30));
			btn[i].addActionListener(this);

			if (i == 1 || i == 2) {
				btn[i].setBackground(new Color(0, 102, 102));
				btn[i].setForeground(new Color(255, 255, 255));
			}
		}
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object click = e.getSource();
		if (click == btn[0]) {
			// 사자성어 퀴즈 열기
			if (user.isManager()) {
				ManagerMode fourlettersManager = new ManagerMode(user);
				fourlettersManager.setVisible(true);
			} else {
				Main fourlettersUser = new Main(user);
				fourlettersUser.setVisible(true);
				setVisible(false);

//				fourlettersMain.getHomeBtn().addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						dispose();
//						setVisible(true);
//					}
//				});

				fourlettersUser.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						dispose();
						setVisible(true);
					}
				});
			}

		} else if (click == btn[1]) {
			// 국가-수도 퀴즈 열기
			if (user.isManager()) {
				capitalsManager.setVisible(true);
			} else {
				QuizFrame capitalsUser = new QuizFrame(user);
				capitalsUser.setVisible(true);
				setVisible(false);

//				capitalsUser.getHomeBtn().addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						dispose();
//						setVisible(true);
//					}
//				});

				capitalsUser.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						dispose();
						setVisible(true);
					}
				});
			}
		} else if (click == btn[2]) {
			// 음악 퀴즈 열기
			if (user.isManager()) {
				musicManager.setVisible(true);
			} else {
				MusicQuiz musicUser = new MusicQuiz(user);
				musicUser.setVisible(true);
				setVisible(false);

				musicUser.getHomeBtn().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						setVisible(true);
					}
				});

				musicUser.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						dispose();
						setVisible(true);
					}
				});
			}
		} else if (click == btn[3]) {
			// 퀴즈 랭킹 열기
			MainRank rank;
			try {
				rank = new MainRank();
				rank.setVisible(true);
				setVisible(false);

				rank.getMusicsPnl().getHomeBtn().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						rank.dispose();
						setVisible(true);
					}
				});

				rank.getCapitalsPnl().getHomeBtn().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						rank.dispose();
						setVisible(true);
					}
				});

				rank.getFourlettersPnl().getHomeBtn().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						rank.dispose();
						setVisible(true);
					}
				});

				rank.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						dispose();
						setVisible(true);
					}
				});
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}