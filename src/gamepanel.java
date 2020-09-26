import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class gamepanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font Subtext;
	Font ending;
	Timer frameDraw;
	Timer pipespawn;
	bird flappybird = new bird(250,375,50,50);
	objectmanager manager = new objectmanager(flappybird);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	

	void Font() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		Subtext = new Font("Arial", Font.PLAIN, 30);
		ending = new Font("Arial", Font.PLAIN, 48);
		
	}

	gamepanel() {
		Font();
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		if (needImage) {
		    loadImage ("background.jpg");
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
	flappybird.fall();
	manager.update();
	//manager.draw(g);
	if (manager.state == true) {
		currentState = END;
	}
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
		g.drawString("click enter to start", 120, 300);
	}

	void drawGameState(Graphics g) {

		System.out.println(gotImage);
		if (gotImage) {
			g.drawImage(image, 0, 0, gamerunner.width, gamerunner.height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, gamerunner.width, gamerunner.height);
		}

		manager.draw(g);
		
	
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 640, 980);
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
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
				manager.state = false;
				flappybird = new bird(250,375,50,50);
				manager = new objectmanager(flappybird);
			} else {
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		
			flappybird.space();
		}
		if (currentState == GAME) {
			startgame();
		} 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	void startgame() {
		 pipespawn = new Timer(3000 , manager);
		    pipespawn.start();
	}

}
