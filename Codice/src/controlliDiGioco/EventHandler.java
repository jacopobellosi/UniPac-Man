package controlliDiGioco;
import java.awt.Rectangle;

import engineDelGioco.GameEngine;
import entita.Entity;

public class EventHandler {

	GameEngine gp;
	Rectangle eventRect;
	 
	int eventRectDefaultX,eventRectDefaultY;
	
	public EventHandler(GameEngine gp) {
		this.gp=gp;
		eventRect=new Rectangle();
		eventRect.x=7;
		eventRect.y=2;
		eventRect.width=30;
		eventRect.height=35;
		eventRectDefaultX=eventRect.x;
		eventRectDefaultY=eventRect.y;	
	}
	
	  
	public void checkEvent(Entity e) {
		

		if(hit(-1,6,e)==true) {
			System.out.println("Tunnel sinistra preso");
			tunnelsx(e);
		}
		if(hit(15.5,6,e)==true) {
			System.out.println("Tunnel destra preso");
			tunneldx(e);
		}
	}
	
	
	private boolean hit(double eventCol, int eventRow, Entity e) {

		boolean hit=false;
		e.solidArea.x=e.x+e.solidArea.x;
		e.solidArea.y=e.y+e.solidArea.y;
		eventRect.x=(int) (eventCol*gp.titleSize+eventRect.x);
		eventRect.y=eventRow*gp.titleSize+eventRect.y;

		if(e.solidArea.intersects(eventRect)) {
			hit=true;
		}
		
		e.solidArea.x=e.solidAreaDefaultx;
		e.solidArea.y=e.solidAreaDefaulty;
		eventRect.x=eventRectDefaultX;
		eventRect.y=eventRectDefaultY;

		return hit;
	}

	

	public void tunnelsx(Entity e) {
	    // Aggiorna la posizione del giocatore e del rettangolo solido
	    e.x = gp.titleSize * 15;
	    e.y = gp.titleSize * 6;
	}
	public void tunneldx(Entity e) {
		e.x=gp.titleSize*0;
		e.y=gp.titleSize*6;

	}
}
