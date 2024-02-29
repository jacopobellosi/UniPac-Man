package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import model.Tilemanger;

public class GamePanel {
	Image up1, up2, down1, down2, left, right;
	public GamePanel() {
		
		getPlayerImage();
	}
	public void paintComponent(Graphics2D g2,GameObject obj[],int titleSize,GameObject pw[],boolean attacking,Tilemanger tileM,int mapTilenum[][], DatiGhost ghost[]){
		printMappa(g2,titleSize,tileM,mapTilenum);
		for(int i=0;i< obj.length;i++)		{
			if(obj[i]!=null) {
				obj[i].drawCFU(g2,titleSize);
			}
		}
		
		for(int i=0;i< pw.length;i++){
			if(pw[i]!=null) {
				pw[i].drawPW(g2,titleSize);
			}
		}

		if(attacking==true) {
			for(int i=0;i<ghost.length;i++) {
				if(ghost[i]!=null && ghost[i].invincible==false) {
					g2.drawImage(ghost[i].imageFantasma_vunerabile, ghost[i].x, ghost[i].y, titleSize, titleSize, null);
				}
			}
			for(int i=0;i<ghost.length;i++) {
				if(ghost[i]!=null && ghost[i].invincible==true) {
					g2.drawImage(ghost[i].imageGhost, ghost[i].x, ghost[i].y, titleSize, titleSize, null);
				}
			}
		}else {
			for(int i=0;i<ghost.length;i++) {
				if(ghost[i]!=null) {
					
					g2.drawImage(ghost[i].imageGhost, ghost[i].x, ghost[i].y, titleSize, titleSize, null);
				}
			}
		}
	}
	private void getPlayerImage()  {
		
    	up1 =   new ImageIcon(getClass().getResource("/pacman/su_dx.gif")).getImage();
		up2 =   new ImageIcon(getClass().getResource("/pacman/su_sx.gif")).getImage();
		down1 = new ImageIcon(getClass().getResource("/pacman/giu_dx.gif")).getImage();
		down2 = new ImageIcon(getClass().getResource("/pacman/giu_sx.gif")).getImage();
		right =  new ImageIcon(getClass().getResource("/pacman/destra.gif")).getImage();
		left =  new ImageIcon(getClass().getResource("/pacman/sinistra.gif")).getImage();

    }
	public void drawPlayer(Graphics2D g2,String direction,int x,int y,int titleSize) {

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
		g2.drawImage(image, x, y, titleSize, titleSize, null);
		
    }
	private void printMappa(Graphics g2, int titleSize, Tilemanger tileM, int mapTilenum[][]) {
		int col = 0;
		int row = 0;
		int x =0;
		int y=0;
		
		while(col < tileM.maxScreenCol && row < tileM.maxScreenRow) {
			int tileNum = mapTilenum[col][row];
			g2.drawImage(tileM.tile[tileNum].image, x, y, titleSize, titleSize, null);	
			
			col++;
			x +=titleSize;
			
			if(col==tileM.maxScreenCol){
				col =0;
				x=0;
				row++;
				y +=titleSize;
				
			}
		}
	}
}