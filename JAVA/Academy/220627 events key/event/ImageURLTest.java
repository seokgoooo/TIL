package event;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageURLTest extends JFrame {
	public ImageURLTest() {
		JPanel pnl = new JPanel();
		Toolkit kit = Toolkit.getDefaultToolkit();

		// getResource src 폴더 안에서 자원을 찾아준다
		URL url = ImageURLTest.class.getClassLoader().getResource("images/춘식7.png");
		ImageIcon image = new ImageIcon(kit.getImage(url));
		URL url2 = ImageURLTest.class.getClassLoader().getResource("images/춘식10.png");
		ImageIcon imageChange = new ImageIcon(kit.getImage(url2));
		URL url3 = ImageURLTest.class.getClassLoader().getResource("images/춘식8.png");
		ImageIcon imageChange2 = new ImageIcon(kit.getImage(url3));
		URL url4 = ImageURLTest.class.getClassLoader().getResource("images/춘식11.png");
		ImageIcon imageChange3 = new ImageIcon(kit.getImage(url4));
		URL url5 = ImageURLTest.class.getClassLoader().getResource("images/춘식4.png");
		ImageIcon imageChange4 = new ImageIcon(kit.getImage(url5));

//		Image image = kit.getImage("icons8-cut-64.png");
////		Image imageChange = kit.getImage("춘식10.png");
//		Image imageChange2 = kit.getImage("춘식5.png");
//		Image imageChange3 = kit.getImage("춘식8.png");
//		Image imageChange4 = kit.getImage("춘식7.png");

		JLabel lbl = new JLabel(image);
		pnl.add(lbl);

		lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lbl.setIcon(imageChange);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lbl.setIcon(imageChange2);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl.setIcon(imageChange3);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl.setIcon(imageChange4);
			}
		});

		add(pnl);

		setSize(500, 500);
		setLocation(700, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ImageURLTest().setVisible(true);
	}
}