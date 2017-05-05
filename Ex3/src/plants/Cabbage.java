package plants;

import utilities.MessageUtility;

import java.awt.*;

/**
 * represent a Cabbage.
 * extends Plant.
 * @author baroh
 * @see plants.Plant
 * @see mobility.ILocatable
 * @see food.IEdible
 */
public class Cabbage extends Plant {
	public Cabbage() {
		MessageUtility.logConstractor("Cabbage", "Cabbage");
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
