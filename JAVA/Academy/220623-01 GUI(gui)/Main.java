import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame {
	// 보통 JFrame을 쓸때 나만의 창을 만들고 싶을 때 JFrame을 상속받아서 사용한다
	public MyFrame(String title) {
		super(title);
		// super로 부모 클래스 상속받아서 뒤로는 this 생략 가능하다
		setSize(375, 667);
		setLocation(700, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		getContentPane().setBackground(Color.BLUE);
		getContentPane().setCursor(new Cursor(13));

		// 패널
		JPanel pnl = new JPanel();
		add(pnl);

		// layout & 버튼
		setLayout(new FlowLayout());
		JButton button = new JButton("버튼1");
		JButton button2 = new JButton("버튼2");
		this.add(button);
		this.add(button2);
		button.setBackground(Color.RED);

		// 액션이벤트 (동작시 이벤트 정의)
		MyActionListener listener = new MyActionListener();
		button.addActionListener(listener);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("익명 클래스 구현");
				pnl.setBackground(Color.GREEN);
			}
		});
	}
}

class MyActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 클릭");
		System.out.println("클래스 생성 방법 구현");
	}
}

class MyCounter extends JFrame {
	private int number = 0;

	public MyCounter() {
		super("이벤트 2개 카운터");
		setSize(375, 667);
		setLocation(300, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		getContentPane().setCursor(new Cursor(3));

		JPanel pnl = new JPanel();
		JLabel lbl = new JLabel("0");
		JButton btn = new JButton("증가");
		JButton btn2 = new JButton("감소");

		pnl.add(lbl);
		pnl.add(btn);
		pnl.add(btn2);
		add(pnl);
		pnl.setBackground(Color.RED);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("왼쪽 레이블 숫자 변경 예정");
				number++;
				lbl.setText(String.valueOf(number));
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				number--;
				lbl.setText(String.valueOf(number));
			}
		});
	}
}

class MyCounter2 extends JFrame implements ActionListener {
	private int number = 0;
	private JLabel lbl;
	private JButton btn;
	private JButton btn2;

	public MyCounter2() {
		super("이벤트 1개 카운터");
		setSize(375, 667);
		setLocation(1100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		getContentPane().setCursor(new Cursor(12));

		JPanel pnl = new JPanel();
		lbl = new JLabel("0");
		btn = new JButton("증가");
		btn2 = new JButton("감소");

		pnl.add(lbl);
		pnl.add(btn);
		pnl.add(btn2);
		add(pnl);
		pnl.setBackground(Color.GREEN);

//		익명 클래스 구현 방법
//		ActionListener aListener = new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// getSource 로 참조를 비교해서 판단
//				if (e.getSource() == btn) {
//					number++;
//				} else {
//					number--;
//				}
//				lbl.setText(String.valueOf(number));
//			}
//		};

		btn.addActionListener(this);
		btn2.addActionListener(this);
	}

//	interface 구현해서 메소드 Override 사용 방법
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btn) {
			number++;
		} else {
			number--;
		}
		this.lbl.setText(String.valueOf(number));
	}
}

class ButtonTest extends JFrame implements ActionListener {
	private JButton btnEnable;
	private JButton btnDisable;
	private List<JButton> list;

	public ButtonTest() {
		super("버튼 여러개 활성화 테스트");
		setSize(375, 667);
		setLocation(700, 200);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		list = new ArrayList<JButton>();
		JPanel pnl = new JPanel();
		btnEnable = new JButton("활성화");
		btnDisable = new JButton("비활성화");
		JButton btnNotShown = new JButton("보이나?");

		for (int i = 1; i <= 5; i++) {
			JButton btn = new JButton(String.valueOf(i));
			pnl.add(btn);
			list.add(btn);
		}
		add(pnl);

		btnDisable.addActionListener(this);
		btnNotShown.addActionListener(this);

		btnDisable.setEnabled(false);
		btnNotShown.setVisible(false);

		pnl.add(btnEnable);
		pnl.add(btnDisable);
		pnl.add(btnNotShown);
		pnl.setBackground(Color.CYAN);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnable) {
			for (JButton btn : list) {
				btn.setEnabled(true);
			}
		} else {
			for (JButton btn : list) {
				btn.setEnabled(false);
			}
		}
	}
}

