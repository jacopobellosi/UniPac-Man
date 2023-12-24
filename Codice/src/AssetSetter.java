
public class AssetSetter {

	GameEngine gp;
	public AssetSetter(GameEngine gp) {
		this.gp=gp;
	}
	
	public void setObject() {
		gp.obj[0]=new ObjCFU(); //il numero è un indice per l'elemento
		gp.obj[0].x=3 * gp.titleSize; //riga della mappa
		gp.obj[0].y=5 * gp.titleSize; //colonna della mappa
/*
		gp.obj[1]=new ObjCFU();
		gp.obj[1].X=23*gp.titleSize;
		gp.obj[1].Y=40*gp.titleSize;
*/
	}
}
