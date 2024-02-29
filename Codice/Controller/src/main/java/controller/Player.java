// Aggiornamento della classe Player
package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Player  extends Entity{

    private InputManager keyH;
    public static int hashKey = 0;
    public static int punteggio =0;
    int pallini_totali;
    private Timer powerUpTimer;
    public  GestoreUccisoni GU;

    public Player(GameEngine gp,InputManager keyH) {
    	super(gp);
    	this.gp=gp;
    	this.keyH=keyH;

    	name="pacman";

    	type=0;
    	solidArea = new Rectangle(8,10,20,20);

    	solidAreaDefaultx= solidArea.x;
    	solidAreaDefaulty = solidArea.y;
    	
    	setDefaultValue();
    	//getPlayerImage();
    	attackArea.width = 36;
    	attackArea.height =36;
    	
    	powerUpTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Azioni da eseguire quando il timer scade
                attacking = false;
                System.out.println("POWER UP SCADUTO");
                // Puoi anche interrompere il timer se necessario
                powerUpTimer.stop();
            }
        });
        powerUpTimer.setRepeats(false);	


    }

    public void setDefaultValue() {

    	x=1 * gp.titleSize;
    	y=6 * gp.titleSize;
    	speed = 4;
    	direction="down";
    	
    }
    
    public void setDefaultLife() {
    	maxLife = 3;
    	life = maxLife;
    }
   /*
    private void getPlayerImage()  {
    	up1 =   new ImageIcon(getClass().getResource("/pacman/su_dx.gif")).getImage();
		up2 =   new ImageIcon(getClass().getResource("/pacman/su_sx.gif")).getImage();
		down1 = new ImageIcon(getClass().getResource("/pacman/giu_dx.gif")).getImage();
		down2 = new ImageIcon(getClass().getResource("/pacman/giu_sx.gif")).getImage();
		right =  new ImageIcon(getClass().getResource("/pacman/destra.gif")).getImage();
		left =  new ImageIcon(getClass().getResource("/pacman/sinistra.gif")).getImage();

    }

	*/
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
    	
 
    	 
    	 
    	gp.eHandler.checkEvent(this);
    	collisionON = false;
    	gp.cCheck.checkTile(this);
    	int objIndex = gp.cCheck.checkObject(this, true);
    	mangiaPalline(objIndex);

    	int mangiaPW = gp.cCheck.checkPW(this, true);
    	mangiaPW(mangiaPW);
    	int monsterIndex = gp.cCheck.checkEntity(this, gp.ghost);
    	interazioneFanstasma(monsterIndex);
    
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


	public void mangiaPW(int mangiaPW) {
		// TODO Auto-generated method stub
    	if(mangiaPW != 999) {
    		String objectName = gp.pw[mangiaPW].name;
    		switch(objectName){
    		case"powerUp":
    			gp.playSE(3);
    			gp.pw[mangiaPW]=null;
    			punteggio+=12;
    			hashKey++;
    			gp.eHandler.checkEvent(this);
    			System.out.println("HAI MANGIATO UN POWER UP");
    			attacking=true;
    			powerUpTimer.start();
    			break;
    		}
    	}
	}

	public void interazioneFanstasma(int monsterIndex) {
		// TODO Auto-generated method stub
		if(monsterIndex!=999) {
			if(invincible==false && attacking ==false) {
				life-=1;
				System.out.println("Hai colpito il fantasma"+gp.ghost[monsterIndex].type+"");
				System.out.println("ti sono rimaste: "+life +" vite");
				countLife();
				restartVita();
				setDefaultValue();
				gp.setMonster();
				invincible=true;
				if(life==0) {
					gp.gameState=gp.endState;
					hashKey=0;
					punteggio=0;
					
				}
			}else if(attacking==true) {
				if(gp.ghost[monsterIndex].invincible==false) {
					punteggio+=60;
					GU = new GestoreUccisoni(gp,gp.ghost[monsterIndex].type);
					GU.start();
	                gp.killMonster(monsterIndex);
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
    			gp.playSE(2);
    			hashKey++;
    			punteggio+=6;
    			gp.obj[i]=null;
    			System.out.println("Numero pallini: "+ hashKey+" su "+pallini_totali);
    			break;
    		}

    	}

    	if(hashKey==pallini_totali && gp.livelloCorrente!=gp.livelloMax ) {
    		gp.gameState=gp.nextLevelState;
    		hashKey=0;

    	}
    	if(gp.livelloCorrente == gp.livelloMax && hashKey==pallini_totali) {
    		gp.gameState=gp.endState;
    		hashKey=0;
    		punteggio=0;
    		reset();
    	}
    }
	/*
    void draw(Graphics2D g2) {

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
	*/
    private void reset() {
    	setDefaultValue();
    	setDefaultLife();
    	hashKey=0;
    }

	public Object getMaxLife() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAttacking() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setLife(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setInvincible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void setAttacking(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public boolean isInvincible() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
