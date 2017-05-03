package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * This interface describes functionality of eating
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see EFoodType
 * @see Animal
 * @see IEdible
 */
public interface IDiet {
    /**
     * This method checks if the animal can eat a certain food
     * @param food
     * @return true if it can, false if not
     */
    boolean canEat(EFoodType food);

    /**
     * This method describes the eating action
     * @param animal
     * @param food
     * @return true if the eating was successful, false if not
     */
    boolean eat(Animal animal, IEdible food);
}
