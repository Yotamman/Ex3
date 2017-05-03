package mobility;

import animals.Animal;
import privateutil.MathUtilities;
import utilities.MessageUtility;

/**
 * Abstract class that defines a movement in space.
 * implements the ILocatable interface
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see
 */
public abstract class Mobile implements ILocatable{

    //Attributes
    private Point location;//current location
    private double totalDistance;//Distance the object traveled [>0]

    public Mobile(Point location){this.location=new Point(location);
    }

    /**
     * increases totalDistance after movement
     * @param totalDistance
     */
    private void addTotalDistance(double totalDistance){
        this.totalDistance+=totalDistance;
    }

    /**
     * Calculates the distance the object traveled, [>0]
     * @param location
     * @return distance the object traveled, [>0]
     */
    public double calcDistance(Point location){
        return MathUtilities.pitagor(this.location,location);
    }

    /**
     * Moves the object around, updates the new location and the total distance traveled
     * @param location
     * @return distance traveled (0 if non)
     */
    public double move(Point location) {
        if (Point.checkBoundaries(location)) {
            double change = calcDistance(location);//calc the distance traveled
            addTotalDistance(change);//adds it to the total distance traveled
            setLocation(location);//updates the new location
            if (this instanceof Animal) {
                Animal animal=(Animal) this;
                String name=animal.getName();
                double w = animal.getWeight();
                animal.setWeight((w - change * w * 0.00025));
                MessageUtility.logBooleanFunction(name,"move",location,true);
            }
            else{
                MessageUtility.logBooleanFunction(((Animal) this).getName(),"move",location,false);
            }
            return change;
        }
            MessageUtility.logBooleanFunction(((Animal) this).getName(), "move", location, false);
            return 0;
    }

    /**
     * @return totalDistance
     */
    public double getTotalDistance() {
        return totalDistance;
    }

    /**
     * Implementation of the ILocatable interface
     * @return location
     */
    @Override
    public Point getLocation() {
        return this.location;
    }

    /**
     * Implementation of the ILocatable interface
     * @param point
     * @return true if successful, false if not
     */
    @Override
    public boolean setLocation(Point point) {
        if (!Point.checkBoundaries(point))
            return false;
        this.location=point;
        return true;
    }
}
