package animals;

import diet.Herbivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

/**
 * One of the five animal classes represent a Turtle
 *
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see Point
 * @see String
 * @see MessageUtility
 */
public class Turtle extends AnimalThatChews{

    //attributes
    private int age;

    //constructors:
    public Turtle(String name) {
        super(name, new Point(80,0));
        MessageUtility.logConstractor("Turtle", name);
        setWeight(1);
        setAge(1);
        setDiet(new Herbivore());
    }

    public Turtle(String name, int age ){
        this(name);
        if(age!=1)
            setAge(age);
    }

    //methods:
    /**
     * returns the age attribute
     * @return age
     */
    public int getAge() {
        MessageUtility.logGetter(name,"getAge",age);
        return age;
    }
    /**
     * The age is in range of 0-500
     * @param age
     * @return true if the set was successful, false if not
     */
    public boolean setAge(int age) {
        if(age<0||age>500) {
            MessageUtility.logSetter(name, "setAge", age, false);
            return false;
        }
        this.age = age;
        MessageUtility.logSetter(name, "setAge", age, true);
        return true;
    }

    /**
     * prints a MessageUtility.logSound:
     * "Retracts its head in then eats quietly"
     */
    @Override
    public void chew() {
        MessageUtility.logSound(name,"Retracts its head in then eats quietly");
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

