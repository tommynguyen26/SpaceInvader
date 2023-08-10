import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {

	public void playmusic(String musicfile) {
		File soundFile = new File(musicfile);

		try {

			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);
			clip.open(inputStream);
			clip.loop(clip.LOOP_CONTINUOUSLY);
			clip.start();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
   
}
