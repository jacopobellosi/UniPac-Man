package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import model.Tilemanger;

public class GamePanel {
	public GamePanel() {
		
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
		//player.draw(g2);
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