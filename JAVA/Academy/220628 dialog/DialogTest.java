import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class SubWindow extends JDialog {
	private JTextField tf;

	public SubWindow(JFrame owner) {
		// 이런 창을 Dialog라고 부른다. 구체적으로는 JDialog를 상속받는게 맞음
		super(owner, true);
		// 부가 창에서만 작업을 해야할 때. 생성자에 써줄 수도 있다.
//		setModal(true);

		setTitle("부가 창");

		tf = new JTextField(10);
		add(tf, "North");

		JButton btn = new JButton("다른 버튼");
		add(btn);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		setSize(500, 500);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// Main 창이 아니라서 프로그램 종료를 하면 안되기 때문에 EXIT을 주면 에러 난다.
//		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public String showDialog() {
		setVisible(true);
		return tf.getText();
	}
}

public class DialogTest extends JFrame {
	public DialogTest() {
		super("주요 창");
		JButton btn = new JButton("버튼");
		add(btn);

		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SubWindow dialog = new SubWindow(DialogTest.this);
				String result = dialog.showDialog();
				System.out.println("setModal이 true일 때 프로그램이 흐름이 멈춘 것처럼 보이지만 멈춘게 아니다.");
				btn.setText(result);
			}
		});
	}

	public static void main(String[] args) {
		new DialogTest().setVisible(true);
	}
}