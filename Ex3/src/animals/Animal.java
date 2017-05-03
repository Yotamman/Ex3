package animals;

import diet.IDiet;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Abstract class that defines properties common to all animals.
 * The class extends Mobile and implements IEdible
 * All animals (except lions, which are NOTFOOD) are MEAT
 *
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see Mobile
 * @see food.IEdible
 * @see mobility.ILocatable
 */
public abstract class Animal extends Mobile implements IEdible/**IDrawable IAnimalBehavior, Runnable **/{
    private double weight;
    protected String name;
    private IDiet diet;//used for Eating appropriate food
    protected final int EAT_DISTANCE = 5;
    protected int size;
    protected Color col;
    protected int horSpeed;
    protected int verSpeed;
    protected boolean coordChanged;
    protected Thread thread;
    protected int x_dir;
    protected int y_dir;
    protected int eatCount;
    protected ZooPanel pan;
    protected boolean threadSuspended;
    protected BufferedImage img1, img2;


    public Animal(String name,Point location) {
        super(location);
        MessageUtility.logConstractor("Animal",name);
        setName(name);
    }

    /**
     * set the weight of the animal to the given weight
     * @param weight
     * @return true if successful, false if not
     */
    public boolean setWeight(double weight) {
        if(weight<=0) {
            MessageUtility.logSetter(name,"setWeight",weight,false);
            return false;
        }
        MessageUtility.logSetter(name,"setWeight",weight,true);
        this.weight = weight;
        return true;
    }

    /**
     * returns the weight of the animal
     * @return weight
     */
    public double getWeight() {
        MessageUtility.logGetter(name,"getWeight",weight);
        return weight;
    }

    /**
     * returns the name of the animal
     * @return name
     */
    public String getName() {
        MessageUtility.logGetter(name,"getName",name);
        return name;
    }

    /**
     * set the name of the animal to the given name
     * @param name
     * @return true if successful, false if not
     */
    public boolean setName(String name) {
        if(name!=null){
            MessageUtility.logSetter(name,"setName",name,true);
            this.name = name;
            return true;
        }
        MessageUtility.logSetter(name,"setName",name,false);
        return false;
    }

    /**
     * returns the diet of the animal
     * @return diet
     */
    public IDiet getDiet() {
        MessageUtility.logGetter(name,"getDiet",diet);
        return diet;
    }

    /**
     * set the diet of the animal
     * @param diet
     * @return true if successful, false if not
     */
    public boolean setDiet(IDiet diet) {
        if(diet!=null){
            this.diet = diet;
            MessageUtility.logSetter(name,"setDiet",diet,true);
            return true;
        }
        MessageUtility.logSetter(name,"setDiet",diet,false);
        return false;
    }

    /**
     * After each eating each Animal make their sound.
     * makeSound method activate the relevant method roar/chew, based on the animal type.
     * Utilizes the methods of the diet of the animal.
     *
     * @param food
     */
    public void eat(IEdible food){
        if(diet.eat(this, food)) {
            this.makeSound();
            MessageUtility.logBooleanFunction(name, "eat", food, true);
            if (this instanceof Lion) {
                if ((int) Math.floor(Math.random()*2) == 0)
                    ((Lion) this).setScarCount(((Lion) this).getScarCount() + 1);
            }
        }
        else
            MessageUtility.logBooleanFunction(name,"eat",food,false);
    }

    /**
     * implemented at the relevant classes
     */
    public abstract void makeSound();

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
    public String toString() {
        return "["+this.getClass().getSimpleName()+"] "+name;
    }
}
