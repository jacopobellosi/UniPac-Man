

import java.util.*;
import java.time.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
   
	public int x,y;
    public BufferedImage imagecfu,imageVita, powerUp;
	public String name;
	public boolean collision=false;
	public int mapTilenum[][];
	
   	public Rectangle solidArea = new Rectangle(0,0,20,20);
   	public int solidAreaDefaultx, solidAreaDefaulty;
   	
   	
   	
	public void drawCFU(Graphics2D g2,GameEngine gp) {

		int x = this.x ;
		int y= this.y ;
		

			g2.drawImage(imagecfu, x, y, gp.titleSize, gp.titleSize, null);
	}



	public void drawPW(Graphics2D g2, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		int x = this.x ;
		int y= this.y ;
		

			g2.drawImage(powerUp, x, y, gameEngine.titleSize, gameEngine.titleSize, null);
	}
}