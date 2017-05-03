package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;


/**
 * class that defines herbivores.
 * implements the IDiet interface
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see IDiet
 */
public class Herbivore implements IDiet{
    /**
     * Checks if the animal can eat a certain food
     * @param food
     * @return true if it can, false if not
     */
    @Override
    public boolean canEat(EFoodType food) {
        if (food.equals(EFoodType.VEGETABLE))
            return true;
        return false;
    }

    /**
     * Describes the eating action
     * Eating VEGETABLE causes weight gain of 7% of the current weight.
     *
     * @param animal
     * @param food
     * @return true if the eating was successful, false if not
     */
    @Override
    public boolean eat(Animal animal, IEdible food) {
        if (canEat(food.getFoodtype())) {
            double w = animal.getWeight();
            animal.setWeight(w * 1.07);
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
        return "[Herbivore]";
    }
}
