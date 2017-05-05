package plants;

import utilities.MessageUtility;

import java.awt.*;

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
	public Lettuce() {
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}

	@Override
	public void loadImages(String nm) {

	}

	@Override
	public void drawObject(Graphics g) {

	}

	@Override
	public String getColor() {
		return null;
	}
}
