package enemy;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class ENM_Tiger extends Entity {
	
	GamePanel gp;
	int aclc ;

	public ENM_Tiger (GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		maxLife = 4 ;
		life = maxLife;
		getImage();
		
		
	}
	public void getImage() {
		
		up1 = setup("/enemy/enemy_up_1");
		up2 = setup("/enemy/enemy_up_2");
		down1 = setup("/enemy/enemy_down_1");
		down2 = setup("/enemy/enemy_down_2");
		left1 = setup("/enemy/enemy_left_1");
		left2 = setup("/enemy/enemy_left_2");
		right1 = setup("/enemy/enemy_right_1");
		right2 = setup("/enemy/enemy_right_2");
	}
	
	public void setAction() {
		
		actionLockCounter ++;
		
		if(actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100)+1;
		
			if(i <=25 ) {
			direction = "up";
			}
			if(i > 25 && i <= 50) {
			direction = "down";
			}
			if(i > 50 && i <= 75) {
			direction = "left";
			}
			if(i > 75 && i <= 100) {
			direction = "right";
			}
			
			actionLockCounter = 0;
		}
		
			}
	
}