package firstFrame;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MouseCursor implements MouseListener {
	// 마우스 커서 변경 구현체
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton jb = (JButton) e.getSource();
		jb.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton jb = (JButton) e.getSource();
		jb.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
}