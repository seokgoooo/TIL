package incomplete;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PurchaseCheckBox extends JFrame implements ActionListener {
	private JCheckBox[] basicNumber;
	private JButton[] confirmRetouchBtns;
	private Consumer consumer = new Consumer();
	private Set<Integer> lottoNumberSet = new HashSet<>();

	public PurchaseCheckBox() {
		super("구매");
		List<List<Integer>> lottoList = new ArrayList<>();

		JPanel wrapPanel = new JPanel();
		JPanel leftPanel = new JPanel();

		JPanel purchasePanel = new JPanel();
		JPanel checkBoxPanel = new JPanel();
		JPanel bPanel = new JPanel();
		JPanel confirmPanel = new JPanel();

		JPanel rightPanel = new JPanel();

//		배치관리자 설정 부분
// --------------------------------------------------------------------------------
		BoxLayout leftBox = new BoxLayout(leftPanel, BoxLayout.Y_AXIS);
		leftPanel.setLayout(leftBox);

		BoxLayout purchasBox = new BoxLayout(purchasePanel, BoxLayout.Y_AXIS);
		purchasePanel.setLayout(purchasBox);

		BoxLayout confirmBox = new BoxLayout(confirmPanel, BoxLayout.Y_AXIS); // 구매확인 Panel의 배치를 box로
		confirmPanel.setLayout(confirmBox);
// --------------------------------------------------------------------------------
//		왼쪽 버튼들
// --------------------------------------------------------------------------------
		JRadioButton menualRB = new JRadioButton("수동");
		JRadioButton mixRB = new JRadioButton("혼합");
		JRadioButton autoRB = new JRadioButton("자동");
		ButtonGroup group = new ButtonGroup();

		group.add(menualRB);
		group.add(autoRB);
		group.add(mixRB);

		menualRB.setSelected(true);

		menualRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lottoNumberAllSelected();
				lottoNumberAllReset();
				lottoNumberSet.removeAll(lottoNumberSet);
			}
		});

		mixRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lottoNumberAllSelected();
				lottoNumberAllReset();
				lottoNumberSet.removeAll(lottoNumberSet);
			}
		});

		autoRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lottoNumberAllUnSelected();
				lottoNumberAllReset();
				lottoNumberSet.removeAll(lottoNumberSet);
			}
		});
// --------------------------------------------------------------------------------		
//		중간 panel (체크박스 부분)
// --------------------------------------------------------------------------------
		JButton initBtn = new JButton("초기화");
		JButton purchaseBtn = new JButton("구매");
		Integer[] purchaseCount = { 1, 2, 3, 4, 5 };
		JComboBox<Integer> purchaseCombo = new JComboBox<>(purchaseCount);
		JLabel priceLbl = new JLabel("지불 예정 금액: " + 1000 + "원");

		GridLayout grid = new GridLayout(5, 9); // 체크박스 배열 해놓은것

		checkBoxPanel.setLayout((grid));
		basicNumber = new JCheckBox[45];

		for (int i = 0; i < basicNumber.length; i++) { // 체크박스 값 입력
			basicNumber[i] = new JCheckBox(String.valueOf(i + 1));
			basicNumber[i].addActionListener(this);
			checkBoxPanel.add(basicNumber[i]);
		}

		initBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lottoNumberAllReset();
				lottoNumberSet.removeAll(lottoNumberSet);
			}
		});

		purchaseCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int p = (purchaseCombo.getSelectedIndex() + 1) * 1000;
				priceLbl.setText("지불 예정 금액: " + p + "원");
			}
		});
