package main;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame pencere = new JFrame();
		pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pencere.setResizable(false);
		pencere.setTitle("World 2D Tanks");
		
		GamePanel gamePanel = new GamePanel();
		pencere.add(gamePanel);
		
		pencere.pack();
		
		pencere.setLocationRelativeTo(null);
		pencere.setVisible(true);
		
		gamePanel.setupGame();
		gamePanel.startGameThread();
		
	}

}
