import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;

class QuestionFrame extends JFrame {
	private JButton inputBtn;
	private JButton checkBtn;
	private JButton resultBtn;
	private JButton resetBtn;
	private int x, y;

	public QuestionFrame(String title) {
		super(title);
		setSize(412, 915);
		setLocation(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);

		JPanel pnlTop = new JPanel();
		JPanel pnlBottom = new JPanel();
		JPanel pnlBox = new JPanel();

		BoxLayout box = new BoxLayout(pnlBox, BoxLayout.Y_AXIS);
		pnlBox.setLayout(box);

		x = (int) (Math.random() * 10);
		y = (int) (Math.random() * 10);
		JLabel questionText = new JLabel("Quiz : " + x + " + " + y + "?");
		JTextField inputTextField = new JTextField(25);
		JTextField resultTextField = new JTextField(25);
		inputBtn = new JButton("정답 입력");
		checkBtn = new JButton("정답 확인");
		resultBtn = new JButton("계산 결과");
		resetBtn = new JButton("리셋");

		checkBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int sum = x + y;
				String text = inputTextField.getText();
				resultTextField.setText(text);
				if (text.equals(String.valueOf(sum))) {
					JOptionPane.showMessageDialog(QuestionFrame.this, "정답!!!");
				} else {
					JOptionPane.showMessageDialog(QuestionFrame.this, "땡!!! 정답은 : " + sum);
				}
			}
		});

		questionText.setFont(new Font("Consolas", 3, 100));
		pnlTop.add(questionText);
		pnlTop.setBackground(Color.LIGHT_GRAY);

		pnlBottom.setBackground(Color.DARK_GRAY);

		pnlBottom.add(inputBtn);
		pnlBottom.add(inputTextField);
		pnlBottom.add(checkBtn);
		pnlBottom.add(resultBtn);
		pnlBottom.add(resultTextField);
		pnlBottom.add(resetBtn);

		pnlBox.add(pnlTop);
		pnlBox.add(pnlBottom);

		inputBtn.setBackground(Color.WHITE);
		checkBtn.setBackground(Color.WHITE);
		resultBtn.setBackground(Color.WHITE);
		resetBtn.setBackground(Color.WHITE);

		add(pnlBox);
		pack();
	}
}

public class GuiExample {
	public static void main(String[] args) {
		JFrame questionFrame = new QuestionFrame("퀴즈");
		questionFrame.setVisible(true);
	}
}
