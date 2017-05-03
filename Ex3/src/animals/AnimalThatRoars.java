package animals;

import mobility.Point;

/**
 * Descripiton
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see Animal
 */
public abstract class AnimalThatRoars extends Animal {

    //constructor
    public AnimalThatRoars(String name, Point location) {
        super(name, location);
    }

    /**
     * Implements the makeSound Method of Animal, based on the relevant animal
     */
    @Override
    public void makeSound() {

        if (this instanceof Bear)
            ((Bear)this).roar();
        if (this instanceof Lion)
            ((Lion)this).roar();
    }

    /**
     * roar method, implemented in the relevant animal class
     */
    public abstract void roar();
}

