// Aggiornamento della classe Player

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class Player  extends GameObject{
	
    GameEngine gp;
    InputManager keyH;
    
    public Player(GameEngine gp,InputManager keyH) {
    	this.gp=gp;
    	this.keyH=keyH;
    	setDefaultValue();
    	getPlayerImage();
    }
    
    public void setDefaultValue() {
    	x=100;
    	y=100;
    	speed = 4;
    	direction="down";
    }
    /*
    public void getPlayerImage() {
    	try {
    		up1 = ImageIO.read(getClass().getResourceAsStream("/pacman/su_dx.gif"));
    		up2 = ImageIO.read(getClass().getResourceAsStream("/pacman/su_sx.gif"));
    		down1 = ImageIO.read(getClass().getResourceAsStream("/pacman/giu_dx.gif"));
    		down1 = ImageIO.read(getClass().getResourceAsStream("/pacman/giu_sx.gif"));
    		right1 = ImageIO.read(getClass().getResourceAsStream("/pacman/destra.gif"));
    		left1 = ImageIO.read(getClass().getResourceAsStream("/pacman/sinistra.gif"));
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    */
    
    public void getPlayerImage()  {
    	up1 =  (BufferedImage)new ImageIcon(getClass().getResource("/pacman/su_dx.gif")).getImage();
		up2 = (BufferedImage) new ImageIcon(getClass().getResource("/pacman/su_sx.gif")).getImage();
		down1 = (BufferedImage) new ImageIcon(getClass().getResource("/pacman/giu_dx.gif")).getImage();
		down2 = (BufferedImage) new ImageIcon(getClass().getResource("/pacman/giu_sx.gif")).getImage();
		right1 = (BufferedImage) new ImageIcon(getClass().getResource("/pacman/destra.gif")).getImage();
		left1 =(BufferedImage) new ImageIcon(getClass().getResource("/pacman/destra.gif")).getImage();
    }
    
    public void update() {
    	if(keyH.upPressed == true) {
    		direction="up";
			y -=speed;
		}else if(keyH.downPressed == true) {
			direction="down";
			y +=speed;
		}else if(keyH.leftPressed == true) {
			direction="sinistra";
			x -=speed;
		}else if(keyH.rightPressed == true) {
			direction="destra";
			x +=speed;
		}
    }
    public void draw(Graphics2D g2) {
    	//g2.setColor(Color.white);
		//g2.fillRect(x, y, gp.titleSize, gp.titleSize);
		BufferedImage image = null;
		switch(direction) {
			case"up":
				image=up1;
				break;
			case"down":
				image=down1;
				break;
			case"left":
				image=left1;
				break;
			case"right":
				image=right1;
				break;
		}
		g2.drawImage(image, x, y, gp.titleSize, gp.titleSize, null);
    }
}
