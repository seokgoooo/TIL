package music;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import attempts.AttemptsDAO;
import attempts.AttemptsDAOImpl;
import attempts.AttemptsQuiz;
import favorite.FavoritesDAO;
import favorite.FavoritesDAOImpl;
import user.User;
import java.awt.Font;

public class MusicQuiz extends JFrame implements ActionListener {
	private MusicDao musicDao = new MusicDaoImpl();
	private MusicPlayer player = new MusicPlayer();
	private Music currentMusic = null;
	private Music prevMusic = null;
	private Map<Music, Music> map = new HashMap<>();
	private List<Music> list = new ArrayList<>();

	private User user;

	public JButton getHomeBtn() {
		return homeBtn;
	}

	public void setHomeBtn(JButton homeBtn) {
		this.homeBtn = homeBtn;
	}

	private AttemptsDAO attemptsDao = new AttemptsDAOImpl();
	private AttemptsQuiz attemptsQuiz = null;
	private List<Integer> clearList = new ArrayList<>();

	private FavoritesDAO favoriteDao = new FavoritesDAOImpl();
	private List<Integer> favoriteList = new ArrayList<>();

	// 즐겨찾기에 있는 번호 누를때
	private MouseAdapter mouseAdapter = new MouseAdapter() {

		@Override
		public void mousePressed(MouseEvent e) {
			for (int i = 0; i < favoriteQuiz.length; i++) {
				if (e.getSource() == favoriteQuiz[i]) {
					clickEvent(Integer.valueOf(favoriteQuiz[i].getText()) - 1);
				}
			}
		}
	};

