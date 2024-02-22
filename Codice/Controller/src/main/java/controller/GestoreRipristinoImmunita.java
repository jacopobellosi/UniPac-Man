package controller;

import view.GameEngine;

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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
