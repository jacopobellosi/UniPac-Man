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
    	
    	solidArea = new Rectangle(8,16,32,32);
    	solidAreaDefaultx=8;
    	solidAreaDefaulty = 16;
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
      public void getPlayerImage(){
      		try{
      			up1 = ImageIO.read(getClass().getResourceAsStream("/pacman/su_dx.gif"));
      			up2 = ImageIO.read(getClass().getResourceAsStream("/pacman/su_sx.gif"));
      			down1 = ImageIO.read(getClass().getResourceAsStream("/pacman/giu_dx.gif"));
      			down2 = ImageIO.read(getClass().getResourceAsStream("/pacman/giu_sx.gif"));
      			right = ImageIO.read(getClass().getResourceAsStream("/pacman/destra.gif"));
      			left = ImageIO.read(getClass().getResourceAsStream("/pacman/sinistra.gif"));
      			
     		}catch(IOException e) {
     			e.printStackTrace();
     		}
      }
   */
    
    public void getPlayerImage()  {
    	up1 =   new ImageIcon(getClass().getResource("/pacman/su_dx.gif")).getImage();
		up2 =   new ImageIcon(getClass().getResource("/pacman/su_sx.gif")).getImage();
		down1 = new ImageIcon(getClass().getResource("/pacman/giu_dx.gif")).getImage();
		down2 = new ImageIcon(getClass().getResource("/pacman/giu_sx.gif")).getImage();
		right =  new ImageIcon(getClass().getResource("/pacman/destra.gif")).getImage();
		left =  new ImageIcon(getClass().getResource("/pacman/sinistra.gif")).getImage();
    }
    
    
    public void update() {
    	if(keyH.upPressed == true) {
    		direction="up";
		}else if(keyH.downPressed == true) {
			direction="down";
		}else if(keyH.leftPressed == true) {
			direction="left";
		}else if(keyH.rightPressed == true) {
			direction="right";
		}
    	
    	collisionON = false;
    	gp.cCheck.checktile(this);
    	
    	//check collision
    	/*
    	if( collisionON == false) {
    		switch(direction){
    		case"up":
    			y -=speed;
    			break;
    		case"down":
    			y +=speed;
    			break;
    		case"right":
    			x +=speed;
    			break;
    		case"left":
    			x -=speed;
    			break;
    		}
    	}
    	*/
    	if(keyH.upPressed == true && collisionON == false) {
    		y -=speed;
    	}else if(keyH.downPressed == true && collisionON == false) {
    		y +=speed;
    	}else if(keyH.leftPressed == true && collisionON == false) {
    		x -=speed;
    	}else if(keyH.rightPressed == true && collisionON == false) {
    		x +=speed;
    	}
    	
    	
    	
    }
    public void draw(Graphics2D g2) {
    	//g2.setColor(Color.white);
		//g2.fillRect(x, y, gp.titleSize, gp.titleSize);
		Image image = null;
		switch(direction) {
			case"up":
				image=up1;
				break;
			case"down":
				image=down1;
				break;
			case"left":
				image=left;
				break;
			case"right":
				image=right;
				break;
		}
		g2.drawImage(image, x, y, gp.titleSize, gp.titleSize, null);
		
    }
}