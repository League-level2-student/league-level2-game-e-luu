import java.awt.Graphics;

public class gameobject {
	int x;
	int y;
	int width;
	int height;
	int space;
	int speed;
	boolean isActive = true;
	gameobject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {
		
	}

	void draw(Graphics g) {
		g.fillRect(x, y, 100, 100);
	}
}

