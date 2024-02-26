package controller;

import model.AssetSetter;
import view.DatiGhost;

public class GestoreUccisoni extends Thread{
	public GameEngine gp;
	public int tipologia;
	private AssetSetter aSetter=new AssetSetter();
	public GestoreUccisoni(GameEngine gp,int index) {
		this.gp=gp;
		this.tipologia=index;
	}

	public void run() {
		try {
			Thread.sleep(4000);
			boolean flag=false;
			boolean flag2=false;
			for(int i=0;i<gp.ghost.length && flag==false;i++) {
				if(gp.ghost[i] ==null) {
					gp.ghost[i] = new Ghost(gp,tipologia);
					gp.ghost[i].x = gp.titleSize * aSetter.spawnPointGhost(tipologia-1, 0);
					gp.ghost[i].y = gp.titleSize * aSetter.spawnPointGhost(0, 1);
					for(int j=0;j<gp.dg.length && flag2==false;j++) {
						if(gp.dg[j] ==null) {
							gp.dg[j] = new DatiGhost(tipologia);
							gp.dg[j].x = gp.ghost[i].x;
							gp.dg[j].y = gp.ghost[i].y;
							gp.dg[j].invincible = true;
							//System.out.println("Nuovo fantasma respawnato tipo="+gp.dg[j].i+" "+gp.ghost[i].type);
							flag2=true;
							flag=true;
							gp.ghost[i].invincible = true;

							gp.GRI = new GestoreRipristinoImmunita(gp,i);
							gp.GRI.start();
							//System.out.println("Nuovo fantasma respawnato tipo="+gp.ghost[i].type);
						}

					}


				}

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
