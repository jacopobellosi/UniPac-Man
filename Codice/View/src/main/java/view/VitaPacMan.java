package view;
import java.io.IOException;

import javax.imageio.ImageIO;


public class VitaPacMan extends GameObject {
	
	public VitaPacMan() {
		super("pacLife");
		try {
			imageVita=ImageIO.read(getClass().getResourceAsStream("/pacman/heart.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
