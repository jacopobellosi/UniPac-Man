import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjCFU extends GameObject{

	public ObjCFU() {
		name="CFU";
		try {
			imagecfu=ImageIO.read(getClass().getResourceAsStream("/pacman/objects/CFU_piccolo.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
