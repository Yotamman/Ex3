package animals;

import diet.Herbivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * One of the five animal classes represent a Turtle
 *
 * @version 1 April 16th 2017
 * @author  Yotam Zaibel
 * @author Mor Amira
 * @see Point
 * @see String
 * @see MessageUtility
 */
public class Turtle extends AnimalThatChews{

    //attributes
    private int age;

    //constructors:
    public Turtle(String name) {
        super(name, new Point(80,0));
        MessageUtility.logConstractor("Turtle", name);
        setWeight(1);
        setAge(1);
        setDiet(new Herbivore());
    }

    public Turtle(String name, int age ){
        this(name);
        if(age!=1)
            setAge(age);
    }

    //methods:
    /**
     * returns the age attribute
     * @return age
     */
    public int getAge() {
        MessageUtility.logGetter(name,"getAge",age);
        return age;
    }
    /**
     * The age is in range of 0-500
     * @param age
     * @return true if the set was successful, false if not
     */
    public boolean setAge(int age) {
        if(age<0||age>500) {
            MessageUtility.logSetter(name, "setAge", age, false);
            return false;
        }
        this.age = age;
        MessageUtility.logSetter(name, "setAge", age, true);
        return true;
    }

    /**
     * prints a MessageUtility.logSound:
     * "Retracts its head in then eats quietly"
     */
    @Override
    public void chew() {
        MessageUtility.logSound(name,"Retracts its head in then eats quietly");
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

    @Override
    public void loadImages(String nm) {
        try {
            img1= ImageIO.read(new File("src\\graphics\\pictures\\trt_n_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            img2= ImageIO.read(new File("src\\graphics\\pictures\\trt_n_2.png"));
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

