import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class pipes extends gameobject {
 
	pipes(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 1;
	}

	void update() {
		x = (x -= speed);
	}

	void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(500, 750, width, new Random().nextInt(675)+50);
		g.fillRect(500, 0, width, new Random().nextInt(675)+50);
	}
}
