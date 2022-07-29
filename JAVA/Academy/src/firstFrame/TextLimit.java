package firstFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class TextLimit implements KeyListener {
	// 텍스트필드 글자수 제한 구현체
	@Override
	public void keyTyped(KeyEvent e) {
		int max = 10;
		JTextField src = (JTextField) e.getSource();
		if (src.getText().length() == max) {
			e.consume();
			String shortened = src.getText().substring(0, max);
			src.setText(shortened);
		} else if (src.getText().length() > max) {
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}