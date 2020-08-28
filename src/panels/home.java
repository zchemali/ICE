package panels;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JPanel;

import imageHandle.ImageLoader;

public class home extends JPanel {
	public home() {
		ImageLoader loader =new ImageLoader();
		Canvas canvas_1 = new Canvas() {
			public void paint (Graphics g) {
				g.drawImage(loader.getImage("/cardPanel.jpg"), 0, 0,1800,1000, null);
			}
		};
		canvas_1.setSize(1800, 1000);
		add(canvas_1);
	}

}
