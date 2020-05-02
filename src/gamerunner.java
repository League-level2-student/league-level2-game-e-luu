import java.awt.Dimension;

import javax.swing.JFrame;

public class gamerunner {
	JFrame frame;
	gamepanel panel;
	public static final int width = 500;
	public static final int height = 750;

	gamerunner() {
		frame = new JFrame();
		panel = new gamepanel();
	}

	public static void main(String[] args) {
		gamerunner g = new gamerunner();
		g.setup();
	}

	void setup() {
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
}
