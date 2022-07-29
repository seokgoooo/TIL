package ranking;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import user.User;

public class MyRankPanel implements ActionListener {
	private Panel pnl = new Panel();

	private JLabel titleLbl = new JLabel();
	private JLabel[] questionLbl = new JLabel[5];
	private JProgressBar[] progressBar = new JProgressBar[5];
	private JLabel[] percentLbl = new JLabel[5];

	private JPanel bottomPnl = new JPanel();
	private JComboBox<String> comboBox = new JComboBox<String>();
	private JButton openBtn = new JButton();
	private JButton homeBtn = new JButton();

	private RankingDao dao = new RankingDaoImpl();

	private String table = null;

	private List<Ranking> rankList = null;
	private Ranking nowUser = null;

	public MyRankPanel(String table) throws SQLException {
		this.table = table;
		paintBasic();
		paintMain();
		openBtn.addActionListener(this);
	}

	public MyRankPanel(String table, User user) throws SQLException {
		this.table = table;
		paintBasic();
		paintMain();

		titleLbl.setText("전체회원 랭킹 TOP 4");
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "전체회원 랭킹 TOP 4", "10대의 선택 TOP 3",
				"20대의 선택 TOP 3", "30대의 선택 TOP 3", "40대의 선택 TOP 3", "50대의 선택 TOP 3", }));

		for (int i = 0; i < questionLbl.length; i++) {
			questionLbl[i].setText(i + 1 + "위 " + dao.scoreRank().get(i).getTitle());
			percentLbl[i].setText(dao.scoreRank().get(i).getRatio() + "회");
			String[] value = percentLbl[i].getText().split("회");
			setColor(i, value);
			percentLbl[i].setFont(new Font("HY얕은샘물M", Font.PLAIN, 45));
		}

		// rankList.size() == 0 일때 나타낼것 구현

		try {
			rankList = new LinkedList<>(dao.scoreRank());
			for (int i = 0; i < rankList.size(); i++) {
				if (rankList.get(i).getTitle().equals(user.getId())) {
					nowUser = new Ranking(rankList.get(i).getTitle(), rankList.get(i).getRatio());
				}
			}
			questionLbl[4].setText("나의 순위 - " + (rankList.indexOf(nowUser) + 1) + "위 " + user.getId());
			percentLbl[4].setText(nowUser.getRatio() + "회");
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		pnl.repaint();

		openBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int select = comboBox.getSelectedIndex();
				switch (select) {
				case 0:
					try {
						for (int i = 0; i < questionLbl.length; i++) {
							questionLbl[i].setText(i + 1 + "위 " + dao.scoreRank().get(i).getTitle());
							percentLbl[i].setText(dao.scoreRank().get(i).getRatio() + "회");
							String[] value = percentLbl[i].getText().split("회");
							progressBar[i].setValue(Integer.parseInt(value[0]));
							setColor(i, value);
						}
						rankList = new LinkedList<>(dao.scoreRank());
						for (int i = 0; i < rankList.size(); i++) {
							if (rankList.get(i).getTitle().equals(user.getId())) {
								nowUser = new Ranking(rankList.get(i).getTitle(), rankList.get(i).getRatio());
							}
						}
						questionLbl[4].setText("나의 순위 - " + (rankList.indexOf(nowUser) + 1) + "위 " + user.getId());
						percentLbl[4].setText(nowUser.getRatio() + "회");
					} catch (SQLException e2) {
						e2.printStackTrace();
					}

					pnl.repaint();
					titleLbl.setText(comboBox.getSelectedItem().toString());
					break;

				case 1:
					useAgeTop(10);
					break;

				case 2:
					useAgeTop(20);
					break;

				case 3:
					useAgeTop(20);
					break;

				case 4:
					useAgeTop(40);
					break;

				case 5:
					useAgeTop(50);
					break;

				default:
					break;
				}

			}

			private void useAgeTop(int age) {
				for (int i = 0; i < questionLbl.length; i++) {
					try {
						if (i < dao.ageTop(age).size()) {
							questionLbl[i].setText(dao.ageTop(age).get(i).getTitle());
							percentLbl[i].setText(dao.ageTop(age).get(i).getRatio() + "회");
							String[] value = percentLbl[i].getText().split("회");
							progressBar[i].setValue(Integer.parseInt(value[0]));
							setColor(i, value);
						} else {
							questionLbl[i].setText(" ");
							percentLbl[i].setText(" ");
							progressBar[i].setValue(0);

						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				pnl.repaint();
				titleLbl.setText(comboBox.getSelectedItem().toString());
			}
		});

	}

	private void paintBasic() {
		pnl.setBackground(Color.WHITE);
		pnl.setLayout(null);

		titleLbl.setText("정답률 TOP 5");
		titleLbl.setForeground(new Color(0, 102, 102));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Adobe 고딕 Std B", Font.BOLD | Font.ITALIC, 60));
		titleLbl.setBounds(6, 30, 1138, 60);
		pnl.add(titleLbl);

		bottomPnl.setBackground(Color.WHITE);
		bottomPnl.setBounds(620, 700, 500, 35);
		bottomPnl.setLayout(null);
		pnl.add(bottomPnl);

		comboBox.setBounds(0, 0, 300, 35);
		comboBox.setBackground(new Color(0, 102, 102));
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "정답률 TOP 5", "오답률 TOP 5", "즐겨찾기한 문제 TOP 5", "많이 푼 문제 TOP 5" }));
		bottomPnl.add(comboBox);

		openBtn = new JButton("보기");
		openBtn.setBounds(300, 0, 90, 35);
		openBtn.setBackground(new Color(0, 102, 102));
		openBtn.setForeground(new Color(255, 255, 255));
		openBtn.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		bottomPnl.add(openBtn);

		homeBtn = new JButton("HOME");
		homeBtn.setBounds(390, 0, 90, 35);
		homeBtn.setBackground(new Color(0, 102, 102));
		homeBtn.setForeground(new Color(255, 255, 255));
		homeBtn.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		bottomPnl.add(homeBtn);
	}

	private void paintMain() throws SQLException {
		int y = 150;
		int length = 120;
		for (int i = 0; i < questionLbl.length; i++) {
			questionLbl[i] = new JLabel(dao.correctRatio("music").get(i).getTitle());
			questionLbl[i].setBounds(120, y - 50, 1000, 50);
			questionLbl[i].setForeground(new Color(0, 102, 102));
			questionLbl[i].setFont(new Font("HY얕은샘물M", Font.PLAIN, 40));
			questionLbl[i].setHorizontalAlignment(SwingConstants.LEFT);
			pnl.add(questionLbl[i]);

			progressBar[i] = new JProgressBar();
			progressBar[i].setBounds(200, y, 800, 50);
			progressBar[i].setUI(new MyProgressUI());
			progressBar[i].setBackground(new Color(255, 255, 255));
			pnl.add(progressBar[i]);

			percentLbl[i] = new JLabel(dao.correctRatio("music").get(i).getRatio() + "%");
			percentLbl[i].setBounds(950, y, 200, 50);
			String[] value = percentLbl[i].getText().split("%");
			setColor(i, value);

			percentLbl[i].setFont(new Font("GOST Common", Font.PLAIN, 45));
			percentLbl[i].setHorizontalAlignment(SwingConstants.CENTER);
			pnl.add(percentLbl[i]);
			y += length;
		}
	}

	private void setColor(int i, String[] value) {
		int bound = Integer.parseInt(value[0]);
		progressBar[i].setValue(bound);
		Color boundColor = new Color(0, 102, 102);
		if (bound >= 80) {
			boundColor = new Color(255, 0, 51);
		} else if (bound >= 60) {
			boundColor = new Color(153, 255, 102);
		} else if (bound >= 40) {
			boundColor = new Color(255, 102, 0);
		} else if (bound >= 20) {

		} else {
			boundColor = new Color(102, 102, 102);
		}
		progressBar[i].setForeground(boundColor);
		percentLbl[i].setForeground(boundColor);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int select = comboBox.getSelectedIndex();
		switch (select) {
		case 0:
			for (int i = 0; i < questionLbl.length; i++) {
				try {
					if (i < dao.correctRatio(table).size()) {
						questionLbl[i].setText(dao.correctRatio(table).get(i).getTitle());
						percentLbl[i].setText(dao.correctRatio(table).get(i).getRatio() + "%");
						String[] value = percentLbl[i].getText().split("%");
						progressBar[i].setValue(Integer.parseInt(value[0]));
						setColor(i, value);
					} else {
						questionLbl[i].setText(" ");
						percentLbl[i].setText(" ");
						progressBar[i].setValue(0);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			pnl.repaint();
			titleLbl.setText(comboBox.getSelectedItem().toString());
			break;

		case 1:
			for (int i = 0; i < questionLbl.length; i++) {
				try {
					if (i < dao.incorrectRatio(table).size()) {
						questionLbl[i].setText(dao.incorrectRatio(table).get(i).getTitle());
						percentLbl[i].setText(dao.incorrectRatio(table).get(i).getRatio() + "%");
						String[] value = percentLbl[i].getText().split("%");
						progressBar[i].setValue(Integer.parseInt(value[0]));
						setColor(i, value);
					} else {
						questionLbl[i].setText(" ");
						percentLbl[i].setText(" ");
						progressBar[i].setValue(0);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			pnl.repaint();
			titleLbl.setText(comboBox.getSelectedItem().toString());
			break;

		case 2:
			for (int i = 0; i < questionLbl.length; i++) {
				try {
					if (i < dao.favoriteTop(table).size()) {
						questionLbl[i].setText(dao.favoriteTop(table).get(i).getTitle());
						percentLbl[i].setText(dao.favoriteTop(table).get(i).getRatio() + "회");
						String[] value = percentLbl[i].getText().split("회");
						progressBar[i].setValue(Integer.parseInt(value[0]));
						setColor(i, value);
						percentLbl[i].setFont(new Font("HY얕은샘물M", Font.PLAIN, 45));
					} else {
						questionLbl[i].setText(" ");
						percentLbl[i].setText(" ");
						progressBar[i].setValue(0);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			pnl.repaint();
			titleLbl.setText(comboBox.getSelectedItem().toString());
			break;

		case 3:
			for (int i = 0; i < questionLbl.length; i++) {
				try {
					if (i < dao.maxTest(table).size()) {
						questionLbl[i].setText(dao.maxTest(table).get(i).getTitle());
						percentLbl[i].setText(dao.maxTest(table).get(i).getRatio() + "회");
						String[] value = percentLbl[i].getText().split("회");
						progressBar[i].setValue(Integer.parseInt(value[0]));
						percentLbl[i].setFont(new Font("HY얕은샘물M", Font.PLAIN, 45));
						setColor(i, value);
					} else {
						questionLbl[i].setText(" ");
						percentLbl[i].setText(" ");
						progressBar[i].setValue(0);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			pnl.repaint();
			titleLbl.setText(comboBox.getSelectedItem().toString());
			break;

		default:
			break;
		}
	}

	public Panel getPnl() {
		return pnl;
	}

	public JButton getHomeBtn() {
		return homeBtn;
	}
}