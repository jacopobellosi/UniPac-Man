import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
		public int x,y;
	   public int speed;
	   public Image up1,up2, down1,down2,left,right, imageGhost,logo, imageFantasma_vunerabile;
	   public String direction;
	   public boolean collision=false;
	   public Rectangle solidArea = new Rectangle(0,0,48,48);
	   public boolean collisionON = false;
	    int maxLife,life;
	   public boolean invincible = false;
	   public int invincibleCounter=0;
	   public int actionlockCounter=0;
	   public int type;
	   boolean attacking =false;
	   public Rectangle attackArea = new Rectangle(0,0,0,0);
	   String name;
	   	public int solidAreaDefaultx, solidAreaDefaulty;
	   	GameEngine gp;
	   public Entity(GameEngine gp) {
		   this.gp = gp;
	   }

	   public void update() {
		   setAction();
		   collisionON = false;
		   gp.cCheck.checktile(this);
		   //gp.cCheck.checkObject(this, false);
		   gp.cCheck.checkEntity(this, gp.ghost);
		   boolean contactPlayer = gp.cCheck.checkPlayer(this);
		   
		   if(this.type==1 && contactPlayer==true) {
			   if(gp.player.invincible==false && gp.player.attacking==false) {
				   gp.player.life-=1;
				   gp.player.invincible=true;
				   gp.player.setDefaultValue();
			   }else if(gp.player.attacking==true) {
				   this.life-=1;
				   gp.ghost[this.hashCode()].killMonster(this.hashCode());
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
	   void setAction() {
		// TODO Auto-generated method stub
		
	   }
	public void restartVita() {
		
	}
	public void draw(Graphics2D g2) {
		   	int x = this.x ;
			int y= this.y ;
			

				g2.drawImage(imageFantasma_vunerabile, x, y, gp.titleSize, gp.titleSize, null);
	  }
	public void drawFantasmaVulnerabile(Graphics2D g2) {
	   	int x = this.x ;
		int y= this.y ;
		

			g2.drawImage(imageGhost, x, y, gp.titleSize, gp.titleSize, null);
   }
	public void killMonster(int i) {
		gp.ghost[i]=null;
		
	}
	public void spawnMonster(int i) {
		gp.ghost[i] = new Ghost(gp,i+1);
		gp.ghost[i].x = gp.titleSize *9;
		gp.ghost[i].y = gp.titleSize *4;
	}

}
