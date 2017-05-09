package animals;
import diet.Omnivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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

    @Override
    public void loadImages(String nm) {
        try {
            img1= ImageIO.read(new File("src\\graphics\\pictures\\bea_n_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            img2= ImageIO.read(new File("src\\graphics\\pictures\\bea_n_2.png"));
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
}