// --------------------------------------------------------------------------------
//		구매 확인 panel 구성 부분
//--------------------------------------------------------------------------------
		JButton confirmBtn = new JButton("구매 확정");
		JLabel purchaseConfirmLbl = new JLabel("구매 확인");
		JPanel confirmTopPnl = new JPanel();
		JPanel confirmBottomPnl = new JPanel();
		JButton confirmInitBtn = new JButton("초기화");

		confirmTopPnl.add(purchaseConfirmLbl);
		confirmTopPnl.add(confirmInitBtn);
		confirmPanel.add(confirmTopPnl);

		JPanel[] lottoPnl = new JPanel[5];

		// 로또 번호를 받는 5개의 panel을 생성
		for (int i = 0; i < lottoPnl.length; i++) {
			lottoPnl[i] = new JPanel();
			confirmPanel.add(lottoPnl[i]);
		}

		confirmRetouchBtns = new JButton[5];

		JLabel countPurchaseLbl = new JLabel("총 구매 횟수: 0");
		JLabel confirmPrice = new JLabel("금액: " + String.valueOf(consumer.getPrice()) + "원");

		confirmBottomPnl.add(countPurchaseLbl);
		confirmBottomPnl.add(confirmPrice);

		JLabel[][] lbl = new JLabel[5][7];

		// 구매 확인에서 첫번째 문자 넣어줌
		for (int i = 0; i < lottoPnl.length; i++) {
			char c = (char) ('A' + i);
			lbl[i][0] = new JLabel(String.valueOf(c));
			lottoPnl[i].add(lbl[i][0]);
		}

		// 구매 확인에서 로또 번호들을 나열하기 위해 label들을 생성
		for (int i = 0; i < lottoPnl.length; i++) {
			for (int j = 1; j < lbl[i].length; j++) {
				lbl[i][j] = new JLabel();
				lottoPnl[i].add(lbl[i][j]);
			}

		}

		// 수정 버튼 생성
		for (int i = 0; i < confirmRetouchBtns.length; i++) {
			confirmRetouchBtns[i] = new JButton("수정");
			lottoPnl[i].add(confirmRetouchBtns[i]);
		}

		// 구매 번호 초기화 버튼
		confirmInitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int price = -(1000 * lottoList.size());
				consumer.setPrice(price);
				confirmPrice.setText("금액: " + String.valueOf(consumer.getPrice()) + "원");
				for (int i = 0; i < lbl.length; i++) {
					for (int j = 1; j < lbl[i].length; j++) {
						lbl[i][j].setText("");
					}
				}
				lottoList.removeAll(lottoList);
			}
		});

		// 구매 확정 버튼 이벤트
		confirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consumer.setLottoList(lottoList);
				System.out.println(consumer.getList());
				lottoList.removeAll(lottoList);
				countPurchaseLbl.setText("총 구매 횟수: " + String.valueOf(String.valueOf(consumer.getCount()) + "회"));
				for (int i = 0; i < lbl.length; i++) {
					for (int j = 1; j < lbl[i].length; j++) {
						lbl[i][j].setText("");
					}
				}
				lottoList.removeAll(lottoList);
			}
		});

		// 수정 버튼 이벤트
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < confirmRetouchBtns.length; i++) {
					if (e.getSource() == confirmRetouchBtns[i]) {
						System.out.println(lottoList.get(i));
						for (int j = 0; j < lottoList.get(i).size(); j++) {
							basicNumber[lottoList.get(i).get(j)].setSelected(true);
						}
					}
				}
			}
		};

		for (int i = 0; i < confirmRetouchBtns.length; i++) {
			confirmRetouchBtns[i].addActionListener(listener);
		}
