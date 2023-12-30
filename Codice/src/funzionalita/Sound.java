package funzionalita;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    private Clip clip;
    private URL soundURL[] = new URL[30];
    private boolean isPlaying = false;

    public Sound() {
        soundURL[0] = getClass().getResource("/pacman/sound/Theme.wav");
        soundURL[1] = getClass().getResource("/pacman/sound/saxophone.wav");
        soundURL[2] = getClass().getResource("/pacman/sound/pacman_chomp3.wav");
        soundURL[3] = getClass().getResource("/pacman/sound/pacman_eatfruit.wav");
        soundURL[4] = getClass().getResource("/pacman/sound/pixel-death.wav");
        soundURL[5] = getClass().getResource("/pacman/sound/zelda_theme_snes-cut-mp32.wav");
        
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playWin() {
        if (!isPlaying) {
            clip.start();
            isPlaying = true;
        }
    }

// TODO Remove unused code found by UCDetector
//     public void loopWin() {
//         clip.loop(Clip.LOOP_CONTINUOUSLY);
//         isPlaying = true;
//     }

// TODO Remove unused code found by UCDetector
//     public void stopWin() {
//         clip.stop();
//         isPlaying = false;
//     }

    public boolean isPlaying() {
        return isPlaying;
    }
    public void play() {
		clip.start();
	}
	
// TODO Remove unused code found by UCDetector
// 	public void loop() {
// 		clip.loop(Clip.LOOP_CONTINUOUSLY);
// 	}
	
	public void stop() {
		clip.stop();
	}
}
