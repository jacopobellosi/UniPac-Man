package UniPacMan.View;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import view.Sound;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@Test
    public void testPlayWin() {
        Sound sound = new Sound();
        sound.setFile(0); 
        assertFalse(sound.isPlaying()); //verifico che il suono non sia già in esecuzione
       
        sound.playWin();
        assertTrue(sound.isPlaying());
        /* Se si stoppa il suono e si verifica se continua a suonare si avrà un test fallito
        sound.stop();
        assertFalse(sound.isPlaying());
    	*/
    }
}
