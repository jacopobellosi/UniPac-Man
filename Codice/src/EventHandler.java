import java.awt.Rectangle;

public class EventHandler {

	GameEngine gp;
	Rectangle eventRect;
	 
	int eventRectDefaultX,eventRectDefaultY;
	
	public EventHandler(GameEngine gp) {
		this.gp=gp;
		eventRect=new Rectangle();
		eventRect.x=7;
		eventRect.y=2;
		eventRect.width=16;
		eventRect.height=16;
		eventRectDefaultX=eventRect.x;
		eventRectDefaultY=eventRect.y;	
	}
	
	  
	public void checkEvent() {
		
		if(hit(-1,6)==true) {
			tunnelsx();
		}
		if(hit(15.5,6)==true) {
			tunneldx();
		}
	}
	
	
	private boolean hit(double eventCol, int eventRow) {

		boolean hit=false;
		gp.player.solidArea.x=gp.player.x+gp.player.solidArea.x;
		gp.player.solidArea.y=gp.player.y+gp.player.solidArea.y;
		eventRect.x=(int) (eventCol*gp.titleSize+eventRect.x);
		eventRect.y=eventRow*gp.titleSize+eventRect.y;

		if(gp.player.solidArea.intersects(eventRect)) {
			hit=true;
		}
		
		gp.player.solidArea.x=gp.player.solidAreaDefaultx;
		gp.player.solidArea.y=gp.player.solidAreaDefaulty;
		eventRect.x=eventRectDefaultX;
		eventRect.y=eventRectDefaultY;

		return hit;
	}

	

	public void tunnelsx() {
	    // Aggiorna la posizione del giocatore e del rettangolo solido
	    gp.player.x = gp.titleSize * 15;
	    gp.player.y = gp.titleSize * 6;
	}
	public void tunneldx() {
		gp.player.x=gp.titleSize*0;
		gp.player.y=gp.titleSize*6;

	}
}
