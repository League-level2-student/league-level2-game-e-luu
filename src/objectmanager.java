import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class objectmanager implements ActionListener {
	Font scorekeeper;
	bird flappybird;
	pipes pipe;
	Boolean state = false;
	// ArrayList<pipes> pipes = new ArrayList<pipes>();
	Random ran = new Random();

	public objectmanager(bird flappybird) {
		this.flappybird = flappybird;
		pipe = new pipes(500, 200, 30, 500);
		scorekeeper = new Font ("Arial", Font.PLAIN, 20);
	}

	void addpipe() {
		// pipes.add(new pipes(ran.nextInt(gamerunner.width),0,50,50));
	}

	void update() {
		pipe.update();
		if (flappybird.y > pipe.y && flappybird.y < pipe.y + pipe.height && flappybird.x == pipe.x ) {
			state = true;
		}
		// for (int i = 0; i < pipes.size(); i++) {
		// pipes.get(i).update();

		// if (pipes.get(i).x > gamepanel.WIDTH) {
		// pipes.get(i).isActive = false;
		// }
		// }
	}

	void draw(Graphics graphics) {
		flappybird.draw(graphics);
		pipe.draw(graphics);
		graphics.setFont(scorekeeper);
		graphics.setColor(Color.WHITE);
		graphics.drawString("score: "+ pipe.score, 10, 20);
	}

	void purgeobjects() {
		// for (int i = 0; i < pipes.size(); i++) {
		// if (pipes.get(i).isActive == false) {
		// pipes.remove(i);
		// }
		// }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addpipe();
	}
}
