import java.awt.Graphics;
import java.util.ArrayList;

public class objectmanager {
	bird flappybird;
	ArrayList<pipes> pipes = new ArrayList<pipes>();

	public objectmanager(bird flappybird) {
		this.flappybird = flappybird;
	}

	void addpipe(pipes pipe) {

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
}
