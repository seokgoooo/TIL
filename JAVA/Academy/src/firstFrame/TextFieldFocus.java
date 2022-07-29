package firstFrame;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class TextFieldFocus implements FocusListener {
	// id pw 필드에 안내문구 표시할 구현체
	@Override
	public void focusGained(FocusEvent e) {
		JTextField src = (JTextField) e.getSource();
		if (src.getText().equals("10글자 이내로 입력")) {
			src.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField src = (JTextField) e.getSource();
		if (src.getText().equals("")) {
			src.setText("10글자 이내로 입력");
		}
	}
}
