import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjCFU extends SuperObject{

	public ObjCFU() {
		name="CFU";
		try {
			image=ImageIO.read(getClass().getResourceAsStream("/objects/superata.gif"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
