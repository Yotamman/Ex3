package plants;

import utilities.MessageUtility;

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
}
