import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class ExitDialog extends JDialog {
	private boolean exit;

	public ExitDialog(JFrame owner) {
		super(owner, "종료하시겠습니까?", true);

		JPanel pnl = new JPanel();
		JButton btnYes = new JButton("종료");
		JButton btnNo = new JButton("취소");

		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit = (e.getSource() == btnYes);
				dispose();
			}
		};

		pnl.add(btnYes);
		pnl.add(btnNo);

		btnYes.addActionListener(actionListener);
		btnNo.addActionListener(actionListener);

		add(pnl);
		setSize(250, 250);

	}

	public boolean showDialog() {
		setVisible(true);
		return exit;
	}
}

public class DialogYesOrNo extends JFrame {
	public DialogYesOrNo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// method 만들어서 종료 취소 확인창을 만들어도 되지만 이런 기능은 자주 쓰기 때문에 미리 자바가 다 만들어놨다
//				ExitDialog dialog = new ExitDialog(DialogYesOrNo.this);
//				boolean result = dialog.showDialog();
//
//				if (result) {
//					setDefaultCloseOperation(EXIT_ON_CLOSE);
//				}

				// 간단한 확인은 JOptionPane 에 있는 메소드 활용하면 된다.
//				JOptionPane.showConfirmDialog(DialogYesOrNo.this, "확인창");
//				JOptionPane.showInputDialog(DialogYesOrNo.this, "입력창");

				int result = JOptionPane.showConfirmDialog(DialogYesOrNo.this, "종료하시겠습니까?", "종료 확인",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					setDefaultCloseOperation(EXIT_ON_CLOSE);
				}

			}
		});

		setSize(500, 500);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	public static void main(String[] args) {
		new DialogYesOrNo().setVisible(true);
	}
}