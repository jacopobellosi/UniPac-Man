package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class UI {
	GamePanel gp;
	private Font f_30;
	private Font f_70;
	private Font f_60;
	private Font f_40;
	private Font f_35;
	private BufferedImage pacLife;
	private Graphics2D g2;
	public  int commandNum=0;
	public int coommandNum;
	
	private Timer blinkTimer;
	private boolean textVisible = true;
	
	//
	public final int titleState=0;
	public final int playState=1;
	public final int pauseState=2;
	public final int endState=3;
	public int nextLevelState=4;
	public Image logo;
	//
	public UI(GamePanel gp) {
		this.gp = gp;
		f_30 = new Font("Gill Sans MT Condensed", Font.PLAIN,30);
		f_70 = new Font("Gill Sans MT Condensed", Font.BOLD,70);
		f_40 = new Font("Gill Sans MT Condensed", Font.PLAIN,40);
		f_35= new Font("Gill Sans MT Condensed", Font.BOLD,35);
		f_60 = new Font("Gill Sans MT Condensed", Font.BOLD,50);

		blinkTimer = new Timer(600, (ActionListener) new ActionListener() {		        
		@Override
		 public void actionPerformed(ActionEvent e) {
	            textVisible = !textVisible;
	            //gp.repaint();  // Ridisegna il componente quando cambia la visibilit� del testo
	        }			
		  });
		
		blinkTimer.start();
		GameObject vita = new VitaPacMan();
		pacLife = vita.imageVita;
	}
	
	public void drawContaPallini(Graphics2D g2,int punteggio,int titleSize,int numVite) {
		this.g2=g2;
		drawPlayerLife(titleSize,numVite);
		g2.setFont(f_30);
		g2.setColor(Color.white);
		g2.drawString("CFU = "+punteggio, 200, 40);
	}
	
	private void drawPlayerLife(int titleSize, int numVite) {
		// TODO Auto-generated method stub
		int x = titleSize/2;
		int i=0;
		if(numVite==3) {
			while(i < 3) {
			g2.drawImage(pacLife,x,3,47,47,null);
			i++;
			x +=titleSize;
			}
		}else if (numVite==2) {
			while(i < 2) {
			g2.drawImage(pacLife,x,3,47,47,null);
			i++;
			x +=titleSize;
			}
		}else {
			g2.drawImage(pacLife,x,3,47,47,null);
			x +=titleSize;

		}
		
		
	}
	public Image getImage() {
		return logo =  new ImageIcon(getClass().getResource("/pacman/logo.jpeg")).getImage();
	}
		
	public void draw(Graphics2D g2,int screenWidth, int screenHeight,int gameState,int punteggio,int titleSize,int numVite,int livelloCorrente) {
		this.g2=g2;
		g2.setColor(new Color(20,20,60));
		g2.fillRect(0,0,screenWidth,screenHeight);
		if(gameState==titleState) {
			drawTitleScreen(screenWidth,screenHeight,titleSize);
			
		}

		if(gameState==playState) {
			drawContaPallini(g2,punteggio,titleSize,numVite);
		}
		if(gameState==nextLevelState) {
			if(livelloCorrente==1)
				drawFirstLevelScreen(screenWidth,screenHeight,titleSize);
			else
				drawSecondLevelScreen(screenWidth,screenHeight,titleSize);
		}
		if(gameState==pauseState) {
			drawPauseScreen(screenHeight,screenWidth);
		}
		if(gameState==endState) {
			drawEndScreen(screenWidth,screenHeight,titleSize,numVite);
		}
		
	}
	private void drawPauseScreen(int screenHeight, int screenWidth ) {
		g2.setFont(f_70);
		String text="paused";
		g2.setColor(Color.white);
		int x=getXforCentered(text,screenWidth);
		int y=screenHeight/2;
		g2.drawString(text, x, y);
	}
	
	private void drawTitleScreen(int screenWidth,int screenHeight, int titleSize) {
		
		g2.setColor(new Color(20,20,60));
		g2.fillRect(0,0,screenWidth,screenHeight);
		
		//logo
		g2.drawImage(getImage(),150,0,450,450,null);
		
		//menu
		g2.setFont(f_40);
		g2.setColor(Color.white);
		String text="NUOVA PARTITA";
		int y=screenHeight/2+(titleSize*4);
		int x=getXforCentered(text,screenWidth);
		g2.drawString(text,x,y);
		if(commandNum==0) {
			g2.setFont(f_35);
			g2.drawString(">", x-titleSize, y);
		}
		
		g2.setFont(f_40);
		text="ESCI";
		x=getXforCentered(text,screenWidth);
		y+=titleSize;
		g2.drawString(text,x,y);
		if(commandNum==1) {
			g2.setFont(f_35);
			g2.drawString(">", x-titleSize+5, y);
		}
		text = "premi ENTER per iniziare";
		g2.setFont(f_30);
		 if (textVisible) {
		     g2.setColor(Color.yellow);
		     x = getXforCentered(text,screenWidth);
		     y = screenHeight / 2 + (titleSize * 6);
		     g2.drawString(text, x, y);
		}
		
	}
	private void drawFirstLevelScreen(int screenWidth,int screenHeight, int titleSize ) {
		g2.setColor(new Color(20,20,60));//new Color(70,120,80) per scegliere una propria gradazione
		g2.fillRect(0,0,screenWidth,screenHeight);
		//title
		String text;
		int x;
		int y;

		text= "Hai raccolto tutti i CFU";
		g2.setFont(f_40);
		g2.setColor(Color.white);
		x=getXforCentered(text,screenWidth);
		y=screenHeight/2-(titleSize*2);
		g2.drawString(text, x, y);
		
		
		text= "HAI SUPERATO IL PRIMO ANNO!";
		g2.setFont(f_60);
		x=getXforCentered(text,screenWidth);
		y=screenHeight/2;
		//shade
		g2.setColor(Color.green);
		g2.drawString(text, x+3, y+3);
		//main color
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		text = "premi SPACE per andare al livello successivo";
		g2.setFont(f_30);
	    g2.setColor(Color.yellow);
		x=getXforCentered(text,screenWidth);
		y=screenHeight/2+(titleSize*3);
		g2.drawString(text, x, y);
	}
	private void drawSecondLevelScreen(int screenWidth,int screenHeight, int titleSize) {
		g2.setColor(new Color(20,20,60));//new Color(70,120,80) per scegliere una propria gradazione
		g2.fillRect(0,0,screenWidth,screenHeight);
		//title
		String text;
		int x;
		int y;

		text= "Hai raccolto tutti i CFU";
		g2.setFont(f_40);
		g2.setColor(Color.white);
		x=getXforCentered(text,screenWidth);
		y=screenHeight/2-(titleSize*2);
		g2.drawString(text, x, y);
		
		
		text= "HAI SUPERATO IL SECONDO ANNO!";
		g2.setFont(f_60);
		x=getXforCentered(text,screenWidth);
		y=screenHeight/2;
		//shade
		g2.setColor(Color.green);
		g2.drawString(text, x+3, y+3);
		//main color
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		text = "premi SPACE per andare al livello successivo";
		g2.setFont(f_30);
	    g2.setColor(Color.yellow);
		x=getXforCentered(text,screenWidth);
		y=screenHeight/2+(titleSize*3);
		g2.drawString(text, x, y);
	}
	private void drawEndScreen(int screenWidth,int screenHeight, int titleSize, int numVite) {
		
		g2.setColor(new Color(20,20,60));//new Color(70,120,80) per scegliere una propria gradazione
		g2.fillRect(0,0,screenWidth,screenHeight);
		//title
		String text;
		int x;
		int y;
		if(numVite==0) {
			text= "Non hai studiato abbastanza";
			g2.setFont(f_40);
			g2.setColor(Color.white);
			x=getXforCentered(text,screenWidth);
			y=screenHeight/2-(titleSize*2);
			g2.drawString(text, x, y);
			
			text= "NON TI SEI LAUREATO!";
			g2.setFont(f_60);
			x=getXforCentered(text,screenWidth);
			y=screenHeight/2;
			//shade
			g2.setColor(Color.red);
			g2.drawString(text, x+3, y+3);
			//main color
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
		}else {
			text= "Complimenti hai raccolto tutti i CFU";
			g2.setFont(f_40);
			g2.setColor(Color.white);
			x=getXforCentered(text,screenWidth);
			y=screenHeight/2-(titleSize*2);
			g2.drawString(text, x, y);
			
			text= "TI SEI LAUREATO!";
			g2.setFont(f_60);
			x=getXforCentered(text,screenWidth);
			y=screenHeight/2;
			//shade
			g2.setColor(Color.green);
			g2.drawString(text, x+3, y+3);
			//main color
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
		}			
			
			text = "Premi SPACE per tornare alla schermata iniziale";
			g2.setFont(f_30);
		    g2.setColor(Color.yellow);
			x=getXforCentered(text,screenWidth);
			y=screenHeight/2+(titleSize*3);
			g2.drawString(text, x, y);
	}
	private int getXforCentered(String text, int screenWidth) {
		// TODO Auto-generated method stub
		int x;
		int lenght=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
		x=screenWidth/2-lenght/2;
		
		return x;
	}
}
