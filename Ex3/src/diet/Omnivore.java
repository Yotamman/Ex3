package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * Class that defines all eaters.
 * implements the IDiet interface
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see IDiet
 */
public class Omnivore implements IDiet{

    private Herbivore h1;
    private Carnivore c1;

    //constructor
    public Omnivore() {
        this.h1 = new Herbivore();
        this.c1 = new Carnivore();
    }

    /**
     * This method checks if the animal can eat a certain food
     *
     * @param food
     * @return true if it can, false if not
     */
    @Override
    public boolean canEat(EFoodType food) {
        if(h1.canEat(food) || c1.canEat(food))
            return true;
        return false;
    }

    /**
     * This method describes the eating action
     * Eating MEAT causes weight gain of 10% of the current weight.
     * Eating VEGETABLE causes weight gain of 7% of the current weight.
     * @param animal
     * @param food
     * @return true if the eating was successful, false if not
     */
    @Override
    public boolean eat(Animal animal, IEdible food) {
            if(h1.eat(animal,food)||c1.eat(animal,food))
                return true;
            return false;
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
    public String toString() {
        return "[Omnivore]";
    }
}
