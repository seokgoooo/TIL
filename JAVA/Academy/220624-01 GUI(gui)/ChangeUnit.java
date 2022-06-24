// 항상 명심할 것 처음부터 코드로 짜려고할때 계속 오래 걸리고 어려웠다
// 시작할 때 밑그림부터 그리고 시작하자!!! 100000000만배 쉽다
//radio cm -> inch	selected 	0.393701
//radio inch -> cm	selected	2.54
//radio cm -> ft	selected	0.032808
//radio ft -> cm	selected	30.48
//button 변환 		action 환산됨
//textField	숫자 입력
//textField	결과 출력

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ChangeUnit extends JFrame {
	private JRadioButton rdbCmFirst;
	private JRadioButton rdbInchFirst;
	private JRadioButton rdbFtFirst;
	private JRadioButton rdbCmSecond;
	private JRadioButton rdbInchSecond;
	private JRadioButton rdbFtSecond;
	private JTextField inputNumber;
	private JTextField resultNumber;

	public ChangeUnit(String title) {
		super(title);
		// 전체 감싸는 패널
		JPanel box = new JPanel();

		// 단위 라디오 박스 패널1
		JPanel pnlTop = new JPanel();
		rdbCmFirst = new JRadioButton("cm ->");
		rdbInchFirst = new JRadioButton("inch ->");
		rdbFtFirst = new JRadioButton("ft ->");
		JLabel first = new JLabel("현재 단위");
		pnlTop.add(first);
		pnlTop.add(rdbCmFirst);
		pnlTop.add(rdbInchFirst);
		pnlTop.add(rdbFtFirst);

		ButtonGroup groupFirst = new ButtonGroup();
		groupFirst.add(rdbCmFirst);
		groupFirst.add(rdbInchFirst);
		groupFirst.add(rdbFtFirst);

		// 단위 라디오 박스 패널2
		JPanel pnlBottom = new JPanel();
		rdbCmSecond = new JRadioButton("cm");
		rdbInchSecond = new JRadioButton("inch");
		rdbFtSecond = new JRadioButton("ft");
		JLabel second = new JLabel("바꿀 단위");
		pnlBottom.add(second);
		pnlBottom.add(rdbCmSecond);
		pnlBottom.add(rdbInchSecond);
		pnlBottom.add(rdbFtSecond);

		ButtonGroup groupSecond = new ButtonGroup();
		groupSecond.add(rdbCmSecond);
		groupSecond.add(rdbInchSecond);
		groupSecond.add(rdbFtSecond);

		// 환산 버튼 패널
		JPanel pnlBtn = new JPanel();
		JButton change = new JButton("환산");
		pnlBtn.add(change);

		// textField 패널
		JPanel pnlPrint = new JPanel();
		inputNumber = new JTextField(15);
		resultNumber = new JTextField(15);
		inputNumber.setText("환산할 값 입력");
		resultNumber.setText("결과값 출력");
		pnlPrint.add(inputNumber);
		pnlPrint.add(resultNumber);

		// 원하는 순서대로 전체 패널에 담아준다
		box.add(pnlTop);
		box.add(pnlBottom);
		box.add(pnlBtn);
		box.add(pnlPrint);

		// 전체 정렬을 위해 BoxLayout에 담아준다
		BoxLayout boxOut = new BoxLayout(box, BoxLayout.Y_AXIS);
		box.setLayout(boxOut);
		add(box);

		// 환산 버튼이 눌러졌을 때 발생하는 이벤트를 정의
		change.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resultNumber.setText(String.valueOf(changeNum()));
			}
		});

		setSize(412, 350);
		setLocation(700, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
	}

	private String changeNum() {
		double result = Double.parseDouble(inputNumber.getText());
		if (rdbCmFirst.isSelected()) {
			if (rdbInchSecond.isSelected()) {
				result *= 0.393701;
				return result + " in";
			} else if (rdbFtSecond.isSelected()) {
				result *= 0.032808;
				return result + " ft";
			} else {
				return result + " cm";
			}
		} else if (rdbInchFirst.isSelected()) {
			if (rdbCmSecond.isSelected()) {
				result *= 2.54;
				return result + " cm";
			} else if (rdbFtSecond.isSelected()) {
				result *= 0.083333;
				return result + " ft";
			} else {
				return result + " in";
			}
		} else if (rdbFtFirst.isSelected()) {
			if (rdbCmSecond.isSelected()) {
				result *= 30.48;
				return result + " cm";
			} else if (rdbInchSecond.isSelected()) {
				result *= 12;
				return result + " in";
			} else {
				return result + " ft";
			}
		} else {
			return "선택 해주세요";
		}

	}

	public static void main(String[] args) {
		new ChangeUnit("단위 변환을 해보자").setVisible(true);
	}
}
