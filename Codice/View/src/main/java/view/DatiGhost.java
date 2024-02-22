package view;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DatiGhost {
		public int x=0;
		public int y=0;
		public Image imageGhost;
		public Boolean invincible = false;
		Image imageFantasma_vunerabile;
		int i;
	public DatiGhost(int i) {
		getImage(i);
		this.i=i;
		x=0;
		y=0;
		try {
			 imageFantasma_vunerabile = ImageIO.read(getClass().getResourceAsStream("/pacman/fanstasmi/fantasma_vulnerabile.gif"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	private void getImage(int immagine) {
		// TODO Auto-generated method stub
		if(immagine==1) {
			try {
				imageGhost = ImageIO.read(getClass().getResourceAsStream("/pacman/fanstasmi/ROSSO.gif"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(immagine==2) {
			try {
				imageGhost = ImageIO.read(getClass().getResourceAsStream("/pacman/fanstasmi/TURCHE.gif"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(immagine==3) {
			try {
				imageGhost = ImageIO.read(getClass().getResourceAsStream("/pacman/fanstasmi/SALMONE.gif"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(immagine==4) {
			try {
				imageGhost = ImageIO.read(getClass().getResourceAsStream("/pacman/fanstasmi/ROSA.gif"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public DatiGhost(int i,int x, int y, Image imageGhost, Boolean invincible) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y=y;
		this.imageGhost= imageGhost;
		try {
			 imageFantasma_vunerabile = ImageIO.read(getClass().getResourceAsStream("/pacman/fanstasmi/fantasma_vulnerabile.gif"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		this.invincible=invincible;
		getImage(i);
	}

}
