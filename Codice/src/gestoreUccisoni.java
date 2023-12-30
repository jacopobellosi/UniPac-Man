
public class gestoreUccisoni extends Thread{
	GameEngine gp;
	int i;
	public gestoreUccisoni(GameEngine gp,int i) {
		this.gp=gp;
		this.i=i;
	}
	public void run() {
		try {
			Thread.sleep(4000);
			System.out.println("Fantasmino "+i+" dato ordine di respawn");
			boolean flag=false;
			//gp.spawnMonster(i);
			for(int i=0;i<gp.ghost.length && flag==false;i++) {
				if(gp.ghost[i] ==null) {
					gp.ghost[i] = new Ghost(gp,i);
					gp.ghost[i].x = gp.titleSize *(7+(i));
					gp.ghost[i].y = gp.titleSize *4;
					System.out.println("Fantasmino "+i+" eseguito il respawn");
					gp.ghost[i].invincible = true;
					gp.GRI = new gestoreRipristinoImmunita(gp,i);
					gp.GRI.start();
					//int ultimoFantasmaEliminato = numeroFantasmiEliminati.remove(0);

				}
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
