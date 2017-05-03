package mobility;
/**
 * a utility Point class which represent a point in 2d
 * @version 26/03/2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see String
 */
public class Point {
    private int x,y;
    private static final int MINx=0,MAXx=800,MINy=0,MAXy=600;

    public Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
    //copy ctor
    public Point(Point other){
        this.x=other.x;
        this.y=other.y;
    }
    /**
     * sets the x axis value
     * @param x the x axis value
     * @return Whether the operation succeeded or not
     */
    public boolean setX(int x) {
        this.x = x;
        return true;
    }
    /**
     * sets the y axis value
     * @param y the y axis value
     * @return Whether the operation succeeded or not
     */
    public boolean setY(int y) {
        this.y = y;
        return true;
    }
    /**
     * @return the object x axis position
     */
    public int getX() {
        return this.x;
    }
    /**
     * @return the object y axis position
     */
    public int getY() {
        return this.y;
    }
    /**
     *  string representation of a Point = (x,y)
     * @return logString of the object name distance and weight
     */

    /**
     * cheacks the if the new point values ar ein boundaries of between 0-800 for x and 0-600 for y
     * @param newLocation
     * @return true if newLocation is in boundaries, false if not
     *
     */
    public static boolean checkBoundaries(Point newLocation) {
        if (newLocation.x<MINx||newLocation.x>MAXx || newLocation.y<MINy||newLocation.y>MAXy)
            return false;
        return true;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString(){
        return this.getX()+","+this.getY();
    }

}
