// Aggiornamento della classe Player

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player  extends GameObject{
	
    GameEngine gp;
    InputManager keyH;
    
    public Player(GameEngine gp,InputManager keyH) {
    	this.gp=gp;
    	this.keyH=keyH;
    	setDefaultValue();
    }
    
    public void setDefaultValue() {
    	x=100;
    	y=100;
    	speed = 4;
    }
    public void update() {
    	if(keyH.upPressed == true) {
			y -=speed;
		}else if(keyH.downPressed == true) {
			y +=speed;
		}else if(keyH.leftPressed == true) {
			x -=speed;
		}else if(keyH.rightPressed == true) {
			x +=speed;
		}
    }
    public void draw(Graphics2D g2) {
    	g2.setColor(Color.white);
		g2.fillRect(x, y, gp.titleSize, gp.titleSize);
		
    }
}
