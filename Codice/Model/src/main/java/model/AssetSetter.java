package model;


public class AssetSetter {

	public int mappaSpawnFantasmi [][] = { 
            { 9, 4, }, 
            { 10, 4,  }, 
            { 11, 4,  },
            { 12, 4,  } 
        }; 
	public AssetSetter() {
	
	}
	public int spawnPointGhost(int i,int j) {
		return mappaSpawnFantasmi[i][j];
	}
	
}
	