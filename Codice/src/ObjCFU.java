import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjCFU extends GameObject{

	public ObjCFU() {
		name="CFU";
		try {
			imagecfu=ImageIO.read(getClass().getResourceAsStream("/pacman/objects/superata.gif"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
