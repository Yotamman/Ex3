package plants;

import graphics.ZooPanel;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * represent a Lettuce.
 * extends Plant.
 *
 * @author baroh
 * @see plants.Plant
 * @see mobility.ILocatable
 * @see food.IEdible
 */
public class Lettuce extends Plant {
	public final static String PICTURE_PATH = ZooPanel.PICTURESPATH+"lettuce.png";

	public Lettuce() {
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}


	@Override
	public void loadImages(String nm) {
		try {
			System.out.println(PICTURE_PATH);
			img = ImageIO.read(new File(PICTURE_PATH));
		}
		catch (IOException e) { System.out.println("Cannot load image"); }
	}

	@Override
	public void drawObject(Graphics g) {
		loadImages("");
		g.drawImage(img,200,200,10,10,null);
	}


	@Override
	public String getColor() {
		return null;
	}
}
