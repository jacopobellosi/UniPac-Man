
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
public class UI {
	GameEngine gp;
	Font arial_40;
	public UI(GameEngine gp) {
		this.gp = gp;
		arial_40 = new Font("arial", Font.PLAIN,40);
	}
	public void drawContaPallini(Graphics2D g2) {
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		g2.drawString("Pallini = "+gp.player.hashKey, 25, 50);
	}
}
