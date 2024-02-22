package view;
import java.io.IOException;

import javax.imageio.ImageIO;


public class vitaPacMan extends GameObject {
	
	public vitaPacMan() {
		super("pacLife");
		try {
			imageVita=ImageIO.read(getClass().getResourceAsStream("/pacman/heart.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
