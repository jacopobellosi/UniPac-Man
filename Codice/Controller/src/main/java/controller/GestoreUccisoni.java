package controller;

import view.DatiGhost;

public class GestoreUccisoni extends Thread{
	GameEngine gp;
	int index;
	
	public GestoreUccisoni(GameEngine gp,int index) {
		this.gp=gp;
		this.index=index;
	}
	
	public void run() {
		try {
			Thread.sleep(4000);
			boolean flag=false;
			boolean flag2=false;
			for(int i=0;i<gp.ghost.length && flag==false;i++) {
				if(gp.ghost[i] ==null) {
					gp.ghost[i] = new Ghost(gp,index);
					gp.ghost[i].x = gp.titleSize *(9+(i+1));
					gp.ghost[i].y = gp.titleSize *4;
					for(int j=0;j<gp.ghost.length && flag2==false;j++) {
						if(gp.dg[j] ==null) {
							gp.dg[j] = new DatiGhost(index);
							gp.dg[j].x = gp.ghost[i].x;
							gp.dg[j].y = gp.ghost[i].y;
							gp.dg[j].invincible = true;
						}
						flag2=true;
					}
					
					flag=true;
					gp.ghost[i].invincible = true;
					 
					gp.GRI = new GestoreRipristinoImmunita(gp,i);
					gp.GRI.start();

				}
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