	// 해결 문제에 있는 번호 누를때
	private MouseAdapter mouseAdapter2 = new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
			try {
				for (int i = 0; i < clearQuiz.length; i++) {
					if (e.getSource() == clearQuiz[i]) {
						clickEvent(Integer.valueOf(clearQuiz[i].getText()) - 1);
					}
				}

			} catch (NullPointerException e1) {
				System.out.println("뭐가 문제일까");
			}
		}
	};

	private JPanel pnlMain;
	private JButton confirmBtn;
	private JTextField answerTf;

	private JButton prevBtn;
	private JButton pauseBtn;
	private JButton playBtn;
	private JButton nextBtn;
	private JButton replayBtn;

	private Timer timer;
	private JLabel timeLbl;
	private final int timeOut = 60;

	private JButton[] allQuiz;
	private JButton[] clearQuiz;
	private JButton[] favoriteQuiz;

	private JLabel quizNumberLbl;
	private JCheckBox favoriteCb;

	private boolean play = false;
	private boolean first = true;
	private boolean prev = false;
	private JPanel quizClearPnl;
	private JPanel quizFavoritePnl;
	private JTextArea infoTA;
	private JButton homeBtn;

	public MusicQuiz(User user) {
		getContentPane().setBackground(new Color(0, 0, 0));
		this.user = user;
		JOptionPane.showMessageDialog(pnlMain, "**정답은 띄어쓰기 없이 한글로만 입력하셔야 됩니다.**");
		pnlMain = new JPanel();
		JPanel pnlLEFT = new JPanel();
		JPanel pnlRight = new JPanel();

		try {
			list = musicDao.read();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 왼쪽 하위 Panel
		JPanel leftTopPnl = new JPanel();
		JPanel answerPnl = new JPanel();
		JPanel questionPnl = new JPanel();

		// question Panel
		questionPnl.setPreferredSize(new Dimension(700, 600));

		URL lpUrl = MusicQuiz.class.getClassLoader().getResource("spacing out.gif");

		JLabel lpLbl = new JLabel(new ImageIcon(lpUrl));
		lpLbl.setPreferredSize(new Dimension(650, 370));

		infoTA = new JTextArea();
		infoTA.setDisabledTextColor(new Color(0, 204, 0));
		infoTA.setFont(new Font("Monospaced", Font.PLAIN, 40));
		infoTA.setForeground(Color.GREEN);

		questionPnl.add(lpLbl);
		questionPnl.add(infoTA);
		infoTA.setVisible(false);
		infoTA.setEnabled(false);

		// 오른쪽 하위 Panel
		JPanel showQuizPnl = new JPanel();
		JPanel functionPnl = new JPanel();

		// 문제와 정답을 맞출 텍스트 필드들
		answerTf = new JTextField(20);
		confirmBtn = new JButton("확인");
		confirmBtn.addActionListener(this);

		answerPnl.add(answerTf);
		answerPnl.add(confirmBtn);

		// tap 메뉴
		JTabbedPane showQuizTab = new JTabbedPane();
		JPanel quizAllPnl = new JPanel();
		quizFavoritePnl = new JPanel();
		quizClearPnl = new JPanel();

		showQuizTab.addTab("전체 문제", quizAllPnl);
		showQuizTab.addTab("즐겨 찾기", quizFavoritePnl);
		showQuizTab.addTab("해결 문제", quizClearPnl);

		showQuizPnl.add(showQuizTab);

		showQuizPnl.setPreferredSize(new Dimension(400, 500));
		showQuizTab.setPreferredSize(new Dimension(380, 500));

		// 전체 문제 panel
		quizAllPnl.setLayout(new GridLayout(5, 5));

		allQuiz = new JButton[list.size()];

		for (int i = 0; i < allQuiz.length; i++) {
			allQuiz[i] = new JButton(String.format("%02d", (i + 1)));
			allQuiz[i].addActionListener(this);
			quizAllPnl.add(allQuiz[i]);
		}

		// 해결 문제 panel
		quizClearPnl.setLayout(new GridLayout(5, 5));

		try {
			clearList = attemptsDao.MusicClearRead(user.getId(), true);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (clearList.size() != 0) {
			clearPnlRepaint();
		}

		// 즐찾 문제 panel
		quizFavoritePnl.setLayout(new GridLayout(5, 5));

		try {
			favoriteList = favoriteDao.musicRead(user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (favoriteList.size() != 0) {
			favoritePnlRepaint();
		}

		// 왼쪽 버튼
		leftTopPnl.setLayout(new BorderLayout());

		quizNumberLbl = new JLabel("문제 번호");
		quizNumberLbl.setFont(new Font("굴림", Font.PLAIN, 20));
		timeLbl = new JLabel("" + timeOut + "초");
		timeLbl.setFont(new Font("굴림", Font.PLAIN, 20));
		favoriteCb = new JCheckBox("즐겨찾기");
		favoriteCb.setFont(new Font("굴림", Font.PLAIN, 20));
		favoriteCb.addActionListener(this);

		leftTopPnl.add(quizNumberLbl, "West");
		leftTopPnl.add(timeLbl, "Center");
		timeLbl.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		leftTopPnl.add(favoriteCb, "East");

		homeBtn = new JButton("HOME");
		homeBtn.addActionListener(this);
		prevBtn = new JButton("이전");
		prevBtn.addActionListener(this);
		pauseBtn = new JButton("중지");
		pauseBtn.addActionListener(this);
		playBtn = new JButton("재생");
		playBtn.addActionListener(this);
		nextBtn = new JButton("다음");
		nextBtn.addActionListener(this);
		replayBtn = new JButton("다시 재생");
		replayBtn.addActionListener(this);

		pauseBtn.setVisible(false);
		replayBtn.setVisible(false);

		functionPnl.add(homeBtn);
		functionPnl.add(prevBtn);
		functionPnl.add(pauseBtn);
		functionPnl.add(playBtn);
		functionPnl.add(replayBtn);
		functionPnl.add(nextBtn);

		// panel 레이아웃
		pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.X_AXIS));
		pnlLEFT.setLayout(new BoxLayout(pnlLEFT, BoxLayout.Y_AXIS));
		pnlRight.setLayout(new BoxLayout(pnlRight, BoxLayout.Y_AXIS));

		// 테두리
		pnlLEFT.setBorder(new TitledBorder(new LineBorder(Color.pink, 3), "문제"));
		pnlRight.setBorder(new TitledBorder(new LineBorder(Color.pink, 3), "기타"));

		leftTopPnl.setBorder(new TitledBorder(new LineBorder(Color.green, 3), "시간과 즐겨찾기"));
		questionPnl.setBorder(new TitledBorder(new LineBorder(Color.green, 3), "lp사진 및 힌트"));
		answerPnl.setBorder(new TitledBorder(new LineBorder(Color.green, 3), "주관식 "));

		showQuizPnl.setBorder(new TitledBorder(new LineBorder(Color.CYAN, 3), "문제리스트"));
		functionPnl.setBorder(new TitledBorder(new LineBorder(Color.yellow, 3), "기능"));

		// 메인
		getContentPane().add(pnlMain);
		pnlMain.add(pnlLEFT);
		pnlMain.add(pnlRight);

		// 왼쪽 panel
		pnlLEFT.add(leftTopPnl);

		pnlLEFT.add(questionPnl);
		pnlLEFT.add(answerPnl);

		// 오른쪽 panel
		pnlRight.add(showQuizPnl);
		pnlRight.add(functionPnl);

		getMusic(list);
		clearTrue(currentMusic);

		setSize(1180, 820);
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
		} else if (e.getSource() == homeBtn) {
			homeBtnEvent();
		} else if (e.getSource() == pauseBtn) {
			pauseBtnEvent();
		} else if (e.getSource() == playBtn) {
			playBtnEvent();
		} else if (e.getSource() == prevBtn) {
			prevBtnEvent();
		} else if (e.getSource() == nextBtn) {
			nextBtnEvent();
		} else if (e.getSource() == replayBtn) {
			replayBtnEvent();
		} else if (e.getSource() == favoriteCb) {
			favoriteCbEvent();
		} else {
			for (int i = 0; i < allQuiz.length; i++) {
				if (e.getSource() == allQuiz[i]) {
					clickEvent(i);
				}
			}
		}
	}

	// tab메뉴 클릭 이벤트
	public void clickEvent(int i) {
		if (play) {
			player.end();
			timer.cancel();
		}

		infoTA.setVisible(false);
		answerTf.setText("");
		pauseBtn.setVisible(false);
		playBtn.setVisible(true);
		replayBtn.setVisible(false);

		prevMusic = currentMusic;
		currentMusic = list.get(i);

		clearTrue(currentMusic);
		favoriteCheck(currentMusic);

		quizNumberLbl.setText(String.format("%02d", (i + 1)) + "번");
		map.put(currentMusic, prevMusic);

		timeLbl.setText("" + 60 + "초");

		first = true;
	}

	public void homeBtnEvent() {
		dispose();

	}

	// 재생 버튼 이벤트
	public void playBtnEvent() {
		if (prev) {

			player.play(copyInputStreamTofile(currentMusic.getTitle()));
			prev = false;
			countDown();

		} else if (first) {
			player.play(copyInputStreamTofile(currentMusic.getTitle()));

			try {

				Music music = musicDao.read(currentMusic.getNumber());
				musicDao.playCountPlus(music.getNumber(), music.getPlayCount());

				attemptsQuiz = attemptsDao.read(user.getClearID(), currentMusic.getNumber());

				if (attemptsQuiz == null) {
					attemptsDao.create(user.getClearID(), currentMusic.getNumber());
					attemptsQuiz = attemptsDao.read(user.getClearID(), currentMusic.getNumber());
				} else {
					attemptsDao.updateCount(attemptsQuiz.getId(), attemptsQuiz.getQuizNumber(),
							attemptsQuiz.getAttemptsCount());
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			countDown();
			first = false;
		} else {
			player.musicRun();
		}

		play = true;
		playBtn.setVisible(false);
		pauseBtn.setVisible(true);
	}

	// 다시 재생 버튼
	private void replayBtnEvent() {
		replayBtn.setVisible(false);
		pauseBtn.setVisible(true);
		confirmBtn.setEnabled(true);
		player.play(copyInputStreamTofile(currentMusic.getTitle()));

		try {
			Music music = musicDao.read(currentMusic.getNumber());
			musicDao.playCountPlus(music.getNumber(), music.getPlayCount());
			attemptsQuiz = attemptsDao.read(user.getClearID(), currentMusic.getNumber());
			attemptsDao.updateCount(attemptsQuiz.getId(), attemptsQuiz.getQuizNumber(),
					attemptsQuiz.getAttemptsCount());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		countDown();
	}

	// 일시 정지 버튼 이벤트
	public void pauseBtnEvent() {
		player.stop();
		pauseBtn.setVisible(false);
		playBtn.setVisible(true);
	}

	// 확인 버튼 이벤트
	public void confirmBtnEvent() {
		if (play) {

			if (answerTf.getText().equals(currentMusic.getTitle())) {
				player.stop();
				playBtn.setVisible(true);
				pauseBtn.setVisible(false);
				try {
					attemptsDao.updateClear(attemptsQuiz.getId(), attemptsQuiz.getQuizNumber(), true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(pnlMain, "정답입니다.");
				confirmBtn.setEnabled(false);
				infoTA.setText("가수: " + currentMusic.getSinger() + "\n제목: " + currentMusic.getTitle() + "\n발매년도: "
						+ currentMusic.getYear());
				infoTA.setVisible(true);
				timer.cancel();
				clearPnlRepaint();
			} else {
				JOptionPane.showMessageDialog(pnlMain, "오답입니다.");
			}
			try {
				attemptsDao.updateCount(attemptsQuiz.getId(), attemptsQuiz.getQuizNumber(),
						attemptsQuiz.getAttemptsCount());
				int n = attemptsQuiz.getAttemptsCount() + 1;
				attemptsQuiz.setAttemptsCount(n);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(pnlMain, "노래를 먼저 재생해 주세요.");
		}
	}

	// 카운트 다운
	public void countDown() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			int count = timeOut;

			@Override
			public void run() {
				timeLbl.setText("" + count + "초");
				count--;
				if (count == 30) {
					infoTA.setText("가수: " + currentMusic.getSinger() + "\n장르: " + currentMusic.getGenre() + "\n발매년도: "
							+ currentMusic.getYear());
					infoTA.setVisible(true);
				} else if (count == 40) {
					infoTA.setText("가수: " + currentMusic.getSinger() + "\n장르: " + currentMusic.getGenre());
					infoTA.setVisible(true);
				} else if (count == 50) {
					infoTA.setText("가수: " + currentMusic.getSinger());
					infoTA.setVisible(true);
				}
				if (count < 0) {
					timer.cancel();
					timeLbl.setText("시간 초과");
					pauseBtn.setVisible(false);
					playBtn.setVisible(false);
					replayBtn.setVisible(true);
					player.end();
					confirmBtn.setEnabled(false);
				}
			}
		}, 0, 1000);
	}

	// 이전 버튼 이벤트
	public void prevBtnEvent() {
		if (play) {
			player.end();
			timer.cancel();
		}
		infoTA.setText("");
		timeLbl.setText("" + timeOut + "초");

		pauseBtn.setVisible(false);
		playBtn.setVisible(true);
		replayBtn.setVisible(false);
		answerTf.setText("");

		currentMusic = map.get(currentMusic);
		prevMusic = map.get(currentMusic);

		if (prevMusic == null) {
			prevBtn.setEnabled(false);
		}
		clearTrue(currentMusic);
		favoriteCheck(currentMusic);

		quizNumberLbl.setText(String.format("%02d", (list.indexOf(currentMusic) + 1)) + "번");

		prev = true;
		first = true;
	}

	// 다음 버튼 이벤트
	public void nextBtnEvent() {
		if (play) {
			player.end();
			timer.cancel();
		}

		infoTA.setText("");
		timeLbl.setText("" + timeOut + "초");
		getMusic(list);
		prevBtn.setEnabled(true);
		pauseBtn.setVisible(false);
		playBtn.setVisible(true);
		replayBtn.setVisible(false);

		answerTf.setText("");
		clearTrue(currentMusic);
		favoriteCheck(currentMusic);
		first = true;
	}

	// 즐겨찾기 버튼 이벤트
	public void favoriteCbEvent() {
		if (favoriteCb.isSelected()) {
			try {
				favoriteDao.create(user.getFavoriteID(), currentMusic.getNumber());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				favoriteDao.delete(user.getFavoriteID(), currentMusic.getNumber());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		favoritePnlRepaint();
	}

	// 즐겨찾기 표시
	public void favoriteCheck(Music music) {
		if (favoriteList.contains(music.getNumber())) {
			favoriteCb.setSelected(true);
		} else {
			favoriteCb.setSelected(false);
		}
	}

	// 해결한 문제인지 check 메소드
	public void clearTrue(Music music) {
		if (clearList.indexOf(music.getNumber()) != -1) {
			infoTA.setText("가수: " + currentMusic.getSinger() + "\n제목: " + currentMusic.getTitle() + "\n발매년도: "
					+ currentMusic.getYear());
			infoTA.setVisible(true);
			confirmBtn.setEnabled(false);
		} else {
			confirmBtn.setEnabled(true);
		}
	}

	// 해결 문제 그리기
	public void clearPnlRepaint() {
		quizClearPnl.removeAll();

		try {
			clearList = attemptsDao.MusicClearRead(user.getClearID(), true);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		clearQuiz = new JButton[clearList.size()];
		for (int i = 0; i < clearQuiz.length; i++) {
			Music m = null;

			try {
				m = musicDao.read(clearList.get(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			clearQuiz[i] = new JButton(String.format("%02d", (list.indexOf(m) + 1)));
			clearQuiz[i].addMouseListener(mouseAdapter2);
			quizClearPnl.add(clearQuiz[i]);
		}

		quizClearPnl.revalidate();
		quizClearPnl.repaint();
	}

	// 즐찾 문제 그리기
	public void favoritePnlRepaint() {
		quizFavoritePnl.removeAll();
		try {
			favoriteList = favoriteDao.musicRead(user.getFavoriteID());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		favoriteQuiz = new JButton[favoriteList.size()];

		for (int i = 0; i < favoriteQuiz.length; i++) {
			Music m = null;

			try {
				m = musicDao.read(favoriteList.get(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}

			favoriteQuiz[i] = new JButton(String.format("%02d", (list.indexOf(m) + 1)));
			favoriteQuiz[i].addMouseListener(mouseAdapter);
			quizFavoritePnl.add(favoriteQuiz[i]);
		}

		quizFavoritePnl.revalidate();
		quizFavoritePnl.repaint();
	}

	public File copyInputStreamTofile(String title) {
		title += ".mp3";
		File file = new File("musicTmp");
		InputStream is = MusicQuiz.class.getClassLoader().getResourceAsStream(title);
		FileOutputStream outStream = null;
		try {
			outStream = new FileOutputStream(file);
			int read;
			byte[] bytes = new byte[1024];

			while ((read = is.read(bytes)) != -1) {
				outStream.write(bytes, 0, read);
			}

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

//	// URI 가져오는 메소드
//	public URI getURI(String title) {
//		title += ".mp3";
//		URI uri = null;
//		try {
//			uri = MusicQuiz.class.getClassLoader().getResource(title).toURI();
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
//
//		return uri;
//	}

	// 음악 가져오는 메소드
	public Music getMusic(List<Music> list) {
		Random random = new Random();
		int index = random.nextInt(list.size());
		Music music = list.get(index);
		quizNumberLbl.setText(String.format("%02d", (index + 1)) + "번");

		while (music.equals(currentMusic)) {
			index = random.nextInt(list.size());
			music = list.get(index);
			quizNumberLbl.setText(String.format("%02d", (index + 1)) + "번");
		}

		prevMusic = currentMusic;
		currentMusic = music;

		if (prevMusic != null) {
			map.put(currentMusic, prevMusic);
		}

		return music;
	}

}