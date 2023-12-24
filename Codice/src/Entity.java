import java.awt.Image;
import java.awt.Rectangle;

public class Entity {
		public int x,y;
	   public int speed;
	   public Image up1,up2, down1,down2,left,right;
	   public String direction;
	   public boolean collision=false;
	   public Rectangle solidArea;
	   public boolean collisionON = false;

	   	public int solidAreaDefaultx, solidAreaDefaulty;
}
