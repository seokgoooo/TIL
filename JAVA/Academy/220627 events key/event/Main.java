package event;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
	public static void main(String[] args) {
		new Main().setVisible(false);
		new ButtonEvent().setVisible(false);
		new LocationRandom().setVisible(false);
		new ImagePng().setVisible(true);
	}

	public Main() {
		MouseListener listener = new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("마우스 버튼을 놓음");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("마우스 버튼을 누름");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("영역 밖으로 벗어남");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Hover");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				switch (e.getButton()) {
				// return int
				case MouseEvent.BUTTON1:
					System.out.println("1번");
					break;
				case MouseEvent.BUTTON2:
					System.out.println("2번");
					break;
				case MouseEvent.BUTTON3:
					System.out.println("3번");
					break;
				}

				// return boolean (leftButton)
				System.out.println("왼쪽 버튼인가요? " + SwingUtilities.isLeftMouseButton(e));

				if (e.getClickCount() == 2) {
					System.out.println("마우스 더블 클릭!!");
				}
			}
		};

		MouseMotionListener motion = new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("마우스가 움직입니다~" + e.getX() + "," + e.getY());
			}

			@Override
			public void mouseDragged(MouseEvent e) {

			}
		};

		JPanel pnl = new JPanel();
		pnl.addMouseListener(listener);
		pnl.addMouseMotionListener(motion);
		add(pnl);
		setSize(500, 500);
		setLocation(300, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class ButtonEvent extends JFrame {
	public ButtonEvent() {
		JPanel pnl = new JPanel();
		JButton btn = new JButton("버튼");

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("액션 이벤트 발생");
			}
		});

		// mouseAdapter 를 통해 원하는 메소드만 오버라이드 할 수 있다
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("마우스 Pressed");
			}
		});

		pnl.add(btn);
		add(pnl);
		setSize(500, 500);
		setLocation(700, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class LocationRandom extends JFrame {
	public LocationRandom() {
		// 내부 위치나 크기를 정해주는 flowLayout을 없애기 위해서 Panel을 null로 줌
		JPanel pnl = new JPanel(null);
		pnl.setPreferredSize(new Dimension(500, 500));

		JButton btn = new JButton("Click Me");
		btn.setBounds(150, 150, 100, 100);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setLocation((int) (Math.random() * 400), (int) (Math.random() * 400));
			}
		});

		pnl.add(btn);
		add(pnl);

		pack();
		setLocation(1100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
}

class ImagePng extends JFrame {
	public ImagePng() {
		JPanel pnl = new JPanel();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image image = kit.getImage("icons8-cut-64.png");
		Image imageChange = kit.getImage("춘식10.png");
		Image imageChange2 = kit.getImage("춘식5.png");
		Image imageChange3 = kit.getImage("춘식8.png");
		Image imageChange4 = kit.getImage("춘식7.png");

		JLabel lbl = new JLabel(new ImageIcon(image));
		pnl.add(lbl);

		lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lbl.setIcon(new ImageIcon(imageChange));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lbl.setIcon(new ImageIcon(imageChange2));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl.setIcon(new ImageIcon(imageChange3));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl.setIcon(new ImageIcon(imageChange4));
			}
		});

		add(pnl);

		setSize(500, 500);
		setLocation(700, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}