package music;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicPlayerThread extends Thread {
	private Player player;

	public MusicPlayerThread(Player player) {
		setName("musicPlay");
		this.player = player;
	}

	@Override
	public void run() {
		try {
//			
//			for(int i = 1; i <= 5;i++) {				
//				Thread.sleep(1000);
//				System.out.println(i);
//			}		

			player.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		} // catch (InterruptedException e) {
//			e.printStackTrace();
//		}

	}

}