//--------------------------------------------------------------------------------
//			구매 버튼 클릭 이벤트
// --------------------------------------------------------------------------------
		purchaseBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (lottoList.size() + purchaseCombo.getSelectedIndex() + 1 > 5) { // 5장 넘게 구매X
					JOptionPane.showMessageDialog(purchasePanel, "복권은 한번에 5장까지 구매 가능합니다.");
				} else {
					if (mixRB.isSelected()) {
						System.out.println(lottoNumberSet);
						Integer[] arr = new Integer[lottoNumberSet.size()];
						System.out.println(arr.length);
						int countArr = 0;
						for (Integer number : lottoNumberSet) {
							arr[countArr] = number;
							countArr++;
						}
						for (int i = 0; i < purchaseCombo.getSelectedIndex() + 1; i++) {
							for (int j = 0; j < arr.length; j++) {
								lottoNumberSet.add(arr[j]);
							}
							while (lottoNumberSet.size() < 6) {
								lottoNumberSet.add(new Random().nextInt(45) + 1);
							}

							List<Integer> list = new ArrayList<Integer>(lottoNumberSet);
							Collections.sort(list);

							lottoList.add(list);

							lottoNumberAllReset();

							lottoNumberSet.removeAll(lottoNumberSet); // set을 초기화
						}

					} else if (menualRB.isSelected()) {
						if (lottoNumberSet.size() == 6) {
							List<Integer> list = new ArrayList<Integer>(lottoNumberSet);
							Collections.sort(list);

							for (int i = 0; i < purchaseCombo.getSelectedIndex() + 1; i++) {
								lottoList.add(list);

							}

							lottoNumberAllReset();
							lottoNumberSet.removeAll(lottoNumberSet);
						} else {
							JOptionPane.showMessageDialog(purchasePanel, "번호 6개를 선택해 주세요");

						}
					} else {
						for (int i = 0; i < purchaseCombo.getSelectedIndex() + 1; i++) {
							while (lottoNumberSet.size() < 6) {
								lottoNumberSet.add(new Random().nextInt(45) + 1);
							}

							List<Integer> list = new ArrayList<Integer>(lottoNumberSet);
							Collections.sort(list);

							lottoList.add(list);

							lottoNumberAllReset();

							lottoNumberSet.removeAll(lottoNumberSet); // set을 초기화
						}
					}
					// 구매 확인창에 번호를 보내줌
					for (int i = 0; i < lottoList.size(); i++) {
						for (int j = 0; j < lottoList.get(i).size(); j++) {
							lbl[i][j + 1].setText(String.format("%02d", lottoList.get(i).get(j)));
						}
					}
					if (autoRB.isSelected()) {
						lottoNumberAllUnSelected();
					} else {
						lottoNumberAllSelected();
					}
					consumer.setPrice((purchaseCombo.getSelectedIndex() + 1) * 1000);
					confirmPrice.setText("총 금액: " + consumer.getPrice() + "원");
					purchaseCombo.setSelectedIndex(0);
				}
			}
		});
// --------------------------------------------------------------------------------
//		right패널
// --------------------------------------------------------------------------------
		leftPanel.add(menualRB);
		leftPanel.add(mixRB);
		leftPanel.add(autoRB);

		bPanel.add(initBtn);
		bPanel.add(purchaseBtn);
		bPanel.add(purchaseCombo);

		purchasePanel.add(priceLbl);
		purchasePanel.add(checkBoxPanel);
		purchasePanel.add(bPanel);

		confirmPanel.add(confirmBottomPnl);
		confirmPanel.add(confirmBtn);

		wrapPanel.add(leftPanel);
		wrapPanel.add(purchasePanel);
		wrapPanel.add(confirmPanel);
		wrapPanel.add(rightPanel);

		getContentPane().add(wrapPanel);
		setSize(1000, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new PurchaseCheckBox().setVisible(true);
	}

	// checkbox를 모두 활성화
	public void lottoNumberAllSelected() {
		for (int i = 0; i < basicNumber.length; i++) {
			basicNumber[i].setEnabled(true);
		}
	}

	// checkbox를 모두 비활성화
	public void lottoNumberAllUnSelected() {
		for (int i = 0; i < basicNumber.length; i++) {
			basicNumber[i].setEnabled(false);
		}
	}

	// checkbox를 모두 초기화
	public void lottoNumberAllReset() {
		for (int i = 0; i < basicNumber.length; i++) {
			basicNumber[i].setSelected(false);
		}
	}

	// 구매하기 버튼 이벤트 set에 값을 넣는 과정
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < basicNumber.length; i++) {
			if (e.getSource() == basicNumber[i]) {
				if (basicNumber[i].isSelected()) {
					lottoNumberSet.add(i + 1);
				} else {
					lottoNumberSet.remove(i + 1);
				}
			}
			if (lottoNumberSet.size() == 6) {
				for (int j = 0; j < basicNumber.length; j++) {
					if (!basicNumber[j].isSelected()) {
						basicNumber[j].setEnabled(false);
					}
				}
			} else {
				lottoNumberAllSelected();
			}
		}

	}
}
