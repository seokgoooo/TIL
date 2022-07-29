package capitals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

public class CrudFrame extends JFrame {
	private JTable table;
	private JScrollPane sp;
	private List<Capitals> list;
	private CapitalsDao dao;
	private JPanel panel;
	private JTextField jf;
	private JTextField jt1;
	private JTextField jt2;
	private JTextField jt3;

	public void setTable() {

	}

	public CrudFrame() {
		dao = new Manager();

		Dimension dim = new Dimension(600, 520); // 단순 2차원값 입력을 위한 클래스

		setTitle("수도 관리자 창");
		setLocation(0, 0);
		setPreferredSize(dim);

		list = new ArrayList<>();

		Manager mg = (Manager) dao;
		panel = new JPanel();
		repaint();

		String header[] = { "number", "힌트(나라)", "정답", "대륙" };

		String body[][] = new String[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
//			bodyS = list.get(i);
//			body[i] = bodyS;
			String[] bodyS = new String[header.length];
			bodyS[0] = "" + list.get(i).getNumber();
			bodyS[1] = list.get(i).getQuestion();
			bodyS[2] = list.get(i).getAnswer();
			bodyS[3] = list.get(i).getContinent();

			body[i] = bodyS;
		}

		jf = new JTextField(20);
		jf.setBounds(176, 329, 226, 23);
		getContentPane().add(jf);

		JButton btn1 = new JButton("문제 추가");
		btn1.setBounds(10, 282, 111, 23);
		getContentPane().add(btn1);

		JButton btn2 = new JButton("문제 수정");
		btn2.setBounds(156, 282, 111, 23);
		getContentPane().add(btn2);

		JButton btn3 = new JButton("문제 삭제");
		btn3.setBounds(291, 282, 111, 23);
		getContentPane().add(btn3);

		jt1 = new JTextField();
		jt1.setBounds(176, 372, 226, 21);
		getContentPane().add(jt1);
		jt1.setColumns(10);

		jt2 = new JTextField();
		jt2.setBounds(176, 414, 226, 21);
		getContentPane().add(jt2);
		jt2.setColumns(10);

		jt3 = new JTextField();
		jt3.setBounds(176, 450, 226, 21);
		getContentPane().add(jt3);
		jt3.setColumns(10);

		JLabel lbl1 = new JLabel("number");
		lbl1.setBounds(75, 333, 85, 15);
		getContentPane().add(lbl1);

		JLabel lbl2 = new JLabel("힌트(나라)");
		lbl2.setBounds(75, 375, 85, 15);
		getContentPane().add(lbl2);

		JLabel lbl3 = new JLabel("정답");
		lbl3.setBounds(75, 417, 85, 15);
		getContentPane().add(lbl3);

		JLabel lbl4 = new JLabel("대륙");
		lbl4.setBounds(75, 453, 85, 15);
		getContentPane().add(lbl4);

		// 버튼 구현
		// 문제 추가 버튼

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn1) {

					try {
						mg.create(Integer.valueOf(jf.getText()), jt1.getText(), jt2.getText(), jt3.getText());
						JOptionPane.showMessageDialog(CrudFrame.this, "추가 되었습니다.");
						repaint();

					} catch (NumberFormatException e1) {
						System.out.println(e.getSource());
					} catch (SQLException e1) {
						System.out.println(e1.getErrorCode());
						e1.printStackTrace();
					}

				}
				textReset();

			}

		});
		// 수정 버튼
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn2) {
					try {
						mg.update(Integer.valueOf(jf.getText()), jt1.getText(), jt2.getText(), jt3.getText());
						JOptionPane.showMessageDialog(CrudFrame.this, "수정완료");
						repaint();
					} catch (NumberFormatException e1) {

					} catch (SQLException e1) {

					}
				}
				textReset();

			}
		});

		// 삭제 버튼
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn3) {
					try {
						mg.delete(Integer.valueOf(jf.getText()));
						JOptionPane.showMessageDialog(CrudFrame.this, "삭제완료");
						repaint();

					} catch (NumberFormatException e1) {

						e1.printStackTrace();
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
				textReset();

			}
		});

		// 마우스 리스너
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("클릭");
				int number = table.getSelectedRow();
				jf.setText(String.valueOf(list.get(number).getNumber()));
				jt1.setText(list.get(number).getQuestion());
				jt2.setText(list.get(number).getAnswer());
				jt3.setText(list.get(number).getContinent());

			}
		});

		setSize(1180, 820);
	}

//갱신 메소드
	@Override
	public void repaint() {
		panel.removeAll();
		try {
			list = dao.read();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String header[] = { "number", "힌트(나라)", "정답", "대륙" };

		String body[][] = new String[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
//			bodyS = list.get(i);
//			body[i] = bodyS;
			String[] bodyS = new String[header.length];
			bodyS[0] = "" + list.get(i).getNumber();
			bodyS[1] = list.get(i).getQuestion();
			bodyS[2] = list.get(i).getAnswer();
			bodyS[3] = list.get(i).getContinent();

			body[i] = bodyS;
		}

		getContentPane().setLayout(null);

		panel.setBounds(0, 22, 402, 250);
		getContentPane().add(panel);
		panel.setLayout(null);

		table = new JTable(body, header);
		table.setBackground(new Color(255, 222, 173));

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("클릭");
				int number = table.getSelectedRow();
				jf.setText(String.valueOf(list.get(number).getNumber()));
				jt1.setText(list.get(number).getQuestion());
				jt2.setText(list.get(number).getAnswer());
				jt3.setText(list.get(number).getContinent());

			}
		});

		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 402, 250);
		panel.add(sp);
		sp.setBorder(new TitledBorder(new LineBorder(new Color(255, 215, 0), 4), "\uBB38\uC81C \uBAA9\uB85D",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		panel.revalidate();
		panel.repaint();
	}

	// 텍스트 초기화 메소드
	public void textReset() {
		jf.setText("");
		jt1.setText("");
		jt2.setText("");
		jt3.setText("");
	}
}