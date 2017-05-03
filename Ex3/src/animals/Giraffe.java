package animals;

import diet.Herbivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

/**
 * One of the five animal classes represent a Giraffe
 *
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see Point
 * @see String
 * @see MessageUtility
 */

public class Giraffe extends AnimalThatChews {

    //attributes
    private double neckLength;

    //constructors:
    public Giraffe(String name) {
        super(name, new Point(50,0));
        MessageUtility.logConstractor("Giraffe", name);
        setWeight(450);
        setNeckLength(1.5);
        setDiet(new Herbivore());
    }

    public Giraffe(String name, double neckLength){
        this(name);
        if(neckLength!=1.5)
            setNeckLength(neckLength);
    }

    //methods:
    /**
     * returns the neckLength attribute
     * @return neckLength
     */
    public double getNeckLength() {
        MessageUtility.logGetter(name,"getNeckLength",neckLength);
        return neckLength;
    }

    /**
     * The neckLength is in range of 1-2.5
     * @param neckLength
     * @return true if the set was successful, false if not
     */
    public boolean setNeckLength(double neckLength) {
        if(neckLength<1||neckLength>2.5) {
            MessageUtility.logSetter(name, "setNeckLength", neckLength, false);
            return false;
        }
        this.neckLength = neckLength;
        MessageUtility.logSetter(name, "setNeckLength", neckLength, true);
        return true;
    }

    /**
     * prints a MessageUtility.logSound:
     * "Bleats and Stomps its legs, then chews"
     */
    @Override
    public void chew() {
        MessageUtility.logSound(name,"Bleats and Stomps its legs, then chews");
    }

    /**
     * implements the IEdible Interface
     * @return MEAT
     */
    @Override
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(name,"getFoodtype",EFoodType.MEAT);
        return EFoodType.MEAT;
    }
}