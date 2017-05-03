package animals;
import diet.Carnivore;
import food.EFoodType;
import utilities.MessageUtility;
import mobility.Point;


/**
 * One of the five animal classes represent a Lion
 * Cannot be eaten by other animals.
 * each time a lion eats, there is a 50% probability of having +1 scars as a result of the battle with prey.
 *
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see Point
 * @see String
 * @see java.util.Random
 * @see MessageUtility
 */
public class Lion extends AnimalThatRoars{

    //attributes
    private int scarCount;

    //constructor:
    public Lion(String name) {
        super(name,new Point(20,0));
        MessageUtility.logConstractor("Lion", name);
        this.scarCount=0;
        this.setWeight(408.2);
        this.setDiet(new Carnivore());
    }

    //methods:
    /**
     * @return scarCount
     */
    public int getScarCount() {
        MessageUtility.logGetter(name,"getScarCount",scarCount);
        return scarCount;
    }

    public boolean setScarCount(int scarCount){
        if(scarCount<0){
            MessageUtility.logSetter(name,"setScarCount",scarCount,false);
            return false;
        }
        this.scarCount=scarCount;
        MessageUtility.logSetter(name,"setScarCount",scarCount,true);
        return true;
    }

    /**
     * prints a MessageUtility.logSound:
     * "Roars, then stretches and shakes its mane"
     */
    @Override
    public void roar() {
        MessageUtility.logSound(name,"Roars, then stretches and shakes its mane");
    }

    /**
     * implements the IEdible Interface
     * @return NOTFOOD
     */
    @Override
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(name,"getFoodtype",EFoodType.NOTFOOD);
        return EFoodType.NOTFOOD;
    }
}