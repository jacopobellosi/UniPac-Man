
public class AssetSetter {

	GameEngine gp;
	public AssetSetter(GameEngine gp) {
		this.gp=gp;
	}
	
	public void setObject() {
		gp.obj[0]=new ObjCFU();
		gp.obj[0].worldX=23*gp.titleSize;
		gp.obj[0].worldY=23*gp.titleSize;

		gp.obj[1]=new ObjCFU();
		gp.obj[0].worldX=23*gp.titleSize;
		gp.obj[0].worldY=40*gp.titleSize;

	}
}
