package incomplete;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class Main2 extends JFrame implements ActionListener {
	private JCheckBox[] basicNumber;
	private JCheckBox[] clickNumber;
	private JCheckBox[] basicNumberCopy;
	private String[] setNum = { "1", "2", "3", "4", "5" };
	private JCheckBox[] ball;

	public Main2() {
		super("추첨프로그램");
		JPanel wrapPanel = new JPanel();

		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(222, 144, 242, 373);
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(505, 107, 467, 444);
		JLabel mainLabel = new JLabel();
		mainLabel.setBounds(0, 0, 995, 580);
		wrapPanel.setLayout(null);

		JButton firstButton = new JButton(); // 수동선택 버튼
		firstButton.setBounds(45, 107, 138, 136);
		firstButton.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\로또 번호\\버튼\\btn-06.png"));
		wrapPanel.add(firstButton);
		firstButton.setEnabled(false);

		JButton secondButton = new JButton(); // 혼합선택 버튼
		secondButton.setBounds(45, 245, 138, 136);
		secondButton.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\로또 번호\\버튼\\btn-01.png"));
		wrapPanel.add(secondButton);

		JButton thirdButton = new JButton(); // 자동선택 버튼
		thirdButton.setBounds(45, 383, 138, 136);
		thirdButton.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\로또 번호\\버튼\\btn-02.png"));
		wrapPanel.add(thirdButton);

		JComboBox comboBox = new JComboBox(setNum); // 수량 정하는 콤보박스
		comboBox.setBounds(45, 530, 40, 20);
		wrapPanel.add(comboBox);

		JButton checkInButton = new JButton(); // 확인버튼
		checkInButton.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\로또 번호\\버튼\\btn-04.png"));
		checkInButton.setBounds(90, 530, 93, 20);
		wrapPanel.add(checkInButton);

		JButton resetButton = new JButton(); // 초기화 버튼
		resetButton.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\로또 번호\\버튼\\btn-05.png"));
		resetButton.setBounds(280, 522, 125, 30);
		wrapPanel.add(resetButton);

//		ImageIcon icon = new ImageIcon("D:\\Wani\\Mogu\\lotto\\image\\back-01.png");  // 배경이미지
//		Image img = icon.getImage();
//		Image changeImg = img.getScaledInstance(995, 580, Image.SCALE_SMOOTH);
//		ImageIcon changeIcon = new ImageIcon(changeImg);

		mainLabel.setIcon(new ImageIcon("D:\\Wani\\Mogu\\lotto\\image\\back-01.png"));

		GridLayout grid = new GridLayout(9, 5);
		leftPanel.setLayout(grid); // 패널안에서 정렬

		basicNumber = new JCheckBox[45]; // 색깔없는 기본

		for (int i = 0; i < basicNumber.length; i++) {
			basicNumber[i] = new JCheckBox();
			leftPanel.add(basicNumber[i]);
			ImageIcon icon1 = new ImageIcon("D:\\Wani\\Mogu\\lotto\\image\\검-" + (i + 1) + ".png");
			Image img1 = icon1.getImage();
			Image changeImg1 = img1.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			ImageIcon changeIcon1 = new ImageIcon(changeImg1);
			basicNumber[i].setIcon(changeIcon1);
			basicNumber[i].addActionListener(this);
		}

		clickNumber = new JCheckBox[45]; // 색깔있는 그림

		for (int i = 0; i < clickNumber.length; i++) {
			clickNumber[i] = new JCheckBox();

			ImageIcon icon2 = new ImageIcon("D:\\Wani\\Mogu\\lotto\\image\\번호작은거-" + (i + 1) + ".png");
			Image img2 = icon2.getImage();
			Image changeImg2 = img2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			ImageIcon changeIcon2 = new ImageIcon(changeImg2);
			clickNumber[i].setIcon(changeIcon2);
		}

		basicNumberCopy = new JCheckBox[45]; // 원래 색으로 돌아오기 위한 그림

		for (int i = 0; i < clickNumber.length; i++) {
			basicNumberCopy[i] = new JCheckBox();

			ImageIcon icon2 = new ImageIcon("D:\\Wani\\Mogu\\lotto\\image\\검-" + (i + 1) + ".png");
			Image img2 = icon2.getImage();
			Image changeImg2 = img2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			ImageIcon changeIcon2 = new ImageIcon(changeImg2);
			basicNumberCopy[i].setIcon(changeIcon2);
		}

//		cb[0].addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println(cb[0].isSelected());
//				if (cb[0].isSelected()) {
//					cb[0].setIcon(cbnew[0].getIcon());
//				} else {
//					cb[0].setIcon(cb[0].getIcon());
//				}
//			}
//		});

		basicNumber[0].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (basicNumber[0].isSelected()) {
					basicNumber[0].setIcon(clickNumber[0].getIcon());
				} else {
					basicNumber[0].setIcon(basicNumberCopy[0].getIcon());
				}
			}
		});

		JLabel lblinput = new JLabel("선택금액");
		lblinput.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		lblinput.setBounds(222, 111, 242, 23);
		lblinput.setBackground(Color.darkGray);
		wrapPanel.add(lblinput);
		lblinput.setHorizontalAlignment(JLabel.CENTER);

		getContentPane().add(wrapPanel);
		wrapPanel.add(leftPanel);
		wrapPanel.add(rightPanel);
		rightPanel.setLayout(null);

		JLabel lblCheck = new JLabel("선택번호 확인");
		lblCheck.setBounds(25, 15, 120, 30);
		lblCheck.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 14));
		rightPanel.add(lblCheck);

		JButton btnRestet2 = new JButton();
		btnRestet2.setBounds(390, 15, 60, 30);
		btnRestet2.setIcon(new ImageIcon("D:\\Wani\\Mogu\\lotto\\image\\btn-07.png"));
		rightPanel.add(btnRestet2);

		JPanel pnl1 = new JPanel();
		pnl1.setBounds(0, 67, 467, 64);
		rightPanel.add(pnl1);
		pnl1.setLayout(null);

		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 14));
		lblA.setBounds(25, 26, 19, 15);
		pnl1.add(lblA);

		ball = new JCheckBox[30];
		for (int i = 0; i < ball.length; i++) {
			ball[i] = new JCheckBox();
			pnl1.add(ball[i]);
		}

		JButton btnA = new JButton("번호복사");
		btnA.setBounds(375, 22, 75, 23);
		btnA.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnA.setBackground(Color.white);
		pnl1.add(btnA);

		JButton btnAdelet = new JButton("삭제");
		btnAdelet.setBounds(310, 22, 60, 23);
		btnAdelet.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnAdelet.setBackground(Color.white);
		pnl1.add(btnAdelet);

		JButton btnAchange = new JButton("수정");
		btnAchange.setBounds(245, 22, 60, 23);
		btnAchange.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnAchange.setBackground(Color.white);
		pnl1.add(btnAchange);

		JPanel pnl2 = new JPanel();
		pnl2.setBounds(0, 130, 467, 64);
		rightPanel.add(pnl2);
		pnl2.setLayout(null);

		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 14));
		lblB.setBounds(25, 27, 18, 15);
		pnl2.add(lblB);

		JButton btnB = new JButton("번호복사");
		btnB.setBounds(375, 19, 75, 23);
		btnB.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnB.setBackground(Color.white);
		pnl2.add(btnB);

		JButton btnBdelet = new JButton("삭제");
		btnBdelet.setBounds(310, 19, 60, 23);
		btnBdelet.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnBdelet.setBackground(Color.white);
		pnl2.add(btnBdelet);

		JButton btnBchange = new JButton("수정");
		btnBchange.setBounds(245, 18, 60, 23);
		btnBchange.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnBchange.setBackground(Color.white);
		pnl2.add(btnBchange);

		JPanel pnlball = new JPanel();
		pnlball.setBounds(55, -63, 178, 317);
		pnl2.add(pnlball);

		JPanel pnl3 = new JPanel();
		pnl3.setBounds(0, 193, 467, 64);
		rightPanel.add(pnl3);
		pnl3.setLayout(null);

		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 14));
		lblC.setBounds(25, 27, 19, 15);
		pnl3.add(lblC);

		JButton btnC = new JButton("번호복사");
		btnC.setBounds(375, 23, 75, 23);
		btnC.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnC.setBackground(Color.white);
		pnl3.add(btnC);

		JButton btnCdelet = new JButton("삭제");
		btnCdelet.setBounds(310, 23, 60, 23);
		btnCdelet.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnCdelet.setBackground(Color.white);
		pnl3.add(btnCdelet);

		JButton btnCchange = new JButton("수정");
		btnCchange.setBounds(245, 23, 60, 23);
		btnCchange.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnCchange.setBackground(Color.white);
		pnl3.add(btnCchange);

		JPanel pnl4 = new JPanel();
		pnl4.setBounds(0, 257, 467, 64);
		rightPanel.add(pnl4);
		pnl4.setLayout(null);

		JLabel lblD = new JLabel("D");
		lblD.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 14));
		lblD.setBounds(25, 23, 18, 15);
		pnl4.add(lblD);

		JButton btnD = new JButton("번호복사");
		btnD.setBounds(375, 19, 75, 23);
		btnD.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnD.setBackground(Color.white);
		pnl4.add(btnD);

		JButton btnDdelet = new JButton("삭제");
		btnDdelet.setBounds(310, 19, 60, 23);
		btnDdelet.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnDdelet.setBackground(Color.white);
		pnl4.add(btnDdelet);

		JButton btnDchange = new JButton("수정");
		btnDchange.setBounds(245, 19, 60, 23);
		btnDchange.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnDchange.setBackground(Color.white);
		pnl4.add(btnDchange);

		JPanel pnl5 = new JPanel();
		pnl5.setBounds(0, 320, 467, 64);
		rightPanel.add(pnl5);
		pnl5.setLayout(null);

		JLabel lblE = new JLabel("E");
		lblE.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 14));
		lblE.setBounds(25, 25, 17, 15);
		pnl5.add(lblE);

		JButton btnE = new JButton("번호복사");
		btnE.setBounds(375, 21, 75, 23);
		btnE.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnE.setBackground(Color.white);
		pnl5.add(btnE);

		JButton btnEdelet = new JButton("삭제");
		btnEdelet.setBounds(310, 21, 60, 23);
		btnEdelet.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnEdelet.setBackground(Color.white);
		pnl5.add(btnEdelet);

		JButton btnEchange = new JButton("수정");
		btnEchange.setBounds(245, 21, 60, 23);
		btnEchange.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 10));
		btnEchange.setBackground(Color.white);
		pnl5.add(btnEchange);

		JLabel lbltotal = new JLabel("결제금액 : ");
		lbltotal.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lbltotal.setBounds(158, 388, 120, 50);
		rightPanel.add(lbltotal);
		wrapPanel.add(mainLabel);

		JLabel lbltotal2 = new JLabel("2000원");
		lbltotal2.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lbltotal2.setBounds(260, 388, 120, 50);
		rightPanel.add(lbltotal2);

		JButton btnBuy = new JButton();
		btnBuy.setBounds(340, 390, 120, 50);
		btnBuy.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\로또 번호\\버튼\\buy-07.png"));
		rightPanel.add(btnBuy);
		wrapPanel.add(mainLabel);

		// 수정중
		setResizable(false);
		setSize(1000, 600);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < basicNumber.length; i++) {
			if (e.getSource() == basicNumber[i]) {
//				System.out.println(cbs[i]); //확인용
				if (basicNumber[i].isSelected()) {
					basicNumber[i].setIcon(clickNumber[i].getIcon());
				} else {
					basicNumber[i].setIcon(basicNumberCopy[i].getIcon());
				}
			}
		}
	}

	public static void main(String[] args) {
		new Main2().setVisible(true);
	}
}
