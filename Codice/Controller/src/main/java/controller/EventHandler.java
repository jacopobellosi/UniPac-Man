package controller;
import java.awt.Rectangle;


public class EventHandler {

	private GameEngine gp;
	private Rectangle eventRect;
	 
	private int eventRectDefaultX,eventRectDefaultY;
	
	public EventHandler(GameEngine gp) { // NO_UCD (use default)
		this.gp=gp;
		eventRect=new Rectangle();
		eventRect.x=7;
		eventRect.y=2;
		eventRect.width=30;
		eventRect.height=35;
		eventRectDefaultX=eventRect.x;
		eventRectDefaultY=eventRect.y;	
	}
	
	  
	void checkEvent(Entity e) {
		if(hit(-1,6,e)==true) {
			tunnelSX(e);
		}
		if(hit(15.5,6,e)==true) {
			tunnelDX(e);
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

	

	private void tunnelSX(Entity e) {
	    e.x = gp.titleSize * 15;
	    e.y = gp.titleSize * 6;
	}
	private void tunnelDX(Entity e) {
		e.x=gp.titleSize*0;
		e.y=gp.titleSize*6;

	}
}
