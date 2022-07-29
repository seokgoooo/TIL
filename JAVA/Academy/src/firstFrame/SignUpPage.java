// 해야할일 : 회원가입 후 DB에 user INSERT
// 완료 : GUI 구현, age 정수 체크 구현해봤는데 이슈 생김, ID 중복체크 표현, age 숫자만 입력하게 제한

package firstFrame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import user.User;
import user.UserDao;
import user.UserDaoImpl;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class SignUpPage extends JDialog {
	private JTextField idField;
	private JPasswordField passwordField;
	private JFormattedTextField ageField;
	private JCheckBox managerCheckBox;
	private MouseCursor mc = new MouseCursor();
	private TextLimit tl = new TextLimit();
	private TextFieldFocus tff = new TextFieldFocus();
	private JLabel idToolTipLbl;
	private JLabel ageToolTipLbl;
	private UserDao user = new UserDaoImpl();
	private Map<String, User> server = new HashMap<>();

	public SignUpPage() throws SQLException {
		super();
		// 회원가입 테스트용 Map
		userMapping();

		setType(Type.POPUP);
		setResizable(false);
		setFont(new Font("Dialog", Font.PLAIN, 20));
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("회원가입");
		setVisible(false);
		setSize(700, 550);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setModal(true);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(12, 50, 538, 450);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel idLbl = new JLabel("ID");
		idLbl.setBounds(0, 0, 200, 50);
		panel.add(idLbl);
		idLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		idLbl.setForeground(new Color(0, 102, 102));
		idLbl.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));

		JLabel passwordLbl = new JLabel("PASSWORD");
		passwordLbl.setBounds(0, 100, 200, 50);
		panel.add(passwordLbl);
		passwordLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLbl.setForeground(new Color(0, 102, 102));
		passwordLbl.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));

		JLabel ageLbl = new JLabel("AGE");
		ageLbl.setBounds(0, 200, 200, 50);
		panel.add(ageLbl);
		ageLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		ageLbl.setForeground(new Color(0, 102, 102));
		ageLbl.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));

		JLabel managerLbl = new JLabel("MANAGER");
		managerLbl.setBounds(0, 300, 200, 50);
		panel.add(managerLbl);
		managerLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		managerLbl.setForeground(new Color(0, 102, 102));
		managerLbl.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));

		idField = new JTextField();
		idField.setBounds(238, 0, 300, 50);
		panel.add(idField);
		idField.setForeground(new Color(0, 102, 102));
		idField.setBackground(new Color(255, 255, 255));
		idField.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
		idField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(238, 100, 300, 50);
		panel.add(passwordField);
		passwordField.setForeground(new Color(0, 102, 102));
		passwordField.setBackground(Color.WHITE);
		passwordField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		passwordField.setColumns(10);

		managerCheckBox = new JCheckBox(" 관리자일 경우 누르세요");
		managerCheckBox.setBounds(238, 300, 300, 50);
		panel.add(managerCheckBox);
		managerCheckBox.setForeground(Color.DARK_GRAY);
		managerCheckBox.setBackground(new Color(0, 0, 0));
		managerCheckBox.setFont(new Font("휴먼모음T", Font.PLAIN, 25));

		NumberFormatter range = new NumberFormatter();
		range.setValueClass(Integer.class);
		range.setMinimum(new Integer(1));
		range.setMaximum(new Integer(100));

		ageField = new JFormattedTextField(range);
		ageField.setBounds(238, 200, 300, 50);
		panel.add(ageField);
		ageField.setForeground(new Color(0, 102, 102));
		ageField.setBackground(Color.WHITE);
		ageField.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
		ageField.setColumns(10);

		JButton signUpBtn = new JButton("회원가입");
		signUpBtn.setBounds(238, 400, 300, 50);
		panel.add(signUpBtn);
		signUpBtn.setForeground(new Color(0, 102, 102));
		signUpBtn.setBackground(new Color(255, 255, 255));
		signUpBtn.setFont(new Font("휴먼모음T", Font.PLAIN, 25));

		idToolTipLbl = new JLabel("10글자 이내로 입력하세요");
		idToolTipLbl.setBounds(238, 50, 300, 30);
		panel.add(idToolTipLbl);
		idToolTipLbl.setHorizontalAlignment(SwingConstants.LEFT);
		idToolTipLbl.setForeground(new Color(255, 0, 51));
		idToolTipLbl.setFont(new Font("휴먼모음T", Font.PLAIN, 20));

		ageToolTipLbl = new JLabel("1 ~ 100사이의 숫자를 입력하세요");
		panel.add(ageToolTipLbl);
		ageToolTipLbl.setBounds(238, 250, 300, 30);
		ageToolTipLbl.setHorizontalAlignment(SwingConstants.LEFT);
		ageToolTipLbl.setForeground(new Color(255, 0, 51));
		ageToolTipLbl.setFont(new Font("휴먼모음T", Font.PLAIN, 20));

		signUpBtn.addActionListener(new ActionListener() {
			private String id;
			private String pw;
			private boolean manager;
			private int age;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					id = idField.getText().replaceAll(" ", "");
					pw = new String(passwordField.getPassword());
					manager = managerCheckBox.isSelected();
					age = Integer.parseInt(ageField.getText());
					ageToolTipLbl.setText("");

					if (id.length() == 0 || id.contains(" ")) {
						idToolTipLbl.setText("ID를 입력해주세요");
						if (pw.length() == 0 || pw.contains(" ")) {
							idToolTipLbl.setText("Password를 입력해주세요");
						}
					} else if (!server.containsKey(id)) {
						server.put(id, new User(id, pw, manager, age));
						user.create(id, pw, manager, age);
						showPopUp("회원가입 완료");
						dispose();
					} else {
						idToolTipLbl.setText("이미 등록된 ID 입니다");
					}
				} catch (NumberFormatException f) {
					ageToolTipLbl.setText("1 ~ 100사이의 숫자를 입력하세요");
					ageField.setText("");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				ageToolTipLbl.repaint();
				idToolTipLbl.repaint();
			}
		});

		signUpBtn.addMouseListener(mc);
		idField.addKeyListener(tl);
		idField.addFocusListener(tff);
		passwordField.addKeyListener(tl);

	}

	private void showPopUp(String text) {
		JOptionPane.showMessageDialog(SignUpPage.this, text);
	}

	public void userMapping() throws SQLException {
		int i = 0;
		while (i < user.read().size()) {
			server.put(user.read().get(i).getId(), user.read().get(i));
			i++;
		}
	}
}
