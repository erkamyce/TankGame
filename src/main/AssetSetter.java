package main;

import enemy.ENM_Tiger;
import object.OBJ_Book;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Oil;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter (GamePanel gp) {
		
		this.gp = gp;
		
	}
	
	public void setObject () {
		
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 26 * gp.tileSize;
		gp.obj[0].worldY = 7 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldX = 28 * gp.tileSize;
		gp.obj[1].worldY = 7 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Key();
		gp.obj[2].worldX = 27 * gp.tileSize;
		gp.obj[2].worldY = 7 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Door();
		gp.obj[3].worldX = 12 * gp.tileSize;
		gp.obj[3].worldY = 1 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Door();
		gp.obj[4].worldX = 12 * gp.tileSize;
		gp.obj[4].worldY = 2 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Door();
		gp.obj[5].worldX = 12 * gp.tileSize;
		gp.obj[5].worldY = 3 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Book();
		gp.obj[6].worldX = 12 * gp.tileSize;
		gp.obj[6].worldY = 0 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Oil();
		gp.obj[7].worldX = 12 * gp.tileSize;
		gp.obj[7].worldY = 6 * gp.tileSize;
		
	}	
	
	public void setEnemy() {
		
		gp.enemy[0] = new ENM_Tiger(gp);
		gp.enemy[0].worldX = 13 * gp.tileSize; 
		gp.enemy[0].worldY = 7 * gp.tileSize; 
		
		gp.enemy[1] = new ENM_Tiger(gp);
		gp.enemy[1].worldX = 14 * gp.tileSize; 
		gp.enemy[1].worldY = 7 * gp.tileSize; 
		
		gp.enemy[2] = new ENM_Tiger(gp);
		gp.enemy[2].worldX = 15 * gp.tileSize; 
		gp.enemy[2].worldY = 7 * gp.tileSize; 
		
		gp.enemy[3] = new ENM_Tiger(gp);
		gp.enemy[3].worldX = 16 * gp.tileSize; 
		gp.enemy[3].worldY = 7 * gp.tileSize; 
		
		gp.enemy[4] = new ENM_Tiger(gp);
		gp.enemy[4].worldX = 17 * gp.tileSize; 
		gp.enemy[4].worldY = 7 * gp.tileSize; 
		
		gp.enemy[5] = new ENM_Tiger(gp);
		gp.enemy[5].worldX = 18 * gp.tileSize; 
		gp.enemy[5].worldY = 7 * gp.tileSize; 
		
		gp.enemy[6] = new ENM_Tiger(gp);
		gp.enemy[6].worldX = 19 * gp.tileSize; 
		gp.enemy[6].worldY = 7 * gp.tileSize; 
		
		
		
	}
}
