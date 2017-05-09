package plants;

import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import mobility.ILocatable;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * The class defines the properties shared by all plants.
 * implements the IEdible and ILocatable interfaces
 * @author baroh
 * @see food.IEdible
 * @see mobility.ILocatable
 */
public abstract class Plant implements IEdible, ILocatable , IDrawable {


	private double height;
	private Point location;
	private double weight;
	protected BufferedImage img;
	protected JPanel panel;



	public Plant() {
		Random rand = new Random();
		int x = rand.nextInt(30);
		int y = rand.nextInt(12);
		this.location = new Point(x, y);
		this.height = rand.nextInt(30);
		this.weight = rand.nextInt(12);
		MessageUtility.logConstractor("Plant", "Plant");
		img=null;
	}
	public Plant(JPanel panel){
		this();
		this.panel=panel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see food.IFood#getFoodtype()
	 */
	@Override
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
		return EFoodType.VEGETABLE;
	}

	/**
	 * @return
	 */
	public double getHeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
		return this.height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#getLocation()
	 */
	@Override
	public Point getLocation() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
		return this.location;
	}

	/**
	 * @return
	 */
	public double getWeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
		return weight;
	}

	/**
	 * @param height
	 * @return
	 */
	public boolean setHeight(double height) {

		boolean isSuccess = (height >= 0);
		if (isSuccess) {
			this.height = height;
		} else {
			this.height = 0;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
		return isSuccess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#setLocation(mobility.Point)
	 */
	@Override
	public boolean setLocation(Point newLocation) {
		boolean isSuccess = Point.checkBoundaries(newLocation);
		if (isSuccess) {
			this.location = newLocation;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
		return isSuccess;
	}

	/**
	 * @param weight
	 * @return
	 */
	public boolean setWeight(double weight) {
		boolean isSuccess = (weight >= 0);
		if (isSuccess) {
			this.weight = weight;
		} else {
			this.weight = 0;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);
		return isSuccess;
	}

	@Override
	public void loadImages(String nm) {
		if(this instanceof Lettuce) {
			try {
				img = ImageIO.read(new File("src\\graphics\\pictures\\lettuce.png"));
			} catch (IOException e) {
				System.out.println("Cannot load image");
			}
		}
		if(this instanceof Cabbage){
			try {
				img = ImageIO.read(new File("src\\graphics\\pictures\\cabbage.png"));
			} catch (IOException e) {
				System.out.println("Cannot load image");
			}
		}
	}

	@Override
	public void drawObject(Graphics g) {
		loadImages("");
			g.drawImage(img, panel.getWidth()/2, panel.getHeight()/2, img.getWidth() / 4, img.getHeight() / 4, null);
		}

	@Override
	public String getColor() {
		return null;
	}

	/*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}

}
