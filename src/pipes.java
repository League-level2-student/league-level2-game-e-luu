import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class pipes extends gameobject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	Graphics g;
	int score = 0;

	pipes(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 1;
	}

	void update() {
		x -= speed;
		if (x == 0) {
			x = 500;
			score++;
			height = new Random().nextInt(300)+200;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, 200, 30, height);
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

		if (needImage) {
			loadImage("pipe.png");
		}

		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
}
