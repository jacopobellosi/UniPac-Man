package engineDelGioco;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import funzionalita.Obstacole;

public class Tilemanger {
	private GameEngine gp;
	public Obstacole[] tile;
	
	public int mapTilenum[][];
	private static int conteggio;
	Tilemanger(GameEngine gp,String map) {
		this.gp = gp;
		tile= new Obstacole[25];
		mapTilenum = new int[gp.maxScreenCol][gp.maxScreenRow];
		getTileImage();
		conteggio=0;
		loadMap(map);
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
	private void loadMap(String S) {
		try {
			InputStream is = getClass().getResourceAsStream(S);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			int col =0;
			int row=0;
			while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
				
					String line = br.readLine();
					while(col < gp.maxScreenCol) {
						
						String numbers[] = line.split(" ");
						int num = Integer.parseInt(numbers[col]);
						mapTilenum[col][row] = num;
						if(mapTilenum[col][row]==0) {
							//g2.drawImage(imagecfu, x, y, gp.titleSize, gp.titleSize, null);
							conteggio++;
						}
						if(mapTilenum[col][row]==15) {
							//g2.drawImage(imagecfu, x, y, gp.titleSize, gp.titleSize, null);
							conteggio++;
						}
						col++;
					}
					if(col == gp.maxScreenCol) {
						col =0;
						row++;
					}
				
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static void resetPalliniTotali() {
		conteggio=0;
	}
	public static int getPalliniTotali() {
		
		return conteggio;
	}
	void draw(Graphics g2) {

		int col = 0;
		int row = 0;
		int x =0;
		int y=0;

		
		while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
			int tileNum = mapTilenum[col][row];
			g2.drawImage(tile[tileNum].image, x, y, gp.titleSize, gp.titleSize, null);
			
			
			
			col++;
			x +=gp.titleSize;
			
			if(col==gp.maxScreenCol){
				col =0;
				x=0;
				row++;
				y +=gp.titleSize;
				
			}
		}
		
	}

	public int getMap(int row, int col) {
		// TODO Auto-generated method stub
		
		return mapTilenum[col][row];
	}
	
}
