import java.awt.Color;
import java.awt.Graphics;

public class bird extends gameobject {

	bird(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

	public void space() {
		if (y >= 0) {
			y -= 80;
		}
	}

	public void fall() {
		if (y <= 700) {
			y += 1;
		}
	}
}