package music;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MusicManagerMode extends JFrame implements ActionListener {
	private List<Music> list = new ArrayList<>();
	private MusicDao dao = new MusicDaoImpl();
	private MusicPlayer player = new MusicPlayer();
	private Music m = null;

	private URI uri = null;
	private boolean play = false;

	private JButton[] quizNumberBtns;
	private JRadioButton createRB;
	private JRadioButton updateRB;
	private JRadioButton deleteRB;
	private JTextField titleTf;
	private JTextField singerTf;
	private JTextField genreTf;
	private JTextField yearTf;
	private JButton confirmBtn;
	private JButton playBtn;
	private JButton stopBtn;
	private JPanel quizNumberPnl;
	private JPanel allPnl;

	public MusicManagerMode() {
		super("관리자 모드");

		try {
			list = dao.read();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		allPnl = new JPanel();

		JPanel topPnl = new JPanel();
		JPanel mainPnl = new JPanel();
		JPanel leftPnl = new JPanel();

		JPanel rightPnl = new JPanel();
		JPanel confirmPnl = new JPanel();
		quizNumberPnl = new JPanel();

		allPnl.setLayout(new BoxLayout(allPnl, BoxLayout.X_AXIS));
		leftPnl.setLayout(new BoxLayout(leftPnl, BoxLayout.Y_AXIS));

		topPnl.setBorder(new TitledBorder(new LineBorder(Color.red, 3), "기능"));

		mainPnl.setLayout(new BoxLayout(mainPnl, BoxLayout.Y_AXIS));
		mainPnl.setBorder(new TitledBorder(new LineBorder(Color.blue, 3), "내용"));

		rightPnl.setLayout(new BoxLayout(rightPnl, BoxLayout.Y_AXIS));
		rightPnl.setBorder(new TitledBorder(new LineBorder(Color.pink, 3), "right"));

		confirmPnl.setBorder(new TitledBorder(new LineBorder(Color.yellow, 3), "확인"));

		quizNumberPnl.setBorder(new TitledBorder(new LineBorder(Color.green, 3), "문제 번호"));
		quizNumberPnl.setLayout(new GridLayout(5, 6));

		// CRUD 라디오 버튼
		createRB = new JRadioButton("추가");
		createRB.addActionListener(this);
		updateRB = new JRadioButton("수정");
		updateRB.addActionListener(this);
		deleteRB = new JRadioButton("삭제");
		deleteRB.addActionListener(this);

		createRB.setSelected(true);

		topPnl.add(createRB);
		topPnl.add(updateRB);
		topPnl.add(deleteRB);

		ButtonGroup crudBG = new ButtonGroup();
		crudBG.add(createRB);
		crudBG.add(updateRB);
		crudBG.add(deleteRB);

		// 수정할 텍스트 부분 Panel
		JPanel titlePnl = new JPanel();
		JPanel singerPnl = new JPanel();
		JPanel genrePnl = new JPanel();
		JPanel yearPnl = new JPanel();

		JLabel titleLbl = new JLabel("제목");
		titleTf = new JTextField(20);
		titlePnl.add(titleLbl);
		titlePnl.add(titleTf);

		JLabel singerLbl = new JLabel("가수 ");
		singerTf = new JTextField(20);
		singerPnl.add(singerLbl);
		singerPnl.add(singerTf);

		JLabel genreLbl = new JLabel("장르");
		genreTf = new JTextField(20);
		genrePnl.add(genreLbl);
		genrePnl.add(genreTf);

		JLabel yearLbl = new JLabel("연도");
		yearTf = new JTextField(20);
		yearPnl.add(yearLbl);
		yearPnl.add(yearTf);

		mainPnl.add(titlePnl);
		mainPnl.add(singerPnl);
		mainPnl.add(genrePnl);
		mainPnl.add(yearPnl);

		// 기능 버튼
		confirmPnl.setLayout(new BoxLayout(confirmPnl, BoxLayout.Y_AXIS));

		confirmBtn = new JButton("확인");
		confirmBtn.addActionListener(this);

		playBtn = new JButton("재생");
		playBtn.addActionListener(this);

		stopBtn = new JButton("중지");
		stopBtn.addActionListener(this);
		stopBtn.setVisible(false);

		confirmPnl.add(confirmBtn);
		confirmPnl.add(playBtn);
		confirmPnl.add(stopBtn);

		// 문제 리스트
		quizNumberBtns = new JButton[list.size()];

		for (int i = 0; i < list.size(); i++) {
			quizNumberBtns[i] = new JButton(i + 1 + "");
			quizNumberBtns[i].addActionListener(this);
			quizNumberPnl.add(quizNumberBtns[i]);
		}

		leftPnl.add(topPnl);
		leftPnl.add(mainPnl);

		rightPnl.add(confirmPnl);
		rightPnl.add(quizNumberPnl);

		allPnl.add(leftPnl);
		allPnl.add(rightPnl);
		add(allPnl);

		setSize(700, 500);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				if (play) {
					player.end();
				}
			}

		});
	}

	// 버튼 이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirmBtn) {
			confirmBtnEvent();
		} else if (e.getSource() == playBtn) {
			playBtnEvent();
		} else if (e.getSource() == stopBtn) {
			stopBtnEvent();
		} else if (e.getSource() == createRB) {
			textInit();
		} else if (e.getSource() == updateRB) {
			textInit();
		} else if (e.getSource() == deleteRB) {
			textInit();
		} else {
			for (int i = 0; i < quizNumberBtns.length; i++) {
				if (e.getSource() == quizNumberBtns[i]) {
					if (play) {
						player.end();
					}
					playBtn.setVisible(true);
					stopBtn.setVisible(false);
					m = list.get(i);
					titleTf.setText(m.getTitle());
					singerTf.setText(m.getSinger());
					genreTf.setText(m.getGenre());
					yearTf.setText(String.valueOf(m.getYear()));
				}
			}
		}
	}

	// 확인 버튼 이벤트 메소드
	public void confirmBtnEvent() {
		if (createRB.isSelected()) {
			createMusic();
		} else if (updateRB.isSelected()) {
			updateMusic();
		} else {
			deleteMusic();
		}
	}

	// 재생 버튼 이벤트 메소드
	public void playBtnEvent() {
		try {
			player.play(copyInputStreamTofile(m.getTitle()));
			play = true;
			playBtn.setVisible(false);
			stopBtn.setVisible(true);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(allPnl, "선택후 재생해 주세요");
		}

	}

	// 정지 버튼 이벤트 메소드
	public void stopBtnEvent() {
		player.end();
		stopBtn.setVisible(false);
		playBtn.setVisible(true);
	}

	// text 초기화 메소드
	public void textInit() {
		m = null;
		titleTf.setText("");
		singerTf.setText("");
		genreTf.setText("");
		yearTf.setText("");
	}

	// music 생성 메소드
	public void createMusic() {
		try {
			File file = copyInputStreamTofile(titleTf.getText());
			if (file == null) {
				System.out.println("file없음");
			} else {
				Music musicTmp = new Music(titleTf.getText(), singerTf.getText(), genreTf.getText(),
						Integer.valueOf(yearTf.getText()), 0);
				if (!list.contains(musicTmp)) {
					dao.create(titleTf.getText(), singerTf.getText(), genreTf.getText(),
							Integer.valueOf(yearTf.getText()));
					list = dao.read();
					repaint();
				} else {
					JOptionPane.showMessageDialog(allPnl, "같은 이름의 곡은 등록 할 수 없습니다.");
				}
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(allPnl, "해당 필드 값이 올바른지 확인하세요.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// music 수정 메소드
	public void updateMusic() {
		try {
			File file = copyInputStreamTofile(titleTf.getText());
			if (file == null) {
				System.out.println("file없음");
			} else {
				Music musicTmp = new Music(titleTf.getText(), singerTf.getText(), genreTf.getText(),
						Integer.valueOf(yearTf.getText()), 0);
				if (!list.contains(musicTmp)) {
					dao.update(m.getNumber(), titleTf.getText(), singerTf.getText(), genreTf.getText(),
							Integer.valueOf(yearTf.getText()));
					list = dao.read();
					repaint();
				} else {
					JOptionPane.showMessageDialog(allPnl, "이미 해당 이름의 곡이 있습니다.");
				}
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(allPnl, "선택후 수정해 주세요");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(allPnl, "해당 필드 값이 올바른지 확인하세요");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// music 삭제 메소드
	public void deleteMusic() {
		try {
			dao.delete(m.getNumber());
			list = dao.read();
			textInit();
			repaint();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// inputStream을 파일로
	public File copyInputStreamTofile(String title) {
		title += ".mp3";
		File file = new File(title);
		InputStream is = MusicManagerMode.class.getClassLoader().getResourceAsStream(title);

		FileOutputStream outStream = null;
		try {
			outStream = new FileOutputStream(file);
			int read;
			byte[] bytes = new byte[1024];

			while ((read = is.read(bytes)) != -1) {
				outStream.write(bytes, 0, read);
			}

		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(allPnl, "해당 이름의 mp3파일이 있는지 확인하세요.");
			return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outStream != null) {
				try {
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return file;
	}

	// quizNumberPnl 다시 그리기
	@Override
	public void repaint() {
		quizNumberPnl.removeAll();
		quizNumberBtns = new JButton[list.size()];

		for (int i = 0; i < list.size(); i++) {
			quizNumberBtns[i] = new JButton(i + 1 + "");
			quizNumberBtns[i].addActionListener(this);
			quizNumberPnl.add(quizNumberBtns[i]);
		}

		quizNumberPnl.revalidate();
		quizNumberPnl.repaint();
	}
}
