import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameRestart implements KeyListener {
	UniPacman uni=new UniPacman();
	@Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            uni.restartGame();
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
