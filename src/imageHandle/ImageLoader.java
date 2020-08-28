package imageHandle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * This class loads the images from res folder , used for icons
 * @author zchem
 *
 */
public class ImageLoader {
	BufferedImage image;
	public BufferedImage getImage(String path)
	{
		try {
			
		    image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			System.err.println(e);
		}
		return image;
	}

}
