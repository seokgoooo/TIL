package fourletters;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import user.User;

import javax.swing.JScrollBar;

public class ManagerMode extends JFrame {
	private User user;
	Dao dao = new FourlettersDaoImpl();

	public ManagerMode(User user) {
		this.user = user;
		Button bt = new Button();

		new JFrame("관리자 모드");
		JPanel pnlMain = new JPanel();
		JPanel pnlRight = new JPanel();

		// 문제와 정답을 맞출 텍스트 필드들
		JTextArea ta = new JTextArea();
		JTextArea ta2 = new JTextArea();
		JTextField tf = new JTextField(40);

		// 폰트
		Font font = new Font("맑은 고딕", Font.BOLD, 15);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
		Font font3 = new Font("맑은 고딕", Font.BOLD, 15);
		ta.setFont(font);
		ta2.setFont(font2);
		tf.setFont(font3);

		// 최종
		JButton bt1 = new JButton(" 확   인 ");
		JButton bt2 = new JButton("전체삭제");
		JRadioButton btn0 = new JRadioButton("문제보기");
		JRadioButton btn1 = new JRadioButton("문제추가");
		JRadioButton btn2 = new JRadioButton("문제수정");
		JRadioButton btn3 = new JRadioButton("문제삭제");

		ButtonGroup group = new ButtonGroup();
		group.add(btn0);
		group.add(btn1);
		group.add(btn2);
		group.add(btn3);

		// 왼,오 하위 Panel
		JPanel pnlL1 = new JPanel();
		JPanel pnlL2 = new JPanel();
		JPanel pnlR1 = new JPanel();
		JPanel pnlR2 = new JPanel();
		JPanel pnlR3 = new JPanel();
		JPanel pnlR0 = new JPanel();

		// 프레임에 추가
		pnlL1.setLayout(new BorderLayout());
		pnlL1.setPreferredSize(new Dimension(pnlL1.getHeight(), 400));
		pnlL2.setLayout(new BorderLayout());
		pnlL2.setPreferredSize(new Dimension(pnlL2.getWidth(), 200));
		pnlR1.setLayout(new BorderLayout());
		pnlR1.setPreferredSize(new Dimension(pnlR1.getWidth(), 100));
		pnlR1.setPreferredSize(new Dimension(pnlR1.getHeight(), 400));
		pnlR1.setLayout(new BorderLayout());

		// panel 레이아웃
		pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.X_AXIS));
//		pnlLEFT.setLayout(new BoxLayout(pnlLEFT, BoxLayout.Y_AXIS));
		pnlRight.setLayout(new BoxLayout(pnlRight, BoxLayout.Y_AXIS));
		pnlR1.setLayout(new BoxLayout(pnlR1, BoxLayout.Y_AXIS));

		// 테두리
		pnlRight.setBorder(new TitledBorder(new LineBorder(Color.pink, 3), "관리자모드"));
		pnlL1.setBorder(new TitledBorder(new LineBorder(Color.green, 3), "문제"));
		pnlL2.setBorder(new TitledBorder(new LineBorder(Color.green, 3), "설명"));

		pnlR1.setBorder(new TitledBorder(new LineBorder(Color.CYAN, 3), "입력"));
		pnlR2.setBorder(new TitledBorder(new LineBorder(Color.yellow, 3), "기능"));
		pnlR3.setBorder(new TitledBorder(new LineBorder(Color.MAGENTA, 3), "번호"));

		// 메인
		setContentPane(pnlMain);
		pnlMain.add(pnlRight);

		// 왼쪽
		pnlRight.add(pnlL1);
		pnlRight.add(pnlL2);

		// --왼쪽[1]
		pnlL1.add(ta);

		pnlL1.setLayout(new GridBagLayout());
		JScrollPane scrollSingle = new JScrollPane(ta, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollSingle.setPreferredSize(new Dimension(1100, 230));
		pnlL1.add(scrollSingle);

//		pnlR3.setLayout(new GridBagLayout());
//		JScrollPane scrollSingle2 = new JScrollPane(pnlR3, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
//				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollSingle2.setPreferredSize(new Dimension(1000, 230));
//		pnlR3.add(scrollSingle2);

		// --왼쪽[2]
		pnlL2.add(ta2);

		// 오른쪽
		pnlRight.add(pnlR1);
		pnlRight.add(pnlR2);
		pnlRight.add(pnlR3);

		// --오른쪽[1]
		pnlR1.add(tf);
		pnlR1.add(pnlR0);

		// 버튼들 구현
		multipleChoice(pnlR3, ta, tf);
		bt.ListAdd(user.getId());
		bt.favListAdd(user.getId());
		bt.MMOk_button(bt1, ta2, tf, btn1, btn2, btn3, pnlR3, ta, "ASH", this);
		bt.MMDelete_button(bt2, tf);
		inputButton(pnlR0, bt1, bt2, 1);
		manager(pnlR2, btn0, btn1, btn2, btn3, 1);

		// 관리자 모드 기능 버튼
		bt.read_button(btn0, ta, ta2);
		setSize(1180, 820);
		setPreferredSize(new Dimension(1180, 820));
		pnlR1.setPreferredSize(new Dimension(100, 100));
		setLocationRelativeTo(null);
		setResizable(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inputButton(JPanel p, JButton a, JButton b, int user) {
		GridLayout grid = new GridLayout(1, 2);

		p.add(a);
		p.add(b);

		if (user == 1) {
			p.setVisible(true);
		}

		grid.setVgap(5); // 격자 사이 수직 간격 5 픽셀
		p.setLayout(grid);
	}

//		// 관리자 (user = 1 일경우 관리자 켜짐)
	public void manager(JPanel p, JRadioButton btn0, JRadioButton btn1, JRadioButton btn2, JRadioButton btn3,
			int user) {
		GridLayout grid = new GridLayout(1, 4);

		p.add(btn0);
		p.add(btn1);
		p.add(btn2);
		p.add(btn3);

		if (user == 1) {
			p.setVisible(true);
		}
		grid.setVgap(5); // 격자 사이 수직 간격 5 픽셀
		p.setLayout(grid);

	}

	// 객관식보기 버튼
	public void multipleChoice(JPanel p, JTextArea ta, JTextField tf) {
		FourlettersDaoImpl fld = new FourlettersDaoImpl();
		GridLayout grid = new GridLayout(5, 6);
		JButton[] bt = new JButton[fld.list.size()];

		for (int i = 0; i < fld.list.size(); i++) {
			String[] array = String.valueOf(fld.list.get(i)).split(",");
			bt[i] = new JButton(Integer.valueOf(array[0]) - 2000 + "번");
			p.add(bt[i]);

			bt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent a) {
					try {
//						ta.setText(dao.read(Integer.valueOf((array[0]))).toString());
						tf.setText(dao.read(Integer.valueOf((array[0]))).toString2());
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
//		ManagerMode m = new ManagerMode();
//		m.setVisible(true);
//	}
}
