package animals;
import diet.Carnivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


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

    @Override
    public void loadImages(String nm) {
        try {
            img1= ImageIO.read(new File("src\\graphics\\pictures\\lio_n_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            img2= ImageIO.read(new File("src\\graphics\\pictures\\lio_n_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawObject(Graphics g) {
        g.setColor(col);
        if(x_dir==1)
            g.drawImage(img1, getLocation().getX()-size/2, getLocation().getY()-size/10, size/2, size, pan);
        else
            g.drawImage(img2, getLocation().getX(), getLocation().getY()-size/10, size/2, size, pan);
    }

    @Override
    public String getColor() {
        return null;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

    }
}