package view;
import java.io.IOException;

import javax.imageio.ImageIO;

public class vitaPacMan extends GameObject {
	GameEngine gp;
	public vitaPacMan(GameEngine gp) {
		this.gp=gp;
		name="pacLife";
		try {
			imageVita=ImageIO.read(getClass().getResourceAsStream("/pacman/heart.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
