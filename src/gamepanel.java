import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class gamepanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font Subtext;
	Font scorekeeper;
	Font ending;
	Timer frameDraw;
	bird flappybird = new bird(250,375,50,50);
	objectmanager manager = new objectmanager(flappybird);
	
	void Font() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		Subtext = new Font("Arial", Font.PLAIN, 30);
		scorekeeper = new Font ("Arial", Font.PLAIN, 20);
		ending = new Font("Arial", Font.PLAIN, 48);
		
	}

	gamepanel() {
		Font();
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
	flappybird.fall();
	manager.update();
	//manager.draw(g);
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, gamerunner.width, gamerunner.height);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Flappy Bird", 95, 150);
		g.setFont(Subtext);
		g.setColor(Color.WHITE);
		g.drawString("click enter to start", 120, 300);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 750);
		g.setFont(scorekeeper);
		g.setColor(Color.WHITE);
		g.drawString("score:", 10, 20);
		//flappybird.draw(g);
		manager.draw(g);
	
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 750);
		g.setFont(ending);
		g.setColor(Color.WHITE);
		g.drawString("you died", 125, 200);
	
	}

	@Override
	public void paintComponent(Graphics g) {
	
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key typed");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key pressed");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("SPACE");
			flappybird.space();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key released");
	}

}
