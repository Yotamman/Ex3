package animals;

import mobility.Point;

/**
 * Descripiton
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see
 */
public abstract class AnimalThatChews extends Animal {

    public AnimalThatChews(String name, Point location) {
        super(name, location);
    }

    /**
     * Implements the makeSound Method of Animal, based on the relevant animal
     */
    @Override
    public void makeSound() {

        if (this instanceof Giraffe)
            ((Giraffe)this).chew();
        if (this instanceof Elephant)
            ((Elephant)this).chew();
        if (this instanceof Turtle)
            ((Turtle)this).chew();
    }

    public abstract void chew();
}
