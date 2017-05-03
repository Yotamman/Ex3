package mobility;
/**
 * This interface describes functionality of location
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 */

public interface ILocatable {

    /**
     * @return the location of the object
     */
    Point getLocation();

    /**
     * set a new location to the object
     * @param point
     * @return if the set was successful
     */
    boolean setLocation(Point point);
}
