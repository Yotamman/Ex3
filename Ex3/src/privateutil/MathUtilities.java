package privateutil;


import mobility.Point;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 * defines all the utility mathematical function
 * @version 26/03/2017
 * @author  Yotam Zaibel
 * @see String
 * @see Point
 */
public class MathUtilities {
    /**
     *  Calculates the distance between two points using the Pythagorean theorem
     *  @param a - one point in space
     *  @param b - one point in space
     *  @see Point
     *  @return the distance between the two points
     */
    public static double pitagor(Point a, Point b){
        double dx,dy;
        dx=abs(a.getX()-b.getX());
        dy=abs(a.getY()-b.getY());
        return sqrt(dx*dx+dy*dy);
    }


}
