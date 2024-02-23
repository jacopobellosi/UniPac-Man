package controller;

public class GestoreRipristinoImmunita extends Thread{
	GameEngine gp;
	int i;
	public GestoreRipristinoImmunita(GameEngine gp, int index) {
		this.gp=gp;
		this.i = index;
	}
	public void run() {
		try {
			Thread.sleep(3000);
			gp.ghost[i].invincible = false;
			
			 
			 for(int j=0;j<gp.dg.length;j++) {
					if(gp.dg[j]!=null) {
						if(gp.dg[j].i==gp.ghost[i].type) {
							gp.dg[j].invincible = false;
						}
					}
				}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
