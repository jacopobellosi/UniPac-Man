
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
public class UI {
	GameEngine gp;
	Font arial_40;
	Font arial_80B;

	public boolean gameFinished=false;
	
	public UI(GameEngine gp) {
		this.gp = gp;
		arial_40 = new Font("arial", Font.PLAIN,40);
		arial_80B = new Font("arial", Font.BOLD,40);

	}
	public void drawContaPallini(Graphics2D g2) {
		if(gameFinished==true) {
			g2.setFont(arial_40);
			g2.setColor(Color.white);

			String text;
			int textLength;
			int x;
			int y;
			
			text= "Complimenti hai raccolto tutti i CFU";
			textLength=(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			
			x=gp.screenWidth/2-textLength/2;
			y=gp.screenHeight/2-(gp.titleSize*3);
			g2.drawString(text, x, y);
			
			g2.setFont(arial_80B);
			g2.setColor(Color.white);
			
			text= "TI SEI LAUREATO!";
			textLength=(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			
			x=gp.screenWidth/2-textLength/2;
			y=gp.screenHeight/2+(gp.titleSize*2);
			g2.drawString(text, x, y);
			
			gp.gameThread=null;

		}else {
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			g2.drawString("Pallini = "+gp.player.hashKey, 25, 50);
		
		}
		
	}
}
