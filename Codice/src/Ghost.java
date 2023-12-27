/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/


import java.util.*;

import javax.imageio.ImageIO;

import java.io.IOException;

//fantasmini
public class Ghost extends Entity {
		GameEngine gp;
		static  Player targetPlayer;
		public Ghost(GameEngine gp, int i) {
			super(gp);
			//
			name="fanstasma";
			direction="down";
			speed=1;
			type=i;
			solidArea.x=3;
			solidArea.y=7;
			solidArea.height=42;
			solidArea.width=30;
			solidAreaDefaultx = solidArea.x;
			solidAreaDefaulty = solidArea.y;
			
			getImage(i);
			fantasmaVulnerabile();
		}
		public static void setTarget(Player pacman) {
			targetPlayer = pacman;
		}
		public void getImage(int immagine) {
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
		public void fantasmaVulnerabile() {
			try {
				imageFantasma_vunerabile = ImageIO.read(getClass().getResourceAsStream("/pacman/fanstasmi/fantasma_vulerabile.gif"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		public int getType() {
			return type;
		}
		public void setAction() {
			actionlockCounter++;
			if (actionlockCounter == 150) {
			     Random random = new Random();
			     int i = ((Random) random).nextInt(100)+1;
			     
			     if(i <= 25){
			        direction = "up";
			     }
			     if (i > 25 && i <= 50) {
			         direction = "down";
			     }
			     if (i > 50 && i <= 75) {
			        direction ="left";
			     }
			     if (i > 75 && i <= 100) {
			         direction = "right";
			     }
			     actionlockCounter = 0;

			 }
			
			/*
			 if (x < targetPlayer.x) {
				 direction = "left";
		     } else if (x > targetPlayer.x) {
		        	direction ="right";
		     }

		        // Muovi il fantasma verso il giocatore lungo l'asse y
		     if (y < targetPlayer.y) {
		        	direction = "down";
		     } else if (y > targetPlayer.y) {
		        	 direction = "up";
		     }
		     */
		}
}