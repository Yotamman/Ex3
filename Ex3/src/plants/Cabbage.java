package plants;

import utilities.MessageUtility;

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
}
