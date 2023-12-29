
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
			gp.spawnMonster(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
