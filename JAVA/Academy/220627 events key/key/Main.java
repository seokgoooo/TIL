package key;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main extends JFrame {
	public static void main(String[] args) {
		new Main().setVisible(true);
		new Main2().setVisible(true);
		new Main3().setVisible(true);
		new Main4().setVisible(true);
	}

	int x;
	int y;

	public Main() {
		JPanel pnl = new JPanel();
		JLabel lbl = new JLabel("입력");
		x = 200;
		y = 200;
		lbl.setBounds(x, y, 100, 100);
		pnl.add(lbl);
		add(pnl);

		pnl.setFocusable(true);
		pnl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_LEFT) {
					System.out.println("왼쪽 화살표 누름");
					x -= 5;
				} else if (code == KeyEvent.VK_RIGHT) {
					System.out.println("오른쪽 화살표 누름");
					x += 5;
				} else if (code == KeyEvent.VK_UP) {
					System.out.println("위쪽 화살표 누름");
					y -= 5;
				} else if (code == KeyEvent.VK_DOWN) {
					System.out.println("아래쪽 화살표 누름");
					y += 5;
				}
				lbl.setLocation(x, y);
				// char type
//				char c = e.getKeyChar();
//				lbl.setText(String.valueOf(c));
			};
		});
		setSize(500, 500);
		setLocation(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class Main2 extends JFrame {
	public Main2() {
		JPanel pnl = new JPanel();
		JTextField tf = new JTextField(10);
		JPasswordField pf = new JPasswordField(10);
		JTextArea ta = new JTextArea(20, 20);
		JScrollPane scrl = new JScrollPane(ta);

		pnl.add(tf);
		pnl.add(pf);
		add(pnl);
		add(scrl, "South");

		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("엔터 누름");
			}
		});

		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int id = e.getID();
				if (id == KeyEvent.KEY_TYPED) {
					char ch = e.getKeyChar();
					// setText 는 바꾸고 append 는 추가시킨다
					ta.append(String.valueOf(ch) + "\n");
				}
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocation(700, 200);
	}
}

class Main3 extends JFrame {
	public Main3() {
		JPanel red = new JPanel();
		red.setBackground(Color.red);
		JPanel blue = new JPanel();
		blue.setBackground(Color.blue);

		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, red, blue);
		split.setDividerLocation(150);
		add(split);

		JTabbedPane tab = new JTabbedPane();
		tab.add("빨강", red);
		tab.add("파랑", blue);
		add(tab);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocation(700, 300);
	}
}

class Main4 extends JFrame {
	public Main4() {
		CardLayout layout = new CardLayout();
		JPanel center = new JPanel(layout);

		JPanel pnl1 = makeJPanel("첫번째");
		JPanel pnl2 = makeJPanel("두번째");
		JPanel pnl3 = makeJPanel("세번째");
		center.add(pnl1, "A");
		center.add(pnl2, "B");
		center.add(pnl3, "C");
		add(center);

		JButton btnNext = new JButton("다음");
		JButton btnPrev = new JButton("이전");
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnPrev);
		pnlSouth.add(btnNext);

		add(pnlSouth, "South");

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("다음")) {
					layout.next(center);
				} else {
					layout.previous(center);
				}
			}
		};

		btnNext.addActionListener(listener);
		btnPrev.addActionListener(listener);

//		// 화면 전환 (해당 문자열로 패널을 연결해줌)
//		layout.show(center, "C");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocation(300, 300);
	}

	private JPanel makeJPanel(String text) {
		JPanel pnl = new JPanel();
		pnl.add(new JLabel(text));
		return pnl;
	}
}