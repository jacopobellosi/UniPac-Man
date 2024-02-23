package model;

import java.io.*;
import javax.imageio.ImageIO;


public class Tilemanger {
	public Obstacole[] tile;
	
	public int maxScreenCol;
	public int maxScreenRow;

	public Tilemanger(String map, int maxScreenCol, int maxScreenRow) {
		tile= new Obstacole[25];
		this.maxScreenCol = maxScreenCol;
		this.maxScreenRow = maxScreenRow;
		
		getTileImage();
	}
	
	private void getTileImage() {
		
		try {
			tile[0] = new Obstacole();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/pacman/tile/sfondo.jpg"));
			
			tile[1] = new Obstacole();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/pacman/border/innerborder_verticale.png"));
			tile[1].collision = true;
			
			tile[2] = new Obstacole();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/pacman/border/innerborder_orizzontale.png"));
			tile[2].collision = true;
			
			tile[3]=new Obstacole();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/pacman/border/innerborder_angolo_adx.png"));
			tile[3].collision = true;
			
			tile[4]=new Obstacole();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/pacman/border/innerborder_angolo_asx.png"));
			tile[4].collision = true;
			
			tile[5]=new Obstacole();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/pacman/border/innerborder_angolo_bsx.png"));
			tile[5].collision = true;
			
			tile[6]=new Obstacole();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/pacman/border/innerborder_angolo_bdx.png"));
			tile[6].collision = true;
			
			tile[7]=new Obstacole();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/pacman/border/chiuso.png"));
			tile[7].collision = true;
			
			tile[8]=new Obstacole();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/pacman/border/chiuso_giu.png"));
			tile[8].collision = true;
			
			tile[9]=new Obstacole();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/pacman/border/chiuso_su.png"));
			tile[9].collision = true;
			
			tile[10]=new Obstacole();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/pacman/border/chiuso_dx.png"));
			tile[10].collision = true;
			
			tile[11]=new Obstacole();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/pacman/border/chiuso_sx.png"));
			tile[11].collision = true;
			
			tile[15] = new Obstacole();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/pacman/tile/sfondo.jpg"));
			
			tile[20] = new Obstacole();
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/pacman/tile/sfondo.jpg"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
