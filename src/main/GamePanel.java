package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{

	//Ekran Ayarlari
	final int originalTileSize = 16; //16x16 kaplama
	final int scale = 3; //kaplamanin kat sayisi
	
	public final int tileSize = originalTileSize * scale; //48x48 kaplama
	public final int maxScreenCol = 16;//ekran kolon sayisi
	public final int maxScreenRow = 12;//erkan satir sayisi
	public final int screenWidth = tileSize * maxScreenCol; //768 pixel
	public final int screenHeight = tileSize * maxScreenRow;//576 pixel
	
	//World Ayarlari
	public final int maxWorldCol = 54;
	public final int maxWorldRow = 20;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	//FPS
	int FPS = 60;
	
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	
	//Sistem
	Sound music = new Sound();
	Sound se = new Sound();
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	Thread gameThread;
	
	//Entity and object
	public Player player = new Player(this,keyH);
	public SuperObject obj[] = new SuperObject[10];
	public Entity enemy[] = new Entity[20];
	
	
	//Oyuncunun varsayılan pozisyonu
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	//Game State
	public int gameState;
	public final int playState = 1;
	public final int pauseState = 2;
	
	
	public GamePanel () {
		
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	public void setupGame() {
		aSetter.setObject();
		aSetter.setEnemy();
		playMusic(0);
		
		gameState = playState;
	}
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		//çizim aralığı
		double drawInterval = 1000000000/FPS; //0.01666 her saniyede yenileme	
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread != null) {
			
			long currentTime = System.nanoTime();
			
			//1 Update : karakterin pozisyon bilgisi
			update();
			//2 Draw : guncelleme bilgileri
			repaint();
			
			
			
			try {
				double remaningTime = nextDrawTime - System.nanoTime();
				remaningTime = remaningTime/1000000;
				if(remaningTime < 0){
					remaningTime = 0;
				}
								
				Thread.sleep((long) remaningTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void update() {
		
		if(gameState == playState){
				//player
				player.update();
				//npc
				for(int i = 0; i < enemy.length; i++) {
					if(enemy[i] != null) {
						enemy[i].update();
					}
				}
		}
		if(gameState == pauseState ) {
			
		}
	
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		//kaplama
		tileM.draw(g2);
		
		//objeler
		for(int i = 0 ; i < obj.length ; i++) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		//enemy
		for(int i = 0 ; i < enemy.length; i++) {
			if(enemy[i] != null) {
				enemy[i].draw(g2);
			}
		}
		
		//karakter
		player.draw(g2);
		
		//Ui dizayn
		ui.draw(g2);
		
		g2.dispose();
	}
	
	public void playMusic(int i) {
		
		music.setFile(i);
		music.play();
		music.loop();
	}
	public void stopMusic() {
		
		music.stop();
	}
	public void playSE(int i) {
		
		se.setFile(i);
		se.play();
	}
	
}
