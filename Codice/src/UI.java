
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
public class UI {
	GameEngine gp;
	Font f_30;
	Font f_50;
	Font c_30;

	BufferedImage pacLife;
	public boolean gameFinished=false;
	Graphics2D g2;
	
	public UI(GameEngine gp) {
		this.gp = gp;
		f_30 = new Font("PacFont Good", Font.PLAIN,30);
		f_50 = new Font("PacFont Good", Font.BOLD,50);
		
		c_30 = new Font("namco regular", Font.PLAIN,25);


		GameObject vita = new vitaPacMan(gp);
		pacLife = vita.imageVita;
	}
	public void drawContaPallini(Graphics2D g2) {
		this.g2=g2;
		drawPlayerLife();
		if(gameFinished==true) {
			g2.setFont(f_30);
			g2.setColor(Color.white);

			String text;
			int textLength;
			int x;
			int y;
			
			text= "Complimenti hai raccolto tutti i CFU";
			textLength=(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			
			x=gp.screenWidth/2-textLength/2;
			y=gp.screenHeight/2-(gp.titleSize*2);
			g2.drawString(text, x, y);
			
			g2.setFont(f_50);
			g2.setColor(Color.white);
			
			text= "TI SEI LAUREATO!";
			textLength=(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			
			x=gp.screenWidth/2-textLength/2;
			y=gp.screenHeight/2;//-(gp.titleSize*4);
			g2.drawString(text, x, y);
			
			gp.gameThread=null;

		}else {
			g2.setFont(f_30);
			g2.setColor(Color.white);
			g2.drawString("Pallini - ", 25, 50);
		
			g2.setFont(c_30);
			g2.setColor(Color.white);
			g2.drawString(""+gp.player.hashKey, 200, 45);
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
}
