
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
public class UI {
	GameEngine gp;
	Font f_30;
	Font f_50;
	Font f_40;
	Font f_35;
	InputManager keyH;
	BufferedImage pacLife;
	//public boolean gameFinished=false;
	Graphics2D g2;
	public int commandNum=0;
	public int coommandNum;
	
	public UI(GameEngine gp) {
		this.gp = gp;
		f_30 = new Font("Gill Sans MT Condensed", Font.PLAIN,30);
		f_50 = new Font("Gill Sans MT Condensed", Font.BOLD,70);
		f_40 = new Font("Gill Sans MT Condensed", Font.PLAIN,40);
		f_35= new Font("Gill Sans MT Condensed", Font.BOLD,35);

		GameObject vita = new vitaPacMan(gp);
		pacLife = vita.imageVita;
	}
	public void drawContaPallini(Graphics2D g2) {
		this.g2=g2;
		drawPlayerLife();
		g2.setFont(f_30);
		g2.setColor(Color.white);
		g2.drawString("CFU = "+gp.player.hashKey, 200, 40);
	
	}
	private void drawPlayerLife() {
		// TODO Auto-generated method stub
		int x = gp.titleSize/2;
		int i=0;
		if(gp.player.countLife()==3) {
			while(i < 3) {
			g2.drawImage(pacLife,x,3,47,47,null);
			i++;
			x +=gp.titleSize;
			}
		}else if (gp.player.countLife()==2) {
			while(i < 2) {
			g2.drawImage(pacLife,x,3,47,47,null);
			i++;
			x +=gp.titleSize;
			}
		}else {
			g2.drawImage(pacLife,x,3,47,47,null);
			x +=gp.titleSize;

		}
		
		
	}
	
	public void draw(Graphics2D g2) {
		this.g2=g2;
		g2.setColor(new Color(20,20,60));
		g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
		if(gp.gameState==gp.titleState) {
			drawTitleScreen();
		}
		
		if(gp.gameState==gp.playState) {
			drawContaPallini(g2);
		}
		if(gp.gameState==gp.pauseState) {
			drawPauseScreen();
		}
		if(gp.gameState==gp.endState) {
			drawEndScreen();
		}
		
	}
	public void drawPauseScreen() {
		g2.setFont(f_50);
		String text="paused";
		g2.setColor(Color.white);
		int x=getXforCentered(text);
		int y=gp.screenHeight/2;
		g2.drawString(text, x, y);
	}
	public void drawTitleScreen() {
		
		g2.setColor(new Color(20,20,60));
		g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
		
		//logo
		g2.drawImage(gp.player.logo,150,0,450,450,null);
		
		//menu
		g2.setFont(f_40);
		g2.setColor(Color.white);
		String text="NUOVA PARTITA";
		int y=gp.screenHeight/2+(gp.titleSize*4);
		int x=getXforCentered(text);
		g2.drawString(text,x,y);
		if(commandNum==0) {
			g2.setFont(f_35);
			g2.drawString(">", x-gp.titleSize, y);
		}
		
		g2.setFont(f_40);
		text="ESCI";
		x=getXforCentered(text);
		y+=gp.titleSize;
		g2.drawString(text,x,y);
		if(commandNum==1) {
			g2.setFont(f_35);
			g2.drawString(">", x-gp.titleSize+5, y);
		}
	}
	public void drawEndScreen() {
		
		g2.setColor(new Color(20,20,60));//new Color(70,120,80) per scegliere una propria gradazione
		g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
		//title
		String text;
		int x;
		int y;
		if(gp.player.countLife()==0) {
			text= "Non hai studiato abbastanza";
			g2.setFont(f_40);
			g2.setColor(Color.white);
			x=getXforCentered(text);
			y=gp.screenHeight/2-(gp.titleSize*2);
			g2.drawString(text, x, y);
			
			text= "NON TI SEI LAUREATO!";
			g2.setFont(f_50);
			x=getXforCentered(text);
			y=gp.screenHeight/2;
			//shade
			g2.setColor(Color.red);
			g2.drawString(text, x+5, y+5);
			//main color
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
		}else {
			text= "Complimenti hai raccolto tutti i CFU";
			g2.setFont(f_40);
			g2.setColor(Color.white);
			x=getXforCentered(text);
			y=gp.screenHeight/2-(gp.titleSize*2);
			g2.drawString(text, x, y);
			
			
			text= "TI SEI LAUREATO!";
			g2.setFont(f_50);
			x=getXforCentered(text);
			y=gp.screenHeight/2;
			//shade
			g2.setColor(Color.red);
			g2.drawString(text, x+5, y+5);
			//main color
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
		}			
			
			text = "press SPACE to start";
			g2.setFont(f_30);
		    g2.setColor(Color.yellow);
			x=getXforCentered(text);
			y=gp.screenHeight/2+(gp.titleSize*3);
			g2.drawString(text, x, y);
		
	}
	
	private int getXforCentered(String text) {
		// TODO Auto-generated method stub
		int x;
		int lenght=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
		x=gp.screenWidth/2-lenght/2;
		
		return x;
	}

}
