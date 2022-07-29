package fourletters;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.co.greenart.dbutil.QuizDBUtil;
import user.User;
import user.UserDao;

public class Main extends JFrame {
	Dao dao = new FourlettersDaoImpl();
	private User user;

	public Main(User user) {
		this.user = user;
		Button bt = new Button();
		bt.favListAdd(user.getId());
		bt.ListAdd(user.getId());

		JPanel pnlMain = new JPanel();
		JPanel pnlLEFT = new JPanel();
		JPanel pnlRight = new JPanel();

		// 문제와 정답을 맞출 텍스트 필드들
		JTextArea ta = new JTextArea(50, 20);
		JTextField tf = new JTextField(20);
		JTextArea ta2 = new JTextArea(2, 20);

		// 폰트
		Font font = new Font("맑은 고딕", Font.BOLD, 32);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 24);
		ta.setFont(font);
		ta2.setFont(font2);

		// 왼쪽 버튼
		JButton btn1 = new JButton("확인");
		JButton btn2 = new JButton("문제보기");
		JButton btn3 = new JButton("힌트");
		JCheckBox cb1 = new JCheckBox("즐겨찾기");

		// 오른쪽 버튼
		JButton btn4 = new JButton("힌트");
		JButton btn5 = new JButton("즐겨찾기");
		JButton btn6 = new JButton("랭킹보기");

		// 왼쪽 객관식 버튼
//		JButton[] bt = new JButton[4];
		JButton[] bt2 = new JButton[4];

		btn1.setBounds(50, 50, 100, 100);
		btn2.setBounds(50, 50, 100, 100);
		btn3.setBounds(150, 50, 100, 100);

		// 왼,오 하위 Panel
		JPanel pnlL1 = new JPanel();
		JPanel pnlL2 = new JPanel();

		JPanel pnlR1 = new JPanel();
		JPanel pnlR2 = new JPanel();
		JPanel pnlR3 = new JPanel();

		// panel 레이아웃
		pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.X_AXIS));
		pnlLEFT.setLayout(new BoxLayout(pnlLEFT, BoxLayout.Y_AXIS));
		pnlRight.setLayout(new BoxLayout(pnlRight, BoxLayout.Y_AXIS));

		// 테두리
		pnlLEFT.setBorder(new TitledBorder(new LineBorder(Color.pink, 3), "문제"));
		pnlRight.setBorder(new TitledBorder(new LineBorder(Color.pink, 3), "기타"));

		pnlL1.setBorder(new TitledBorder(new LineBorder(Color.green, 3), "주관식 "));
		pnlL2.setBorder(new TitledBorder(new LineBorder(Color.green, 3), "힌트"));
//		pnlL3.setBorder(new TitledBorder(new LineBorder(Color.PINK, 3), "문제 보기"));

		pnlR1.setBorder(new TitledBorder(new LineBorder(Color.CYAN, 3), "메뉴"));
		pnlR2.setBorder(new TitledBorder(new LineBorder(Color.yellow, 3), "기능"));
		pnlR3.setBorder(new TitledBorder(new LineBorder(Color.MAGENTA, 3), "관리자"));

		// 메인
		GridLayout grid = new GridLayout(1, 2);
		pnlMain.setLayout(grid);
		setContentPane(pnlMain);
		pnlMain.add(pnlLEFT);
		pnlMain.add(pnlRight);

		// 왼쪽
		pnlLEFT.add(ta);
		pnlLEFT.add(pnlL1);
		pnlLEFT.add(pnlL2);

		// --왼쪽[1]
		pnlL1.add(tf);
		pnlL1.add(btn1);
		pnlL1.add(btn2);
		pnlL1.add(btn3);
		pnlL1.add(cb1);

		// 왼쪽[2]
		pnlL2.add(ta2);

		// 왼쪽 ta2 위치 설정
		BorderLayout fl = new BorderLayout();
		pnlL2.setLayout(fl);
		pnlL2.add(ta2, BorderLayout.CENTER);

		// 오른쪽
		pnlRight.add(pnlR1);
		pnlRight.add(pnlR2);
		pnlRight.add(pnlR3);

		// tap 메뉴
		JTabbedPane showQuizTab = new JTabbedPane();
		JPanel quizAllPnl = new JPanel();
		JPanel quizFavoritePnl = new JPanel();

		showQuizTab.addTab("전체 문제", quizAllPnl);
		showQuizTab.addTab("즐겨 찾기", quizFavoritePnl);

		pnlR1.add(showQuizTab);

		showQuizTab.setPreferredSize(new Dimension(500, 600));

		// --오른쪽[2]
		pnlR2.add(btn4);
		pnlR2.add(btn5);
		pnlR2.add(btn6);

		// 시작시 랜덤 문제 출제

		// 버튼 기능 메소드들
		bt.randomQuestion(ta);
		bt.OK_button(btn1, ta, tf, user.getId(), pnlL2, cb1);
		bt.next_button(btn2, ta, cb1, ta2);
		bt.hint_button(btn3, ta, ta2);
		bt.favoriteButton(quizFavoritePnl, ta2, tf);
		bt.favoriteCheck(quizFavoritePnl, cb1, ta, tf, this, user.getId());
		multipleChoice(quizFavoritePnl, ta, cb1);

		pnlR3.setVisible(false);
		ta2.setPreferredSize(new Dimension(500, 200));
//		ta2.setLayout();
		setSize(1180, 820);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	// 즐겨찾기 보기 버튼
	public void multipleChoice(JPanel p, JTextArea ta, JCheckBox cb1) {
		FourlettersDaoImpl fld = new FourlettersDaoImpl();
		GridLayout grid = new GridLayout(5, 6);
		JButton[] bt = new JButton[fld.favlist.size()];

		for (int i = 0; i < fld.favlist.size(); i++) {
			String[] array = String.valueOf(fld.favlist.get(i)).split(",");
			bt[i] = new JButton(Integer.valueOf(array[0]) - 2000 + "번");
			p.add(bt[i]);

			bt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent a) {
					try {
						ta.setText(dao.read(Integer.valueOf((array[0]))).toQuestion());
						int result = (dao.readst(ta.getText()).toNumber());
						if (fld.favlist.contains(result)) {
							cb1.setSelected(true);
						} else {
							cb1.setSelected(false);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
		}

		grid.setVgap(5); // 격자 사이 수직 간격 5 픽셀
		p.setLayout(grid);
	}

//	public static void main(String[] args) {
//		new Main().setVisible(true);
//	}
}
