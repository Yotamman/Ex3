package graphics;

import java.awt.*;

/**
 * Descripiton
 *
 * @author Yotam
 * @version $VERSION 30/04/2017
 * @see
 */
public interface IDrawable {
    public final static String PICTURE_PATH = "…";
    public void loadImages(String nm);
    public void drawObject (Graphics g);
    public String getColor();
}

