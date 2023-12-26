
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
	Font c_30;
	Font a_20;
	InputManager keyH;
	BufferedImage pacLife;
	public boolean gameFinished=false;
	Graphics2D g2;
	public int commandNum=0;
	public int coommandNum;
	
	public UI(GameEngine gp) {
		this.gp = gp;
		f_30 = new Font("PacFont Good", Font.PLAIN,30);
		f_50 = new Font("PacFont Good", Font.BOLD,50);
		c_30 = new Font("namco regular", Font.PLAIN,20);
		a_20= new Font("Arial", Font.BOLD,20);

		GameObject vita = new vitaPacMan(gp);
		pacLife = vita.imageVita;
	}
	public void drawContaPallini(Graphics2D g2) {
		this.g2=g2;
		drawPlayerLife();
		if(gameFinished==true) {
			String text;
			int textLength;
			int x;
			int y;
			
			text= "Complimenti hai raccolto tutti i CFU";
			g2.setFont(f_30);
			g2.setColor(Color.white);
			textLength=(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x=gp.screenWidth/2-textLength/2;
			y=gp.screenHeight/2-(gp.titleSize*2);
			g2.drawString(text, x, y);
			
			
			text= "TI SEI LAUREATO!";
			g2.setFont(f_50);
			g2.setColor(Color.white);
			textLength=(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x=gp.screenWidth/2-textLength/2;
			y=gp.screenHeight/2;//-(gp.titleSize*4);
			g2.drawString(text, x, y);
					
			
			text = "press SPACE to start";
			g2.setFont(f_30);
		    g2.setColor(Color.yellow);
			textLength=(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		    x=gp.screenWidth/2-textLength/2;
			y=gp.screenHeight/2+(gp.titleSize*3);
			g2.drawString(text, x, y);

			gp.gameThread=null;

			
		}else {
			g2.setFont(f_30);
			g2.setColor(Color.white);
			g2.drawString("cfu - ", 200, 50);
		
			g2.setFont(c_30);
			g2.setColor(Color.white);
			g2.drawString(""+gp.player.hashKey, 300, 45);
		}
		
	}
	private void drawPlayerLife() {
		// TODO Auto-generated method stub
		int x = gp.titleSize/2;
		int y = gp.titleSize/2;
		int i=0;
		while(i < gp.player.maxLife) {
			g2.drawImage(pacLife,x,y,gp.titleSize, gp.titleSize,null);
			i++;
			x +=gp.titleSize;
		}
	}
	
	public void draw(Graphics2D g2) {
		this.g2=g2;
		//g2.setFont(c_30);
		g2.setColor(Color.white);
		
		if(gp.gameState==gp.titleState) {
			drawTitleScreen();
		}
		
		if(gp.gameState==gp.playState) {
			
		}
		if(gp.gameState==gp.pauseState) {
			drawPauseScreen();
		}
	}
	
	public void drawTitleScreen() {
		
		g2.setColor(Color.black);//new Color(70,120,80) per scegliere una propria gradazione
		g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
		//title
		g2.setFont(f_50);
		String text= "UNI PAC-MAN";
		int x=getXforCentered(text);
		int y=gp.screenHeight/2-(gp.titleSize*3);
		
		//shadow
		g2.setColor(Color.blue);
		g2.drawString(text, x+5, y+5);
		//main color
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		
		//logo
		x=gp.screenWidth/2-(gp.titleSize*2)/2;
		y+=gp.titleSize*2;
		g2.drawImage(gp.player.logo,x,y,100,100,null);
		
		//menu
		g2.setFont(c_30);
		text=" nuova partita";
		x=getXforCentered(text);
		y+=gp.titleSize*4;
		g2.drawString(text,x,y);
		if(commandNum==0) {
			g2.setFont(a_20);
			g2.drawString(">", x-gp.titleSize, y);
		}
		g2.setFont(c_30);
		text=" esci";
		x=getXforCentered(text);
		y+=gp.titleSize;
		g2.drawString(text,x,y);
		if(commandNum==1) {
			g2.setFont(a_20);
			g2.drawString(">", x-gp.titleSize+5, y);
		}
	}
	
	private int getXforCentered(String text) {
		// TODO Auto-generated method stub
		int x;
		int lenght=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
		x=gp.screenWidth/2-lenght/2;
		
		return x;
	}
	public void drawPauseScreen() {
		g2.setFont(f_30);
		String text="PAUSED";
		int x=getXforCentered(text);
		int y=gp.screenHeight/2;
		g2.drawString(text, x, y);
	}
}
