package animals;


import diet.Herbivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

/**
 * animal class that represent a Elephant
 * The trunkLength is in range of 0.5-3 (default 1)
 * extends AnimalThatChews
 *
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see Point
 * @see String
 * @see MessageUtility
 */

public class Elephant extends AnimalThatChews {

    //attributes
    private double trunkLength;

    //constructors:
    public Elephant(String name) {
        super(name,new Point(50,90));
        MessageUtility.logConstractor("Elephant", name);
        setWeight(500);
        setTrunkLength(1);
        setDiet(new Herbivore());
    }

    public Elephant(String name,double trunkLength){
        this(name);
        if(trunkLength!=1)
            setTrunkLength(trunkLength);
    }

    //methods:
    /**
     * returns the trunkLength attribute
     * @return trunkLength
     */
    public double getTrunkLength() {
        MessageUtility.logGetter(name,"getTrunkLength",trunkLength);
        return trunkLength;
    }

    /**
     * The trunkLength is in range of 0.5-3
     * @param trunkLength
     * @return true if the set was successful, false if not
     */
    public boolean setTrunkLength(double trunkLength) {
        if(trunkLength<0.5||trunkLength>3){
            MessageUtility.logSetter(name,"setTrunkLength",trunkLength,false);
            return false;
        }
        this.trunkLength = trunkLength;
        MessageUtility.logSetter(name,"setTrunkLength",trunkLength,true);
        return true;
    }

    /**
     * prints a MessageUtility.logSound:
     * "Trumpets with joy while flapping its ears, then chews"
     */
    @Override
    public void chew() {
        MessageUtility.logSound(name,"Trumpets with joy while flapping its ears, then chews");
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