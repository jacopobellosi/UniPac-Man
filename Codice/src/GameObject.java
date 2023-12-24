

import java.util.*;
import java.time.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
   public int x,y;
   public int speed;
   public Image up1,up2, down1,down2,left,right;
   public String direction;
   
   public Rectangle solidArea;
   public boolean collisionON = false;

    public BufferedImage image;
	public String name;
	public boolean collision=false;
	
	public void draw(Graphics2D g2,GameEngine gp) {
		int col = 0;
		int row = 0;
		int x =0;
		int y=0;
		while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
			//int tileNum = mapTilenum[col][row];
			g2.drawImage(image, x, y, gp.titleSize, gp.titleSize, null);
			col++;
			x +=gp.titleSize;
			
			if(col==gp.maxScreenCol){
				col =0;
				x=0;
				row++;
				y +=gp.titleSize;
			}
			
		}
	}
}