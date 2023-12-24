
public class CollisionChecker {
	GameEngine gp;
	public CollisionChecker(GameEngine gp) {
		this.gp = gp;
		
	}
	public void checktile(GameObject entity) {
		int entityLeftWorldX = entity.x + entity.solidArea.x;
		int entityRightWorldX = entity.x + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.y + entity.solidArea.y;
		int entityBottomWorldX = entity.y + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityRightWorldX/gp.titleSize;
		int entityRightCol = entityLeftWorldX/gp.titleSize;
		int entityTopRow = entityTopWorldY/gp.titleSize;
		int entityBottomRow = entityBottomWorldX/gp.titleSize;
		
		int tileNum1,tileNum2;
		
		switch(entity.direction) {
		case"up":
			entityTopRow = (entityTopWorldY - entity.speed)/gp.titleSize;
			tileNum1 = gp.tileM.mapTilenum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTilenum[entityRightCol][entityTopRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionON = true;
			}
			break;
		case"down":
			entityBottomRow = (entityBottomWorldX + entity.speed)/gp.titleSize;
			tileNum1 = gp.tileM.mapTilenum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTilenum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionON = true;
			}
			break;
		case"left":
			entityLeftCol = (entityLeftWorldX - entity.speed)/gp.titleSize;
			tileNum1 = gp.tileM.mapTilenum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTilenum[entityLeftCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionON = true;
			}
			break;
		case"right":
			entityRightCol = (entityRightWorldX + entity.speed)/gp.titleSize;
			tileNum1 = gp.tileM.mapTilenum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTilenum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionON = true;
			}
			break;
		}
	}
}
