package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * This class defines carnivores.
 * implements the IDiet interface
 *
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see IDiet
 */
public class Carnivore implements IDiet {

    /**
     * This method checks if the animal can eat a certain food
     * @param food
     * @return true if it can, false if not
     */
    @Override
    public boolean canEat(EFoodType food) {
        if (food.equals(EFoodType.MEAT))
            return true;
        return false;
    }

    /**
     * This method describes the eating action
     * Eating MEAT causes weight gain of 10% of the current weight.
     *
     * @param animal
     * @param food
     * @return true if the eating was successful, false if not
     *
     */
    @Override
    public boolean eat(Animal animal, IEdible food) {
        if (canEat(food.getFoodtype())) {
            double w = animal.getWeight();
            animal.setWeight(w * 1.1);
            return true;
        }
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
        return "[Carnivore]";
    }
}
