package example;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main extends JFrame {
	public Main(String title) {
		super(title);
		CardLayout layout = new CardLayout();
		JPanel wrap = new JPanel(layout);
		Map<String, String> idPwServer = new LinkedHashMap<String, String>();
		idPwServer.put("sample", "value");

		// 메인 페이지 필드
		JPanel mainPanel = new JPanel();
		JPanel mainNoticeLabel = makeJPanel("로그인 프로그램입니다 ID 와 PW 를 입력하세요");
		JPanel mainIdLabel = makeJPanel("ID 는 4자 이상 12자 이하로 입력하세요");
		JTextField mainIdField = new JTextField(15);
		JPanel mainPasswordLabel = makeJPanel("Password 는 4자 이상 12자 이하로 입력하세요");
		JPasswordField mainPasswordField = new JPasswordField(15);

		mainPanel.add(mainNoticeLabel);
		mainPanel.add(mainIdLabel);
		mainPanel.add(mainIdField);
		mainPanel.add(mainPasswordLabel);
		mainPanel.add(mainPasswordField);
		add(mainPanel, "Center");
		mainPanel.setPreferredSize(new Dimension(200, 200));
		wrap.add(mainPanel, "Main");
		layout.show(wrap, "Main");

		// ID 필드 문구
		mainIdField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (mainIdField.getText().equals(""))
					mainIdField.setText("ID : 4자 이상 12자 이하");
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (mainIdField.getText().equals("ID : 4자 이상 12자 이하"))
					mainIdField.setText("");
			}
		});

		// 메인 페이지 버튼
		JPanel mainButtonPanel = new JPanel();
		JButton btnMain = new JButton("메인");
		JButton btnSignIn = new JButton("로그인");
		JButton btnSignUp = new JButton("회원가입");
		mainButtonPanel.add(btnMain);
		mainButtonPanel.add(btnSignUp);
		mainButtonPanel.add(btnSignIn);
		add(mainButtonPanel, "South");

		// 화면 전환 ActionListener
		ActionListener buttonActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("회원가입")) {
					layout.show(wrap, "SignUp");
				} else if (e.getActionCommand().equals("메인")) {
					layout.show(wrap, "Main");
				}
			}
		};

		btnMain.addActionListener(buttonActionListener);
		btnSignUp.addActionListener(buttonActionListener);

		// 로그인 버튼 ActionListener (ID PW 확인 일치)
		btnSignIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = new String(mainIdField.getText());
				String password = new String(mainPasswordField.getPassword());
				if (id.length() >= 4 && id.length() <= 12) {
					if (password.length() >= 4 && password.length() <= 12) {
						if (idPwServer.containsKey(id)) {
							if (password.equals(idPwServer.get(id))) {
								JOptionPane.showMessageDialog(Main.this, "로그인 성공");
							} else {
								JOptionPane.showMessageDialog(Main.this, "비밀번호가 달라요");
							}
						}
						if (!idPwServer.containsKey(id)) {
							JOptionPane.showMessageDialog(Main.this, "회원가입을 해주세요");
						}
					} else {
						JOptionPane.showMessageDialog(Main.this, "password 는 4자 ~ 12자 사이에요");
					}
				} else {
					JOptionPane.showMessageDialog(Main.this, "ID 는 4자 ~ 12자 사이에요");
				}
			}
		});

		// 로그인 버튼 페이지
		JPanel loginCheckPagePanel = makeJPanel("로그인 체크 페이지");
		wrap.add(loginCheckPagePanel, "Check");

		// 회원가입 버튼 페이지
		JPanel signUpPanel = makeJPanel("회원가입 페이지");
		JPanel signUpIdPanel = makeJPanel("ID 를 입력하세요");
		JTextField signUpIdField = new JTextField(10);
		JPanel signUpPasswordPanel = makeJPanel("Password 를 입력하세요");
		JPasswordField signUpPasswordField = new JPasswordField(10);
		JPanel signUpCheckPanel = makeJPanel("Password 를 한 번 더 입력하세요");
		JPasswordField signUpCheckField = new JPasswordField(10);
		JButton btnSignUpPage = new JButton("회원가입");

		signUpPanel.add(signUpIdPanel);
		signUpPanel.add(signUpIdField);
		signUpPanel.add(signUpPasswordPanel);
		signUpPanel.add(signUpPasswordField);
		signUpPanel.add(signUpCheckPanel);
		signUpPanel.add(signUpCheckField);
		signUpPanel.add(btnSignUpPage);
		wrap.add(signUpPanel, "SignUp");
		add(wrap);
		BoxLayout box = new BoxLayout(signUpPanel, BoxLayout.Y_AXIS);
		signUpPanel.setLayout(box);

		// 비밀번호 일치 체크
		btnSignUpPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = signUpIdField.getText();
				String password = new String(signUpPasswordField.getPassword());
				String check = new String(signUpCheckField.getPassword());
				// Id PW : 4 ~ 12 자 사이
				if (id.length() >= 4 && id.length() <= 12) {
					if (password.length() >= 4 && password.length() <= 12) {
						// PW 가 PW 확인과 같은지 확인
						if (password.equals(check)) {
							// ID 가 이미 등록된 ID 인지 확인
							if (!idPwServer.containsKey(id)) {
								idPwServer.put(id, password);
								JOptionPane.showMessageDialog(Main.this, "회원가입 완료");
							} else {
								JOptionPane.showMessageDialog(Main.this, "이미 등록된 ID 입니다");
							}
						} else {
							JOptionPane.showMessageDialog(Main.this, "같은 비밀번호를 두 번 입력해주세요");
						}
					} else {
						JOptionPane.showMessageDialog(Main.this, "password 는 4자 ~ 12자 사이에요");
					}
				} else {
					JOptionPane.showMessageDialog(Main.this, "ID 는 4자 ~ 12자 사이에요");
				}
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(390, 450);
		setLocation(700, 100);
	}

	private JPanel makeJPanel(String text) {
		JPanel panel = new JPanel();
		panel.add(new JLabel(text));
		return panel;
	}

	public static void main(String[] args) {
		new Main("로그인 회원가입 프로그램").setVisible(true);
	}
}