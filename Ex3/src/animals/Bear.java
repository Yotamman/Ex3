package animals;
import diet.Omnivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

/**
 * One of the five animal classes represent a Bear
 *
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see Point
 * @see String
 * @see MessageUtility
 */
public class Bear extends AnimalThatRoars {

    //attributes
    private String furColor;

    //constructors:
    public Bear(String name) {
        super(name, new Point(100,5));
        MessageUtility.logConstractor("Bear", name);
        this.setWeight(308.2);
        setFurColor("GRAY");
        this.setDiet(new Omnivore());
    }

    public Bear(String name, String furColor) {
        this(name);
        if(!furColor.equals("GRAY"))
            setFurColor(furColor);
    }

    //methods:
    /**
     * Returns the furColor attribute
     * @return furColor
     */
    public String getFurColor() {
        MessageUtility.logGetter(name, "getFurColor", furColor);
        return furColor;
    }

    /**
     * sets the color of the Bear's fur.
     * Bear's fur color can be BLACK, GRAY or WHITE. Default GRAY
     * @param furColor
     * @return
     */
    public boolean setFurColor(String furColor) {
        if(furColor!="BLACK" && furColor!="WHITE" && furColor!="GRAY"){
            MessageUtility.logSetter(name,"setFurColor",furColor,false);
            return false;
        }
        this.furColor = furColor;
        MessageUtility.logSetter(name,"setFurColor",furColor,true);
        return true;
    }

    /**
     * prints a MessageUtility.logSound:
     * "Stands on its hind legs, roars and scratches its belly"
     */
    @Override
    public void roar() {
        MessageUtility.logSound(name,"Stands on its hind legs, roars and scratches its belly");
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

