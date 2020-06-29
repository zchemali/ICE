package imageHandle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	BufferedImage image;
	public BufferedImage getImage(String path)
	{
		try {
			System.out.println("loaded");
			
		    image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			System.err.println(e);
		}
		return image;
	}

}
