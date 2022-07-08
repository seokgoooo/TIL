import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class App extends JFrame {
	App() {
		super();
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnl = new JPanel();
		JButton open = new JButton("열기");
		JButton save = new JButton("저장");
		JTextArea area = new JTextArea();
		area.setPreferredSize(new Dimension(200, 200));

		pnl.add(open);
		pnl.add(save);
		pnl.add(area);

		JFileChooser chooser = new JFileChooser();

		open.addActionListener(new ActionListener() {
			FileReader fr = null;
			BufferedReader br = null;

			@Override
			public void actionPerformed(ActionEvent e) {
				chooser.showOpenDialog(null);
				File openFile = chooser.getSelectedFile();

				try {
					fr = new FileReader(openFile);
					br = new BufferedReader(fr);
					String line;

					area.setText("");
					while ((line = br.readLine()) != null) {
						area.append(line);
						area.append("\n");
					}

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					if (fr != null) {
						try {
							fr.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					if (br != null) {
						try {
							br.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}

		});

		save.addActionListener(new ActionListener() {
			PrintWriter pw = null;

			@Override
			public void actionPerformed(ActionEvent e) {
				chooser.showSaveDialog(null);
				File saveFile = chooser.getSelectedFile();
				saveFile.getAbsolutePath();

				try {
					pw = new PrintWriter(new FileWriter(saveFile));
					pw.println(area.getText());
					pw.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					if (pw != null) {
						pw.close();
					}
				}
			}
		});

//		int result = chooser.showSaveDialog(null);
//		if (result == JFileChooser.APPROVE_OPTION) {
//			System.out.println("저장 버튼 눌렀을 때");
//			
//			File file = chooser.getSelectedFile();
//			System.out.println("사용자가 선택한 파일 : " + file.getAbsolutePath());
//			
//		}

		add(pnl);
	}

	public static void main(String[] args) {

		new App().setVisible(true);
	}
}