// Aggiornamento della classe Player
package entita;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.ImageIcon;
import javax.swing.Timer;

import engineDelGioco.GameEngine;
import engineDelGioco.InputManager;
import engineDelGioco.Tilemanger;

import thread.gestoreUccisoni;



public class Player  extends Entity{

    private InputManager keyH;
    int hashKey = 0;
    public int punteggio =0;
    public int pallini_totali;
    private Timer powerUpTimer;
    private gestoreUccisoni GU;
    public Player(GameEngine gp,InputManager keyH) {
    	super(gp);
    	this.gp=gp;
    	this.keyH=keyH;

    	name="pacman";
    	//solidArea = new Rectangle(10,5,15,15);

    	type=0;
    	solidArea = new Rectangle(8,10,20,20);

    	solidAreaDefaultx= solidArea.x;
    	solidAreaDefaulty = solidArea.y;
    	pallini_totali = Tilemanger.getPalliniTotali();
    	setDefaultValue();
    	getPlayerImage();
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
   
    private void getPlayerImage()  {
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
    	 gp.eHandler.checkEvent(this);
    	collisionON = false;
    	gp.cCheck.checktile(this);
    	int objIndex = gp.cCheck.checkObject(this, true);
    	mangiaPalline(objIndex);

    	int mangiaPW = gp.cCheck.checkPW(this, true);
    	mangiaPW(mangiaPW);
    	int monsterIndex = gp.cCheck.checkEntity(this, gp.ghost);
    	interazioneFanstasma(monsterIndex);
    	
    	//check collision
    	//gp.eHandler.checkEvent();
    	
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

	private void interazioneFanstasma(int monsterIndex) {
		// TODO Auto-generated method stub
		if(monsterIndex!=999) {
			if(invincible==false && attacking ==false) {
				life-=1;
				System.out.println("Un fantasma ti ha colpito");
				System.out.println("ti sono rimaste: "+life +" vite");
				countLife();
				restartVita();
				setDefaultValue();
				gp.aSetter.setMonster();
				invincible=true;
				if(life==0) {
					gp.gameState=gp.endState;
					hashKey=0;
					punteggio=0;
					
				}
			}else if(attacking==true) {
				if(gp.ghost[monsterIndex].invincible==false) {
					
					punteggio+=60;
					//tipiFantasmiEliminati.add(tipoFantasmaEliminato);
					GU = new gestoreUccisoni(gp,gp.ghost[monsterIndex].type);
					GU.start();
	                gp.killMonster(monsterIndex);
					//tipiFantasmiEliminati.add(tipoFantasmaEliminato);
					//respawnTimer.start();
				}
					
			}
			
		}
	}
	public int countLife() {
		return life;
	}


	private void mangiaPalline(int i) {
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

    	if(hashKey==4 && gp.livelloCorrente!=gp.livelloMax ) {
    		gp.gameState=gp.nextLevelState;
    		hashKey=0;
			//ui.stopMusic(); in caso metteremo il suono
			//hashKey==pallini_totali  hashKey==3 per prove veloci di termine

    	}
    	if(gp.livelloCorrente == gp.livelloMax && hashKey==4) {
    		//hashKey==pallini_totali 
    		gp.gameState=gp.endState;
    		hashKey=0;
    		punteggio=0;
    		reset();
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

    private void reset() {
    	setDefaultValue();
    	setDefaultLife();
    	hashKey=0;
    }
}