class ActionCommandTest extends JFrame {
	private JButton btn1;
	private JButton btn2;

	public ActionCommandTest() {
		super("버튼 활성화 테스트");
		setSize(375, 667);
		setLocation(300, 200);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnl = new JPanel();
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		btn1.setActionCommand("임의의 커맨드");

		pnl.add(btn1);
		pnl.add(btn2);
		add(pnl);
		pnl.setBackground(Color.BLACK);

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());

			}
		};
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
	}
}

class LayoutManagerTest extends JFrame {
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;

	public LayoutManagerTest() {
		super("레이아웃 매니저 테스트");
		setSize(375, 667);
		setLocation(1100, 200);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 배치용 클래스들 마치 CSS의 flex 느낌
		JPanel pnl = new JPanel();
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
		pnl.setLayout(flow);

//		BorderLayout border = new BorderLayout();
//		pnl.setLayout(border);

		BoxLayout box = new BoxLayout(pnl, BoxLayout.Y_AXIS);
		pnl.setLayout(box);

		GridLayout grid = new GridLayout(2, 2);
		pnl.setLayout(grid);

		pnl.setLayout(null);

		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		btn3 = new JButton("버튼3");
		btn1.setPreferredSize(new Dimension(100, 100));
		btn1.setMinimumSize(new Dimension(100, 100));
		btn1.setMaximumSize(new Dimension(100, 100));

		btn1.setLocation(10, 30);
		btn1.setSize(100, 200);

		btn2.setBounds(220, 50, 100, 100);

		pnl.add(btn1, BorderLayout.NORTH);
		pnl.add(btn2);
		pnl.add(btn3, BorderLayout.SOUTH);
//		pnl.add(btn3, BorderLayout.EAST);	똑같은 component를 다른 위치에 적용하고 싶으면 새롭게 더 만들어서 위치시켜야 한다. 아니면 기존에 있는 위치가 수정된다.
		add(pnl);
		pnl.setBackground(Color.MAGENTA);
	}
}

class PanelTest extends JFrame {
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;

	public PanelTest() {
		super("패널 테스트");
		setSize(375, 667);
		setLocation(700, 400);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnlTop = new JPanel();
		JPanel pnlBottom = new JPanel();
		JPanel pnlBox = new JPanel();

		BoxLayout box = new BoxLayout(pnlBox, BoxLayout.Y_AXIS);
		pnlBox.setLayout(box);

		JTextField tf1 = new JTextField(25);
		JTextField tf2 = new JTextField(25);
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = tf1.getText();
				tf2.setText(text);
//				자기 자신이 아니고 바깥에 있는 참조를 말하고 싶을 때 this를 사용하려면 'class.this' 이런식으로 사용하자~
				JOptionPane.showMessageDialog(PanelTest.this, text);
				JOptionPane.showInputDialog(PanelTest.this, text);
			}
		});

		pnlTop.add(tf1);
		pnlTop.add(btn1);
		pnlBottom.add(tf2);
		pnlBottom.add(btn2);

		pnlBox.add(pnlTop);
		pnlBox.add(pnlBottom);

		pnlTop.setBackground(Color.ORANGE);
		pnlBottom.setBackground(Color.PINK);
		add(pnlBox);
		// 내부의 component 크기에 맞춰서 window 창 크기를 조절해줌
		pack();
	}
}

public class Main {
	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setTitle("제목");
//		frame.setSize(1000, 1000);
//		frame.setVisible(true);
//		Component label = new JLabel("Hello World!");
//		frame.getContentPane().add(label);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JFrame myFrame = new MyFrame("나의 프레임");
		myFrame.setVisible(true);

		new MyCounter().setVisible(true);
		new MyCounter2().setVisible(true);
		new ButtonTest().setVisible(true);
		new ActionCommandTest().setVisible(true);
		new LayoutManagerTest().setVisible(true);
		new PanelTest().setVisible(true);
	}
}