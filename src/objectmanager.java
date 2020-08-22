import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class objectmanager implements ActionListener{
	bird flappybird;
	ArrayList<pipes> pipes = new ArrayList<pipes>();
	Random ran = new Random();

	public objectmanager(bird flappybird) {
		this.flappybird = flappybird;
	}

	void addpipe() {
		pipes.add(new pipes(ran.nextInt(gamerunner.width),0,50,50));
	}

	void update() {
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).update();

			if (pipes.get(i).x > gamepanel.WIDTH) {
				pipes.get(i).isActive = false;
			}
		}
	}

	void draw(Graphics graphics) {
		flappybird.draw(graphics);
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).draw(graphics);
		}
	}

	void purgeobjects() {
		for (int i = 0; i < pipes.size(); i++) {
			if (pipes.get(i).isActive == false) {
				pipes.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addpipe();
	}
}
