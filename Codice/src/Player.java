// Aggiornamento della classe Player

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class Player  extends Entity{

    InputManager keyH;
    int hashKey = 0;
    int pallini_totali;
    public Player(GameEngine gp,InputManager keyH) {
    	super(gp);
    	this.gp=gp;
    	this.keyH=keyH;


    	solidArea = new Rectangle(10,5,15,15);

    	
    	solidArea = new Rectangle(8,8,12,12);

    	solidAreaDefaultx= solidArea.x;
    	solidAreaDefaulty = solidArea.y;
    	pallini_totali = Tilemanger.getPalliniTotali();
    	setDefaultValue();
    	getPlayerImage();

    	Ghost.setTarget(this);
    	

    }

    public void setDefaultValue() {
    	x=150;
    	y=300;
    	speed = 4;
    	direction="down";
    	maxLife = 3;
    	life = maxLife;
    }
   
    public void getPlayerImage()  {
    	up1 =   new ImageIcon(getClass().getResource("/pacman/su_dx.gif")).getImage();
		up2 =   new ImageIcon(getClass().getResource("/pacman/su_sx.gif")).getImage();
		down1 = new ImageIcon(getClass().getResource("/pacman/giu_dx.gif")).getImage();
		down2 = new ImageIcon(getClass().getResource("/pacman/giu_sx.gif")).getImage();
		right =  new ImageIcon(getClass().getResource("/pacman/destra.gif")).getImage();
		left =  new ImageIcon(getClass().getResource("/pacman/sinistra.gif")).getImage();
		logo =  new ImageIcon(getClass().getResource("/pacman/logo.jpeg")).getImage();

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
    	int objIndex = gp.cCheck.checkObject(this, true);
    	mangiaPalline(objIndex);

    	int mangiaPW = gp.cCheck.checkPW(this, true);
    	mangiaPW(mangiaPW);
    	int monsterIndex = gp.cCheck.checkEntity(this, gp.ghost);
    	interazioneFanstasma(monsterIndex);
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

    	 if(invincible == true) {
    		 invincibleCounter++;
    		 if(invincibleCounter>60) {
    			 invincible=false;
    			 invincibleCounter=0;
    		 }
    	 }

    }
    private void mangiaPW(int mangiaPW) {
		// TODO Auto-generated method stub
    	if(mangiaPW != 999) {
    		String objectName = gp.pw[mangiaPW].name;
    		switch(objectName){
    		case"powerUp":
    			gp.pw[mangiaPW]=null;
    			System.out.println("HAI MANGIATO UN POWER UP");
    			break;
    		}

    	}
	}

	private void interazioneFanstasma(int monsterIndex) {
		// TODO Auto-generated method stub
		if(monsterIndex!=999) {
			System.out.println("Un fantasma ti ha colpito");
			if(invincible==false) {
				life-=1;
				System.out.println("ti sono rimaste: "+life +" vite");

				countLife();
				restartVita();
				invincible=true;
				if(life==0) {
					gp.gameState=gp.endState;
				}
			}
			
		}
	}
	public int countLife() {
		return life;
	}


	public void mangiaPalline(int i) {
    	if(i != 999) {
    		String objectName = gp.obj[i].name;
    		switch(objectName){
    		case"CFU":
    			hashKey++;
    			gp.obj[i]=null;
    			System.out.println("Numero pallini: "+ hashKey);
    			break;
    		}

    	}

    	if(hashKey==pallini_totali) {
    		gp.gameState=gp.endState;

			//ui.stopMusic(); in caso metteremo il suono
			//hashKey==pallini_totali  hashKey==3 per prove veloci di termine

    	}
    	if(gp.gameState==gp.endState) {
    		hashKey=0;
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

    public void reset() {
    	int i=0;
    	setDefaultValue();
    	mangiaPalline(i);
    	hashKey=0;
    }
}
