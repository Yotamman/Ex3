package graphics;

import animals.Animal;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Descripiton
 *
 * @author Yotam
 * @version $VERSION 30/04/2017
 * @see
 */
public class ZooPanel extends JPanel implements Runnable {

    private static final int MEAT = 0, CABBAGE = 1, LETTUCE = 2;
    private JPanel buttonPanel;
    private Object background;
    private JButton addAnimalZP;
    private JButton sleepZP;
    private JButton wakeUpZP;
    private JButton clearZP;
    private JButton foodZP;
    private JButton infoZP;
    private JButton exitZP;
    private AddAnimalDialog addAnimalDia;
    private Thread controller; // data member of class ZooPanel
    private ArrayList<Animal> animals;
    private Plant plant;
    private BufferedImage meatImg;
    private JTable animalsTable;


    public ZooPanel(JFrame frame) {
        addAnimalDia = new AddAnimalDialog(frame, this, "Add an Animal Dialog", false);
        addAnimalZP = new JButton("Add Animal");
        sleepZP = new JButton("Sleep");
        wakeUpZP = new JButton("Wake up");
        clearZP = new JButton("Clear All");
        foodZP = new JButton("Food ");
        infoZP = new JButton("Info");
        exitZP = new JButton("Exit");
        buttonPanel = new JPanel();
        plant = null;
        meatImg = null;
        setLayout(new BorderLayout());
        init();
    }

    public void initLettuce(){
        plant=new Lettuce(this);
        meatImg=null;
    }

    public void initCabbage(){
        plant=new Cabbage(this);
        meatImg=null;
    }

    public void init() {
        addAnimalZP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAnimalDia.setVisible(true);
            }
        });


//        infoZP.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JTable animalJTabel = new JTable();
//                String[] columnNames = {"Animal", "Color", "Weight", "Hor. Speed", "Ver. Speed", "Eat Counter"};
//                String[][] data;
//            }
//        });
//

        foodZP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] choices = {"Meat", "Cabbage", "Lettuce"};
                int choice = JOptionPane.showOptionDialog(null, "Please Choose Food", "Food for Animals",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, choices, choices[0]);
                switch (choice) {
                    case MEAT:
                        try {
                            meatImg = ImageIO.read(new File("src\\graphics\\pictures\\Meat.gif"));
                        } catch (IOException e1) {
                            System.out.println("Cannot load image" + "src\\graphics\\pictures\\Meat.gif");
                        }
                        repaint();
                        break;
                    case LETTUCE:
                        initLettuce();
                        repaint();
                        break;
                    case CABBAGE:
                        initCabbage();
                        repaint();
                        break;
                }
            }
        });


 /*       infoZP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] columnNames = {"Animal",`
                        "Color",
                        "Weight",
                        "Hor. Speed",
                        "Ver. Speed",
                        "Eat Counter"};

                String [][] data ={animals.add(new Bear("Baloo"))

                };

            }
        });*/
        buttonPanel.add(addAnimalZP);
        buttonPanel.add(sleepZP);
        buttonPanel.add(wakeUpZP);
        buttonPanel.add(clearZP);
        buttonPanel.add(foodZP);
        buttonPanel.add(infoZP);
        buttonPanel.add(exitZP);
        add(buttonPanel, BorderLayout.SOUTH);
        repaint();
    }//end init()


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background instanceof Image) {
            g.drawImage((Image) background, 0, 0, getWidth(), getHeight(), null);
        } else if (background instanceof Color) {
            setBackground((Color) background);
        }
        if (plant != null)
            plant.drawObject(g);
        if (meatImg != null)
            g.drawImage(meatImg, getWidth() / 2, getHeight() / 2, meatImg.getWidth() / 4, meatImg.getHeight() / 4, null);
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

    public void setBackgroundColor(Color bgColor) {
        background = bgColor;
        repaint();
    }

    public void setBackgroundImage(Image bgImage) {
        background = bgImage;
        repaint();
    }
}
