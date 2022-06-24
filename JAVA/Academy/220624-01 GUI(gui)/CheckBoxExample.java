import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxExample extends JFrame implements ActionListener {

	private List<JCheckBox> boxList;
	private JLabel lblPrice;
	private JButton btnAll;
	private JButton btnCancel;

	public CheckBoxExample(String title) {
		super(title);
		setSize(400, 700);
		setLocation(700, 200);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnlLeft = new JPanel();
		JPanel pnlRight = new JPanel();
		JPanel pnlBox = new JPanel();

		boxList = new ArrayList<>(Arrays.asList(new JCheckBox("짜장면 : 5000원"), new JCheckBox("짬뽕 : 6000원"),
				new JCheckBox("탕수육 : 12000원")));
		lblPrice = new JLabel("가격 표시");
		btnAll = new JButton("전체 선택");
		btnCancel = new JButton("선택 취소");

		ItemListener itemListener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				int sum = sum();
				lblPrice.setText(String.valueOf(sum));
			}
		};

		for (int i = 0; i < 3; i++) {
			pnlLeft.add(boxList.get(i));
			boxList.get(i).addItemListener(itemListener);
		}

		pnlLeft.add(btnAll);
		pnlLeft.add(btnCancel);
		pnlRight.add(lblPrice);
		pnlBox.add(pnlLeft);
		pnlBox.add(pnlRight);
		BoxLayout box = new BoxLayout(pnlBox, BoxLayout.Y_AXIS);
		pnlBox.setLayout(box);
		add(pnlBox);

		btnAll.addActionListener(this);
		btnCancel.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean all = e.getSource() == btnAll;
		for (JCheckBox check : boxList) {
			check.setSelected(all);
		}
	}

	private int sum() {
		int sum = 0;
		sum += boxList.get(0).isSelected() ? 5000 : 0;
		sum += boxList.get(1).isSelected() ? 6000 : 0;
		sum += boxList.get(2).isSelected() ? 12000 : 0;
		return sum;
	}

	public static void main(String[] args) {
		new CheckBoxExample("중국집").setVisible(true);
	}
}
