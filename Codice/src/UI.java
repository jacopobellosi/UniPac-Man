
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
public class UI {
	GameEngine gp;
	Font f_30;
	Font f_50;
	Font c_30;

	public boolean gameFinished=false;
	
	public UI(GameEngine gp) {
		this.gp = gp;
		f_30 = new Font("PacFont Good", Font.PLAIN,30);
		f_50 = new Font("PacFont Good", Font.BOLD,50);
		
		c_30 = new Font("calibri", Font.PLAIN,30);


	}
	public void drawContaPallini(Graphics2D g2) {
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
			g2.drawString("Pallini = ", 25, 50);
		
			g2.setFont(c_30);
			g2.setColor(Color.white);
			g2.drawString(""+gp.player.hashKey, 200, 49);
		}
		
	}
}
