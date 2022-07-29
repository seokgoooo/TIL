package music;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicPlayer {
	private Player player;
	MusicPlayerThread playThread = null;

	public void play(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			player = new Player(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}

		playThread = new MusicPlayerThread(player);

		playThread.start();

	}

	public void musicRun() {
		playThread.resume();
	}

	public void stop() {
		playThread.suspend();
	}

	public void end() {
		playThread.stop();
		
		if(player != null) {
			player.close();
		}
	}
}
