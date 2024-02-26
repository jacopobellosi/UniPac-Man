package controller;
import java.awt.Image;
import java.awt.Rectangle;


public class Entity {
	   public static int x;
	   public static int y;
	   int speed;
	   public Image up1,up2, down1,down2,left,right, imageGhost,logo, imageFantasma_vunerabile; // NO_UCD (use default)
	   public static String direction;
	   public boolean collision=false; // NO_UCD (unused code)
	   public static Rectangle solidArea = new Rectangle(0,0,48,48);
	   boolean collisionON = false;
	   int maxLife;
	   int life;
	   public boolean invincible = false;
	   int invincibleCounter=0;
	   int actionlockCounter=0;
	   int type;
	   public static boolean attacking =false;
	   Rectangle attackArea = new Rectangle(0,0,0,0);
	   String name; // NO_UCD (unused code)
	   private GestoreUccisoni GU;
	   int solidAreaDefaultx, solidAreaDefaulty;
	   GameEngine gp;
	   
	   
	   Entity(GameEngine gp) {
		   this.gp = gp;
	   }

	   public void update() {
		   setAction();
		   collisionON = false;
		   gp.cCheck.checkTile(this);
		   gp.cCheck.checkEntity(this, gp.ghost);
		   gp.eHandler.checkEvent(this);

		   boolean contactPlayer = gp.cCheck.checkPlayer(this);
		   
		   if(this.type!=0 && contactPlayer==true) {
			   if(gp.player.invincible==false && gp.player.attacking==false) {
				   gp.player.life-=1;
				   gp.player.invincible=true;
				   gp.player.setDefaultValue();
				   gp.setMonster();
				   System.out.println("Il fantasma "+this.type+" ti ha colpito");
				   if(gp.player.life==0) {
						gp.gameState=gp.endState;
						gp.player.hashKey=0;
						gp.player.punteggio=0;
					}
				   
			   }else if(gp.player.attacking==true) {
				   if(this.invincible==false) {	
					   int type =this.type;
						gp.player.punteggio+=60;
						
						for(int i=0;i<gp.ghost.length;i++) {
							if(gp.ghost[i]==this) {
								gp.killMonster(i);
							}
						}
						GU = new GestoreUccisoni(gp,type);
						GU.start();
					}
			   }
		   }

		   if(direction=="up" && collisionON == false) {
	    		y -=speed;
	    	}else if(direction=="down" && collisionON == false) {
	    		y +=speed;
	    	}else if(direction=="left" && collisionON == false) {
	    		x -=speed;
	    	}else if(direction=="right" && collisionON == false) {
	    		x +=speed;
	    	}
		   
		  
	   }
	   
	   public void setAction() {
		
	   }
	   
	   void restartVita() {
		
	   }


}
