package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.SuperObject;
import object.OBJ_Heart;
import object.OBJ_Key;

public class UI {
	
	GamePanel gp;
	Graphics2D g2;
	Font arial_40 , arial_80B;
	BufferedImage keyImage , heart_full , heart_half , heart_blank;
	public boolean messageOn = false;
	public String message ="";
	public boolean gameFinish = false;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial" , Font.PLAIN , 40);
		arial_80B = new Font("Arial" , Font.BOLD , 80);
		OBJ_Key key = new OBJ_Key();
		keyImage = key.image;
		
		SuperObject heart = new OBJ_Heart(gp);
		heart_full = heart.image;
		heart_half = heart.image2;
		heart_blank = heart.image3;
	}
	
	public  void showMessage(String text) {
		
		message = text;
		messageOn = true;
		
	}
	
	public void draw(Graphics2D g2) {
			
		if(gameFinish == true) {
			
			
			
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			
			String text;
			int textLenght;
			int x;
			int y;
			
			text = "Gizli Bilgilere Ulaştın Asker";
			textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLenght/2;
			y = gp.screenHeight/2 - gp.tileSize*3;
			g2.drawString(text, x, y);
			
			g2.setFont(arial_80B);
			g2.setColor(Color.yellow);
			
			text = "TEBRİKLER";
			textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLenght/2;
			y = gp.screenHeight/2 + gp.tileSize*2;
			g2.drawString(text, x, y);
			
			gp.gameThread = null;
			
			
		}else {
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			g2.drawImage(keyImage, gp.tileSize/2 ,96, gp.tileSize, gp.tileSize, null);
			g2.drawString(" x " + gp.player.hasKey, 62, 128);
		}	
		
		this.g2 = g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		if(gp.gameState == gp.playState) {
			drawPlayerLife();
		}
		if(gp.gameState == gp.pauseState) {
			drawPlayerLife();
			drawPauseScreen();
		}
	}
	public void drawPlayerLife() {
		
		
		
		int x = gp.tileSize/2;
		int y = gp.tileSize/2;
		int i = 0;
		
		while(i < gp.player.maxLife/2) {
			g2.drawImage(heart_blank, x +2, y +2,gp.tileSize,gp.tileSize, null);
			i++;
			x += gp.tileSize;
		}
		//reset
		x = gp.tileSize/2;
		y = gp.tileSize/2;
		i = 0;
		
		//
		while(i < gp.player.life) {
			g2.drawImage(heart_half, x +2, y +2,gp.tileSize,gp.tileSize, null);
			i++;
			if(i < gp.player.life) {
				g2.drawImage(heart_full, x +2, y +2,gp.tileSize,gp.tileSize, null);
			}
			i++;
			x += gp.tileSize;
		}
		
	}
	
	public  void drawPauseScreen() {
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
		String text = "Durduruldu";
		int x = getXforCenteredText(text);
		int y = gp.screenHeight/2;
		g2.drawString(text, x, y);
		
	}
	public int getXforCenteredText(String text) {
		
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
	
	
}
